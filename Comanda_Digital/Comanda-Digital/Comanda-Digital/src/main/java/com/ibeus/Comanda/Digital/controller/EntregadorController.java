package com.ibeus.Comanda.Digital.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibeus.Comanda.Digital.model.Entregador;
import com.ibeus.Comanda.Digital.service.EntregadorService;

@RestController
@RequestMapping("/entregadores")
public class EntregadorController {

    @Autowired
    private EntregadorService entregadorService;

    // Adicionar um novo entregador
    @PostMapping
    public Entregador adicionarEntregador(@RequestBody Entregador entregador) {
        return entregadorService.salvarEntregador(entregador);
    }

    // Listar todos os entregadores
    @GetMapping
    public List<Entregador> listarEntregadores() {
        return entregadorService.listarTodos();
    }

    // Buscar entregador por ID
    @GetMapping("/{id}")
    public Optional<Entregador> buscarPorId(@PathVariable Long id) {
        return entregadorService.buscarPorId(id);
    }

    // Atualizar o status do entregador
    @PutMapping("/{id}/status")
    public Entregador atualizarStatus(@PathVariable Long id, @RequestBody String novoStatus) {
        return entregadorService.atualizarStatus(id, novoStatus);
    }

    // Remover um entregador
    @DeleteMapping("/{id}")
    public String removerEntregador(@PathVariable Long id) {
        entregadorService.removerEntregador(id);
        return "Entregador removido com sucesso!";
    }
}
