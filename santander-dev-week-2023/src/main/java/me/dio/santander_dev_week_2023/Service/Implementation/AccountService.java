package me.dio.santander_dev_week_2023.Service.Implementation;

import jakarta.transaction.Transactional;
import me.dio.santander_dev_week_2023.DTO.Write.AccountRequestDTO;
import me.dio.santander_dev_week_2023.DTO.Write.CardRequestDTO;
import me.dio.santander_dev_week_2023.DTO.Write.LimitRequestDTO;
import me.dio.santander_dev_week_2023.Mapper.IAccountMapper;
import me.dio.santander_dev_week_2023.Mapper.ICardMapper;
import me.dio.santander_dev_week_2023.Mapper.ILimitMapper;
import me.dio.santander_dev_week_2023.Repository.IAccountRepository;
import me.dio.santander_dev_week_2023.Repository.ICardRepository;
import me.dio.santander_dev_week_2023.Repository.ILimitRepository;
import me.dio.santander_dev_week_2023.Repository.IUserRepository;
import me.dio.santander_dev_week_2023.Response.ApiResponse;
import me.dio.santander_dev_week_2023.Service.Interfaces.IAccountService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Random;

import static me.dio.santander_dev_week_2023.methods.GlobalMethods.AtualizarDados;
import static me.dio.santander_dev_week_2023.methods.GlobalMethods.GerarNumeroCartao;

@Service
public class AccountService implements IAccountService {
    private final IAccountRepository accountRepository;
    private final IUserRepository userRepository;
    private final ICardRepository cardRepository;
    private final ILimitRepository limitRepository;
    private final IAccountMapper accountMapper;
    private final ICardMapper cardMapper;
    private final ILimitMapper limitMapper;

    public AccountService(
            IAccountRepository accountRepository,
            IUserRepository userRepository,
            ICardRepository cardRepository,
            ILimitRepository limitRepository,
            IAccountMapper accountMapper,
            ICardMapper cardMapper,
            ILimitMapper limitMapper)
    {
        this.accountRepository = accountRepository;
        this.userRepository = userRepository;
        this.limitRepository = limitRepository;
        this.cardRepository = cardRepository;
        this.cardMapper = cardMapper;
        this.limitMapper = limitMapper;
        this.accountMapper = accountMapper;
    }

    public ApiResponse get(Long userId) {
        return accountRepository.findByUsuarioId(userId)
                .map(accountMapper::toDto)
                .map(dto -> new ApiResponse(dto, "Conta encontrada", HttpStatus.OK))
                .orElseGet(() -> new ApiResponse(null, "Conta não encontrada para o usuário com ID: " + userId, HttpStatus.NOT_FOUND));
    }

    @Transactional
    public ApiResponse create(Long userId) {
        if(accountRepository.findByUsuarioId(userId).isPresent())
        {
            return new ApiResponse(null, "O usuário já possui uma conta ativa", HttpStatus.UNPROCESSABLE_ENTITY);
        }

        if (!userRepository.existsById(userId))
        {
            return new ApiResponse(null,"Usuário não existe!", HttpStatus.UNPROCESSABLE_ENTITY);
        }

        var requestAuto = new AccountRequestDTO();

        requestAuto.usuarioId = userId;
        requestAuto.numero = "44456434";
        requestAuto.bloqueado = false;
        requestAuto.saldo = BigDecimal.valueOf(00.00);

        var accountEntity = accountMapper.toEntity(requestAuto);
        var accountResult = accountRepository.save(accountEntity);

        var card = new CardRequestDTO();
        var limit = new LimitRequestDTO();

        // informações do cartão geradas automaticamente
        card.contaId = accountResult.getId();
        card.numero = GerarNumeroCartao();

        var cardEntity = cardMapper.toEntity(card);

        // geração do código de segurança
        cardEntity.setCodigoSeguranca(new Random().nextInt(9000) + 1000);

        var cardResult = cardRepository.save(cardEntity);

        // informações do limite
        limit.cartaoId = cardResult.getId();
        limit.saldoDebito = BigDecimal.valueOf(00.00);
        limit.limiteTotal = BigDecimal.valueOf(50.00);
        limit.creditoEspecialTotal = BigDecimal.valueOf(20000.00);
        limit.creditoEspecialDisponivel = BigDecimal.valueOf(50.00);
        limit.creditoEspecialHabilitado = true;

        var limitEntity = limitMapper.toEntity(limit);

        limitRepository.save(limitEntity);

        return new ApiResponse(accountResult.getId(), null, HttpStatus.CREATED);
    }

    public ApiResponse update(Long userId, AccountRequestDTO request) {
        var oldAccount = accountRepository.findByUsuarioId(userId);

        if (oldAccount.isEmpty())
        {
            return new ApiResponse(null, "Nenhuma conta encontrada para o usuário de ID: " + userId, HttpStatus.NOT_FOUND);
        }

        var newUser = accountMapper.toEntity(request);
        var response = AtualizarDados(newUser, oldAccount.get());

        accountRepository.save(response);

        return new ApiResponse(response, null, HttpStatus.OK);
    }

    @Transactional
    public ApiResponse deleteByUserId(Long userId) {
        if (accountRepository.findByUsuarioId(userId).isEmpty())
        {
            throw new RuntimeException("Nenhuma conta encontrada para o usuário com ID: " + userId);
        }

        var result = accountRepository.deleteByUsuarioId(userId);

        return new ApiResponse(result, null, HttpStatus.OK);
    }
}
