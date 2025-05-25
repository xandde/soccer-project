package com.example.aula.service;

import com.example.aula.model.Jogador;
import com.example.aula.repository.JogadorRepository;
import com.example.aula.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JogadorService {
    private JogadorRepository jogadorRepository;

    public JogadorService(JogadorRepository jogadorRepository) {
        this.jogadorRepository = jogadorRepository;
    }

    public List<Jogador> Listar(){
        return jogadorRepository.findAll();
    }

    public Jogador Salvar(Jogador jogador){
        if (jogadorRepository.findByName(jogador.getNome()).isPresent()){
            throw new RuntimeException("Jogador já cadastrado");
        }
        return jogadorRepository.save(jogador);
    }

    public  Jogador Atualizar(Jogador jogador){
        Jogador jogadorAtualizar = jogadorRepository.findById(jogador.getId())
                .orElseThrow(() -> new RuntimeException("Jogador não existe"));

        jogadorAtualizar.setNome(jogador.getNome());
        jogadorAtualizar.setCamisa(jogador.getCamisa());
        jogadorAtualizar.setClube(jogador.getClube());
        jogadorAtualizar.setSexo(jogador.getSexo());

        return jogadorRepository.save(jogadorAtualizar);
    }

    public void Deletar(Long id) {
        Jogador jogadorAtualizar = jogadorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Jogador não existe"));

        jogadorRepository.deleteById(id);
    }

}
