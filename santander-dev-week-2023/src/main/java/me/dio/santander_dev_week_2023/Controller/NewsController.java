package me.dio.santander_dev_week_2023.Controller;

import io.swagger.v3.oas.annotations.Operation;
import me.dio.santander_dev_week_2023.DTO.Write.NewsRequestDTO;
import me.dio.santander_dev_week_2023.Service.Interfaces.INewsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/news")
public class NewsController {

    private final INewsService service;

    public NewsController(INewsService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(summary = "Listar Tudo")
    public ResponseEntity<Object> BuscarNoticias() {
        var result = service.getNews();
        return ResponseEntity.ok(result);
    }

    @GetMapping("{id}")
    @Operation(summary = "Buscar por ID")
    public ResponseEntity<Object> BuscarNoticia(@PathVariable Long id) {
        var result = service.getNew(id);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    @Operation(summary = "Criar")
    public ResponseEntity<Object> CriarNoticia(@RequestBody NewsRequestDTO novaNoticia) {
        var id = service.create(novaNoticia);
        return ResponseEntity.ok(id);
    }

    @PutMapping("{id}")
    @Operation(summary = "Atualizar")
    public ResponseEntity<Object> AtualizarNoticia(@PathVariable Long id, @RequestBody NewsRequestDTO noticiaAtualizada) {
        var idAtualizado = service.update(id);
        return ResponseEntity.ok(idAtualizado);
    }

    @DeleteMapping("{id}")
    @Operation(summary = "Deletar por ID")
    public ResponseEntity<Object> DeletarNoticia(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
