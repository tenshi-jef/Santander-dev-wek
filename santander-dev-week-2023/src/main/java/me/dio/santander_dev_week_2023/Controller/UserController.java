package me.dio.santander_dev_week_2023.Controller;

import io.swagger.v3.oas.annotations.Operation;
import me.dio.santander_dev_week_2023.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/usuario")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @Operation(summary = "Buscar usuario por id ")
    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "204", description = "Quando nenhum resultado é encontrado")
    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "quando retorna resultado")
    public ResponseEntity<Object> BuscarUsuarios()
    {
        var result = userService.getUsers();
        return ResponseEntity.ok(result);

    }

    @GetMapping("{id}")
    @Operation(summary = "Buscar usuario por id ")
    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "204", description = "Quando nenhum resultado é encontrado")
    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "quando retorna resultado")
    public ResponseEntity<Object> BuscarUsuario(@RequestParam Long id)
    {
        var result = userService.getUser(id);
        return ResponseEntity.ok(result);

    }

}
