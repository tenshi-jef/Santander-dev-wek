package me.dio.santander_dev_week_2023.Service.Implementation;

import me.dio.santander_dev_week_2023.DTO.Read.TransactionResponseDTO;
import me.dio.santander_dev_week_2023.DTO.Write.TransactionRequestDTO;
import me.dio.santander_dev_week_2023.Enums.PaymentEnum;
import me.dio.santander_dev_week_2023.Mapper.ITransactionMapper;
import me.dio.santander_dev_week_2023.Models.Account;
import me.dio.santander_dev_week_2023.Models.Transaction;
import me.dio.santander_dev_week_2023.Repository.IAccountRepository;
import me.dio.santander_dev_week_2023.Repository.ICardRepository;
import me.dio.santander_dev_week_2023.Repository.ITransactionRepository;
import me.dio.santander_dev_week_2023.Repository.IUserRepository;
import me.dio.santander_dev_week_2023.Response.ApiResponse;
import me.dio.santander_dev_week_2023.Service.Interfaces.ITransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService implements ITransactionService {
    private final ITransactionRepository repository;
    private final IUserRepository userRepository;
    private final IAccountRepository accountRepository;
    private final ITransactionMapper transactionMapper;

    public TransactionService(
            ITransactionRepository repository,
            IAccountRepository accountRepository,
            ICardRepository cardRepository,
            ITransactionMapper transactionMapper,
            IUserRepository userRepository)
    {
        this.repository = repository;
        this.accountRepository = accountRepository;
        this.userRepository = userRepository;
        this.transactionMapper = transactionMapper;
    }

    public ApiResponse getTransactions(Long userId) {
        Optional<Long> accountIdOptional = accountRepository.findByUsuarioId(userId)
                .map(Account::getId);

        if (accountIdOptional.isEmpty()) {
            return new ApiResponse(null, "Nenhuma transação encontrada para o usuário de id: " + userId, HttpStatus.NOT_FOUND);
        }

        Long accountId = accountIdOptional.get();
        List<Transaction> originData = repository.findByContaOrigemId(accountId);
        List<Transaction> destinyData = repository.findByContaDestinoId(accountId);

        var originMapper = transactionMapper.toDtoList(originData);
        var destinyMapper = transactionMapper.toDtoList(destinyData);

        List<TransactionResponseDTO> allTransactions = new ArrayList<>(originMapper);
        allTransactions.addAll(destinyMapper);

        return new ApiResponse(allTransactions, null, HttpStatus.OK);
    }

    public ApiResponse transferir(String destinyCpf, String cpf, String password, PaymentEnum paymentType, BigDecimal value) {
        // 1 - Verificar se o cpf é existente
        var user = userRepository.findByCpf(cpf.trim());
        var userReceive = userRepository.findByCpf(destinyCpf.trim());

        if (user == null || userReceive == null) {
            return new ApiResponse(null, "Cpf não existente!", HttpStatus.NOT_FOUND);
        }

        // 2 - validação de senha
        if (!password.trim().equals(user.getSenha())) {
            return new ApiResponse(null, "Senha inválida!", HttpStatus.UNPROCESSABLE_ENTITY);
        }

        var account = accountRepository.findByUsuarioId(user.getId());
        var accountReceive = accountRepository.findByUsuarioId(userReceive.getId());

        if (account.isEmpty() || accountReceive.isEmpty()) {
            return new ApiResponse(null, "Nenhuma conta cadastrada para o usuário!", HttpStatus.NOT_FOUND);
        }

        // 3 - retirando o valor da conta de quem enviou
        account.get().setSaldoContaCorrente(account.get().getSaldoContaCorrente().subtract(value));

        // 4 - enviar o valor
        accountReceive.get().setSaldoContaCorrente(accountReceive.get().getSaldoContaCorrente().add(value));

        var transaction = new Transaction();
        transaction.setContaDestinoId(accountReceive.get().getId());
        transaction.setContaOrigemId(account.get().getId());
        transaction.setPaymentType(paymentType);
        transaction.setValor(value);

        repository.save(transaction);

        return new ApiResponse(String.format("Pagamento de %f realizado com sucesso para %s", value, userReceive.getNome()), null, HttpStatus.OK);
    }
}
