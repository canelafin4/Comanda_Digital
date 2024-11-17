package com.ibeus.Comanda.Digital.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibeus.Comanda.Digital.model.Prato;
import com.ibeus.Comanda.Digital.repository.PratoRepository;

@Service
public class PratoService {

    @Autowired
    private PratoRepository pratoRepository;

    public List<Prato> listarTodos() {
        return pratoRepository.findAll();
    }

    public Optional<Prato> buscarPorId(Long id) {
        return pratoRepository.findById(id);
    }

    public Prato salvar(Prato prato) {
        return pratoRepository.save(prato);
    }

    public void deletarPorId(Long id) {
        pratoRepository.deleteById(id);
    }
}
