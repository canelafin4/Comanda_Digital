package com.ibeus.Comanda.Digital.service;

import com.ibeus.Comanda.Digital.model.Cozinheiro;
import com.ibeus.Comanda.Digital.repository.CozinheiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CozinheiroService {

    @Autowired
    private CozinheiroRepository cozinheiroRepository;

    // Listar todos os cozinheiros
    public List<Cozinheiro> getAllCozinheiros() {
        return cozinheiroRepository.findAll();
    }

    // Obter um cozinheiro pelo ID
    public Optional<Cozinheiro> getCozinheiroById(Long id) {
        return cozinheiroRepository.findById(id);
    }

    // Criar um novo cozinheiro
    public Cozinheiro createCozinheiro(Cozinheiro cozinheiro) {
        return cozinheiroRepository.save(cozinheiro);
    }

    // Atualizar um cozinheiro
    public Optional<Cozinheiro> updateCozinheiro(Long id, Cozinheiro cozinheiroDetails) {
        return cozinheiroRepository.findById(id).map(cozinheiro -> {
            cozinheiro.setUserName(cozinheiroDetails.getUserName());
            cozinheiro.setCargo(cozinheiroDetails.getCargo());
            cozinheiro.setStatus(cozinheiroDetails.getStatus());
            return cozinheiroRepository.save(cozinheiro);
        });
    }

    // Excluir um cozinheiro
    public boolean deleteCozinheiro(Long id) {
        if (cozinheiroRepository.existsById(id)) {
            cozinheiroRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
