package com.ibeus.Comanda.Digital.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ibeus.Comanda.Digital.model.Pedidos;
import com.ibeus.Comanda.Digital.service.PedidosService;

@RestController
@RequestMapping("/pedidos")
@CrossOrigin(origins = "http://localhost:4200")
public class PedidosController {

    @Autowired
    private PedidosService pedidosService;

    @PostMapping
    public Pedidos adicionarPedido(@RequestBody Pedidos pedido) {
        return pedidosService.salvarPedido(pedido);
    }

    @GetMapping
    public List<Pedidos> listarPedidos() {
        return pedidosService.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<Pedidos> buscarPorId(@PathVariable Long id) {
        return pedidosService.buscarPorId(id);
    }

    @PutMapping("/{id}/status")
    public Pedidos atualizarStatus(@PathVariable Long id, @RequestBody String novoStatus) {
        return pedidosService.atualizarStatus(id, novoStatus);
    }

    @DeleteMapping("/{id}")
    public String removerPedido(@PathVariable Long id) {
        pedidosService.removerPedido(id);
        return "Pedido removido com sucesso!";
    }
    @GetMapping("/{id}/status")
    public String obterStatus(@PathVariable Long id) {
        Optional<Pedidos> pedido = pedidosService.buscarPorId(id);
        if (pedido.isPresent()) {
            return pedido.get().getStatus();
        } else {
            return "Pedido não encontrado";
        }
    }
}
