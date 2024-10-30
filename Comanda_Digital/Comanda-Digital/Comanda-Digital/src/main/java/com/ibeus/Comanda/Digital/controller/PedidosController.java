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

import com.ibeus.Comanda.Digital.model.Pedidos;
import com.ibeus.Comanda.Digital.service.PedidosService;

@RestController
@RequestMapping("/pedidos")
public class PedidosController {

    @Autowired
    private PedidosService pedidosService;

    // Adicionar um novo pedido
    @PostMapping
    public Pedidos adicionarPedido(@RequestBody Pedidos pedido) {
        return pedidosService.salvarPedido(pedido);
    }

    // Listar todos os pedidos
    @GetMapping
    public List<Pedidos> listarPedidos() {
        return pedidosService.listarTodos();
    }

    // Buscar pedido por ID
    @GetMapping("/{id}")
    public Optional<Pedidos> buscarPorId(@PathVariable Long id) {
        return pedidosService.buscarPorId(id);
    }

    // Atualizar status do pedido
    @PutMapping("/{id}/status")
    public Pedidos atualizarStatus(@PathVariable Long id, @RequestBody String novoStatus) {
        return pedidosService.atualizarStatus(id, novoStatus);
    }

    // Remover um pedido
    @DeleteMapping("/{id}")
    public String removerPedido(@PathVariable Long id) {
        pedidosService.removerPedido(id);
        return "Pedido removido com sucesso!";
    }
}
