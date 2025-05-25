package com.example.aula.controller;

import com.example.aula.model.Jogador;
import com.example.aula.service.JogadorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/jogador")
public class JogadorController {
    private JogadorService jogadorService;

    public JogadorController(JogadorService jogadorService) {
        this.jogadorService = jogadorService;
    }

    @GetMapping
    public List<Jogador> ListarTodos() {
        return jogadorService.Listar();
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> salvar(@Valid @RequestBody Jogador jogador){
        jogadorService.Salvar(jogador);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of("Mensagem", "Cadastrado com sucesso"));

    }

    @PutMapping
    public ResponseEntity<Map<String, Object>> atualizar(@Valid @RequestBody Jogador jogador){
        jogadorService.Atualizar(jogador);
        return ResponseEntity.status(HttpStatus.OK)
                .body(Map.of("Mensagem", "Atualizado com sucesso"));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deletar(@PathVariable Long Id){
        jogadorService.Deletar(Id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(Map.of("Mensagem", "Deletado com sucesso"));

    }

}
