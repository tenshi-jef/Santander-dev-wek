package me.dio.santander_dev_week_2023.Service.Implementation;


import jakarta.transaction.Transactional;
import me.dio.santander_dev_week_2023.DTO.Read.FullResponseDto;
import me.dio.santander_dev_week_2023.DTO.Read.UserResponseDTO;
import me.dio.santander_dev_week_2023.DTO.Write.UserRequestDTO;
import me.dio.santander_dev_week_2023.Mapper.*;
import me.dio.santander_dev_week_2023.Models.Transaction;
import me.dio.santander_dev_week_2023.Repository.*;
import me.dio.santander_dev_week_2023.Response.ApiResponse;
import me.dio.santander_dev_week_2023.Service.Interfaces.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import static me.dio.santander_dev_week_2023.methods.GlobalMethods.AtualizarDados;

@Service
public class UserService implements IUserService {
    private final IUserRepository repository;
    private final IAccountRepository accountRepository;
    private final ICardRepository cardRepository;
    private final ITransactionRepository transactionRepository;
    private final ILimitRepository limitRepository;

    private final IUserMapper userMapper;
    private final IAccountMapper accountMapper;
    private final ITransactionMapper transactionMapper;
    private final ILimitMapper limitMapper;
    private final ICardMapper cardMapper;

    final String className = this.getClass().getName();
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    public UserService(
            IUserRepository repository,
            IAccountRepository accountRepository,
            ICardRepository cardRepository,
            ITransactionRepository transactionRepository,
            ILimitRepository limitRepository,
            IUserMapper userMapper,
            IAccountMapper accountMapper,
            ITransactionMapper transactionMapper,
            ILimitMapper limitMapper,
            ICardMapper cardMapper

    ) {
        this.repository = repository;
        this.accountRepository = accountRepository;
        this.cardRepository = cardRepository;
        this.transactionRepository = transactionRepository;
        this.limitRepository = limitRepository;
        this.userMapper = userMapper;
        this.accountMapper = accountMapper;
        this.transactionMapper = transactionMapper;
        this.limitMapper = limitMapper;
        this.cardMapper = cardMapper;
    }

    public ApiResponse getInfos(Long userId) {
        // dados do usuário
        var user = (UserResponseDTO)getUser(userId).data;

        // entidade conta
        var account = accountRepository.findByUsuarioId(userId).stream().findFirst().get();
        // dto conta
        var accountDTO = accountMapper.toDto(account);

        var card = cardRepository.findByContaId(account.getId()); // 1

        var transactionsOrigin = transactionRepository.findByContaOrigemId(account.getId());
        var transactionsDestiny = transactionRepository.findByContaDestinoId(account.getId());

        List<Transaction> transactionsEntity = new ArrayList<>();
        transactionsEntity.addAll(transactionsOrigin);
        transactionsEntity.addAll(transactionsDestiny);


        var limit = limitRepository.findByCartaoId(account.getId()); // 4

        accountDTO.cartao = cardMapper.toDto(card);
        accountDTO.transacoes = transactionMapper.toDtoList(transactionsEntity);
        accountDTO.cartao.limite = limitMapper.toDto(limit);

        var response = new FullResponseDto(user.id, user.cpf, user.nome, user.email, accountDTO);

        return new ApiResponse(response, null, HttpStatus.OK);
    }

    public ApiResponse getUsers() {
        var usersDTO = new ArrayList<UserResponseDTO>();
        var users = repository.findAll();

        for (var user : users) {
            var userDTO = userMapper.toDto(user);
            usersDTO.add(userDTO);
        }

        return new ApiResponse(usersDTO, null, HttpStatus.OK);
    }

    public ApiResponse getUser(Long id) {
        // pega objeto genérico data do ApiResponse
        var data = getUsers().data;

        // Verifica se o data é uma lista
        if (!(data instanceof List<?> items)) {
            return null;
        }

        // Itera sobre a lista para encontrar o id do usuário
        for (Object item : items) {
            if (item instanceof UserResponseDTO user) {
                if (user.id.equals(id)) {
                    return new ApiResponse(user, null, HttpStatus.OK);
                }
            }
        }

        // Caso não encontre nenhum usuário, retorna erro e uma lista vazia
        return new ApiResponse(List.of(), "Nenhum resultado encontrado", HttpStatus.NOT_FOUND);
    }

    public ApiResponse create(UserRequestDTO newUser) {
        var exists = repository.existsByCpf(newUser.cpf);

        if (Boolean.TRUE.equals(exists))
        {
            return new ApiResponse(null, "Usuário já cadastrado!",  HttpStatus.UNPROCESSABLE_ENTITY);
        }

        var userEntity = userMapper.toEntity(newUser);

        var result = repository.save(userEntity);

        return new ApiResponse(result.getId(), null, HttpStatus.CREATED);
    }

    public ApiResponse update(Long id, UserRequestDTO request) {
        var oldUser = repository.findById(id);

        if (oldUser.isEmpty())
        {
            return new ApiResponse(null, "Usuário não existe!", HttpStatus.NOT_FOUND);
        }

        var newUser = userMapper.toEntity(request);
        var response = AtualizarDados(newUser, oldUser.get());

        repository.save(response);

        return new ApiResponse(response, null, HttpStatus.OK);
    }

    @Transactional
    public ApiResponse delete(Long id) {
        try
        {
            logger.info("[{}] Executando existsById()...", className);
            if (!repository.existsById(id))
            {
                return new ApiResponse(null, "Usuário não encontrado!", HttpStatus.NOT_FOUND);
            }

            logger.info("[{}] Executando deleteById()...", className);
            repository.deleteById(id);

            logger.info("[{}] Retornando resultado...", className);
            return new ApiResponse(id, null, HttpStatus.OK);
        }
        catch (Exception ex)
        {
            logger.error("[{}] Stacktrace Error: %s", className, ex);
            throw ex;
        }

    }
}



