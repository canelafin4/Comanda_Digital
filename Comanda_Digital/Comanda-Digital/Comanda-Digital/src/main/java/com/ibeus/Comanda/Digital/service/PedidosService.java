package com.ibeus.Comanda.Digital.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibeus.Comanda.Digital.model.Pedidos;
import com.ibeus.Comanda.Digital.repository.PedidosRepository;

@Service
public class PedidosService {

    @Autowired
    private PedidosRepository pedidosRepository;

    // Adicionar um novo pedido
    public Pedidos salvarPedido(Pedidos pedido) {
        return pedidosRepository.save(pedido);
    }

    // Listar todos os pedidos
    public List<Pedidos> listarTodos() {
        return pedidosRepository.findAll();
    }

    // Buscar pedido por ID
    public Optional<Pedidos> buscarPorId(Long id) {
        return pedidosRepository.findById(id);
    }

    // Atualizar status de um pedido
    public Pedidos atualizarStatus(Long id, String novoStatus) {
        Optional<Pedidos> pedidoOpt = pedidosRepository.findById(id);
        if (pedidoOpt.isPresent()) {
            Pedidos pedido = pedidoOpt.get();
            pedido.setStatus(novoStatus);
            return pedidosRepository.save(pedido);
        }
        throw new RuntimeException("Pedido não encontrado.");
    }

    // Remover um pedido
    public void removerPedido(Long id) {
        pedidosRepository.deleteById(id);
    }
}
