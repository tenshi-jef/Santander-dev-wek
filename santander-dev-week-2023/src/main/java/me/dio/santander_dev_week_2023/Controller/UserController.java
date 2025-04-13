package me.dio.santander_dev_week_2023.Controller;

import io.swagger.v3.oas.annotations.Operation;
import me.dio.santander_dev_week_2023.DTO.Write.UserRequestDTO;
import me.dio.santander_dev_week_2023.Response.ApiResponse;
import me.dio.santander_dev_week_2023.Service.Interfaces.IUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/user")
public class UserController {

    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("infos")
    @Operation(summary = "Buscar Todas as Informaçoes do Usuário")
    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "204", description = "Quando nenhum resultado é encontrado")
    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "quando retorna resultado")
    public ResponseEntity<Object> BuscarInformacoesUsuario(@RequestParam Long userId)
    {
        var result = userService.getInfos(userId);
        return ResponseEntity.ok(result);

    }

    @GetMapping
    @Operation(summary = "Buscar todos os usuários")
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
    public ResponseEntity<ApiResponse> BuscarUsuario(@RequestParam Long id)
    {
        var result = userService.getUser(id);
        return new ResponseEntity<>(result, result.statusMessage);
    }

    @PostMapping
    @Operation(summary = "Criar um novo usuário")
    public ResponseEntity<ApiResponse> CriarUsuario(@RequestBody UserRequestDTO dto) {
        var result = userService.create(dto);
        return new ResponseEntity<>(result, result.statusMessage);
    }



    @PutMapping("{id}")
    @Operation(summary = "Atualizar usuário existente")
    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Usuário atualizado com sucesso")
    public ResponseEntity<ApiResponse> AtualizarUsuario(@PathVariable Long id, @RequestBody UserRequestDTO updatedUser) {
        var response = userService.update(id, updatedUser);
        return new ResponseEntity<>(response, response.statusMessage);
    }


    @DeleteMapping("{id}")
    @Operation(summary = "Deletar usuário por id")
    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "204", description = "Usuário deletado com sucesso")
    public ResponseEntity<Object> DeletarUsuario(@PathVariable Long id) {
        var response = userService.delete(id);
        return new ResponseEntity<>(response, response.statusMessage);
    }
}