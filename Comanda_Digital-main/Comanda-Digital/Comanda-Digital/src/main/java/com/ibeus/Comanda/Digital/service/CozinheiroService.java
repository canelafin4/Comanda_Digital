package com.ibeus.Comanda.Digital.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibeus.Comanda.Digital.model.Cozinheiro;
import com.ibeus.Comanda.Digital.repository.CozinheiroRepository;

@Service
public class CozinheiroService {

    @Autowired
    private CozinheiroRepository cozinheiroRepository;

    public List<Cozinheiro> getAllCozinheiros() {
        return cozinheiroRepository.findAll();
    }

    public Optional<Cozinheiro> getCozinheiroById(Long id) {
        return cozinheiroRepository.findById(id);
    }

    public Cozinheiro createCozinheiro(Cozinheiro cozinheiro) {
        return cozinheiroRepository.save(cozinheiro);
    }

    public Optional<Cozinheiro> updateCozinheiro(Long id, Cozinheiro cozinheiroDetails) {
        return cozinheiroRepository.findById(id).map(cozinheiro -> {
            cozinheiro.setUserName(cozinheiroDetails.getUserName());
            cozinheiro.setStatus(cozinheiroDetails.getStatus());
            cozinheiro.setSenha(cozinheiroDetails.getSenha()); // Atualiza a senha
            return cozinheiroRepository.save(cozinheiro);
        });
    }

    public boolean deleteCozinheiro(Long id) {
        if (cozinheiroRepository.existsById(id)) {
            cozinheiroRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
