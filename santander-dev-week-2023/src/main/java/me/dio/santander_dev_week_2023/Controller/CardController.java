package me.dio.santander_dev_week_2023.Controller;

import io.swagger.v3.oas.annotations.Operation;
import me.dio.santander_dev_week_2023.Response.ApiResponse;
import me.dio.santander_dev_week_2023.Service.Interfaces.ICardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/card")
public class CardController {

    private final ICardService service;

    public CardController(ICardService service) {
        this.service = service;
    }
    @GetMapping("{id}")
    @Operation(summary = "Buscar por id ")
    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "204", description = "Quando cartao e encontrado ")
    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "quando retorna resultado")
    public ResponseEntity<ApiResponse> BuscarUsuario(@RequestParam Long id)
    {
        var result = service.getCard(id);
        return new ResponseEntity<>(result, result.statusMessage);
    }

    @DeleteMapping("{id}")
    @Operation(summary = "Deletar por ID")
    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "204", description = "Cartao deletado com sucesso")
    public ResponseEntity<ApiResponse> DeletarCartao(@PathVariable Long id) {
        var result = service.delete(id);
        return new ResponseEntity<>(result, result.statusMessage);
    }
}

