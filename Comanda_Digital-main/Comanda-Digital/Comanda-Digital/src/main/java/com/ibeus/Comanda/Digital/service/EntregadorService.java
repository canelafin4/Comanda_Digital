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

    public Entregador salvarEntregador(Entregador entregador) {
        return entregadorRepository.save(entregador);
    }

    public List<Entregador> listarTodos() {
        return entregadorRepository.findAll();
    }

    public Optional<Entregador> buscarPorId(Long id) {
        return entregadorRepository.findById(id);
    }

    public void removerEntregador(Long id) {
        entregadorRepository.deleteById(id);
    }

    public Entregador atualizarStatus(Long id, String novoStatus) {
        Optional<Entregador> optionalEntregador = entregadorRepository.findById(id);
        if (optionalEntregador.isPresent()) {
            Entregador entregador = optionalEntregador.get();
            return entregadorRepository.save(entregador);
        }
        throw new RuntimeException("Entregador não encontrado.");
    }
}
