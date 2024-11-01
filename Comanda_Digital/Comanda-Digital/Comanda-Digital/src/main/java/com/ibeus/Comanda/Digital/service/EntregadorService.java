package com.ibeus.Comanda.Digital.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibeus.Comanda.Digital.model.Entregador;
import com.ibeus.Comanda.Digital.repository.EntregadorRepository;

@Service
public class EntregadorService {

    @Autowired
    private EntregadorRepository entregadorRepository;

    // Adicionar um novo entregador
    public Entregador salvarEntregador(Entregador entregador) {
        return entregadorRepository.save(entregador);
    }

    // Listar todos os entregadores
    public List<Entregador> listarTodos() {
        return entregadorRepository.findAll();
    }

    // Buscar um entregador pelo ID
    public Optional<Entregador> buscarPorId(Long id) {
        return entregadorRepository.findById(id);
    }

    // Remover um entregador pelo ID
    public void removerEntregador(Long id) {
        entregadorRepository.deleteById(id);
    }

    // Atualizar status de um entregador
    public Entregador atualizarStatus(Long id, String novoStatus) {
        Optional<Entregador> optionalEntregador = entregadorRepository.findById(id);
        if (optionalEntregador.isPresent()) {
            Entregador entregador = optionalEntregador.get();
            entregador.setStatus(novoStatus);
            return entregadorRepository.save(entregador);
        }
        throw new RuntimeException("Entregador não encontrado.");
    }
}
