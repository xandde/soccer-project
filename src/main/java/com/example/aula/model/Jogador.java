package com.example.aula.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Jogador {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "O nome é obrigatório")
    private String nome;

    @NotBlank(message = "O clube é obrigatório")
    private String clube;

    @NotBlank(message = "Aescolha do sexo é obrigatório")
    private Sexo sexo;

    @NotBlank(message = "O número da camisa é obrigatório")
    private String camisa;

    public Jogador() {
    }

    public @NotBlank(message = "O nome é obrigatório") String getNome() {
        return nome;
    }

    public void setNome(@NotBlank(message = "O nome é obrigatório") String nome) {
        this.nome = nome;
    }

    public @NotBlank(message = "O clube é obrigatório") String getClube() {
        return clube;
    }

    public void setClube(@NotBlank(message = "O clube é obrigatório") String clube) {
        this.clube = clube;
    }

    public @NotBlank(message = "Aescolha do sexo é obrigatório") Sexo getSexo() {
        return sexo;
    }

    public void setSexo(@NotBlank(message = "Aescolha do sexo é obrigatório") Sexo sexo) {
        this.sexo = sexo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank(message = "O número da camisa é obrigatório") String getCamisa() {
        return camisa;
    }

    public void setCamisa(@NotBlank(message = "O número da camisa é obrigatório") String camisa) {
        this.camisa = camisa;
    }
}
