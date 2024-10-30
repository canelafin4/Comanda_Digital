package com.ibeus.Comanda.Digital.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "clientes")
@Data
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String userName;

    private String password;

    private String email;

    private String endereco;

    // Método para atualizar o endereço do cliente
    public void atualizarEndereco(String novoEndereco) {
        this.endereco = novoEndereco;
    }

    // Método para trocar a senha
    public void trocarSenha(String novaSenha) {
        this.password = novaSenha;
    }
}
