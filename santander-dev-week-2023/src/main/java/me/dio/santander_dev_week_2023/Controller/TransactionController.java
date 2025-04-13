package me.dio.santander_dev_week_2023.Controller;

import io.swagger.v3.oas.annotations.Operation;
import me.dio.santander_dev_week_2023.DTO.Write.TransferRequestDTO;
import me.dio.santander_dev_week_2023.Enums.PaymentEnum;
import me.dio.santander_dev_week_2023.Response.ApiResponse;
import me.dio.santander_dev_week_2023.Service.Interfaces.ITransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

/**
 * Controlador REST responsável por lidar com requisições relacionadas a transações financeiras dos usuários.
 * <p>
 * Esta classe expõe um endpoint para consultar todas as transações associadas a um usuário específico,
 * identificadas por seu ID.
 * </p>
 *
 * <p>
 * Endpoint base: <code>/v1/transactions</code>
 * </p>
 *
 * <p>
 * Utiliza a interface {@link ITransactionService} para delegar a lógica de negócio relacionada às transações.
 * </p>
 *
 * @author SeuNome
 * @since 1.0
 */
@RestController
@RequestMapping("v1/transactions")
public class TransactionController {

    private final ITransactionService service;

    public TransactionController(ITransactionService service) {
        this.service = service;
    }

    @GetMapping("{userId}")
    @Operation(summary = "Listar todas as transações")
    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "204", description = "Retorno sem conteúdo")
    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Ao retornar uma ou mais transações")
    public ResponseEntity<ApiResponse> ListarTransacoes(@RequestParam Long userId) {
        var result = service.getTransactions(userId);
        return new ResponseEntity<>(result, result.statusMessage);
    }

    @PostMapping("{destinyCpf}")
    @Operation(summary = "Listar todas as transações")
    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "204", description = "Retorno sem conteúdo")
    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Ao retornar uma ou mais transações")
    public ResponseEntity<ApiResponse> Transferir(@PathVariable String destinyCpf, @RequestParam PaymentEnum paymentEnum, @RequestParam BigDecimal value, @RequestBody TransferRequestDTO transferDTO) {
        var result = service.transferir(destinyCpf, transferDTO.cpf, transferDTO.password, paymentEnum, value);
        return new ResponseEntity<>(result, result.statusMessage);
    }
}

