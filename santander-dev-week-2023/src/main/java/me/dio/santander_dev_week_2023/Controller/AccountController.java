package me.dio.santander_dev_week_2023.Controller;

import io.swagger.v3.oas.annotations.Operation;
import me.dio.santander_dev_week_2023.DTO.Write.AccountRequestDTO;
import me.dio.santander_dev_week_2023.Response.ApiResponse;
import me.dio.santander_dev_week_2023.Service.Interfaces.IAccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/account")
public class AccountController {
    private final IAccountService service;

    public AccountController(IAccountService service) {
        this.service = service;
    }

    @GetMapping("{id}")
    @Operation(summary = "Buscar  por id")
    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "204", description = "Quando nenhum resultado é encontrado")
    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "quando retorna resultado")
    public ResponseEntity<ApiResponse> BuscarConta(@RequestParam Long id)
    {
        var result = service.get(id);
        return new ResponseEntity<>(result, result.statusMessage);
    }

    @PostMapping("{usuarioId}")
    @Operation(summary = "Criar")
    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "204", description = "Quando nenhum resultado é encontrado")
    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "quando retorna resultado")
    public ResponseEntity<ApiResponse> CriarConta(@RequestParam Long userId)
    {
        var result = service.create(userId);
        return new ResponseEntity<>(result, result.statusMessage);
    }

    @PutMapping("{id}")
    @Operation(summary = "Atualizar")
    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "204", description = "Quando nenhum resultado é encontrado")
    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "quando retorna resultado")
    public ResponseEntity<ApiResponse> AtualizarConta(@RequestParam Long id, @RequestBody AccountRequestDTO requestDTO)
    {
        var result = service.update(id, requestDTO);
        return new ResponseEntity<>(result, result.statusMessage);
    }


    @DeleteMapping("{userId}")
    @Operation(summary = "Deletar por ID")
    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "204", description = "Quando nenhum resultado é encontrado")
    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "quando retorna resultado")
    public ResponseEntity<Object> RemoverConta(@RequestParam Long userId)
    {
        var result = service.deleteByUserId(userId);
        return new ResponseEntity<>(result, result.statusMessage);
    }
}
