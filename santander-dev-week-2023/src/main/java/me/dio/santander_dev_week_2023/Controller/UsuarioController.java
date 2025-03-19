package me.dio.santander_dev_week_2023.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.models.responses.ApiResponse;
import me.dio.santander_dev_week_2023.Models.Usuario;
import me.dio.santander_dev_week_2023.Service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    @Operation(summary = "Buscar usuario por id ")
    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "204", description = "Quando nenhum resultado é encontrado")
    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "quando retorna resultado")
    public ResponseEntity<Object> BuscarUsuarios()
    {

        return ResponseEntity.ok("Usuarios");

    }

}
