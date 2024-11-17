package com.ibeus.Comanda.Digital.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibeus.Comanda.Digital.model.Cozinheiro;
import com.ibeus.Comanda.Digital.repository.CozinheiroRepository;

@RestController
@RequestMapping("/api/cozinheiros")
public class CozinheiroController {

    @Autowired
    private CozinheiroRepository cozinheiroRepository;

    @GetMapping
    public List<Cozinheiro> getAllCozinheiros() {
        return cozinheiroRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cozinheiro> getCozinheiroById(@PathVariable Long id) {
        Optional<Cozinheiro> cozinheiro = cozinheiroRepository.findById(id);
        return cozinheiro.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Cozinheiro createCozinheiro(@RequestBody Cozinheiro cozinheiro) {
        return cozinheiroRepository.save(cozinheiro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cozinheiro> updateCozinheiro(@PathVariable Long id, @RequestBody Cozinheiro cozinheiroDetails) {
        Optional<Cozinheiro> optionalCozinheiro = cozinheiroRepository.findById(id);

        if (optionalCozinheiro.isPresent()) {
            Cozinheiro cozinheiro = optionalCozinheiro.get();
            cozinheiro.setUserName(cozinheiroDetails.getUserName());
            cozinheiro.setStatus(cozinheiroDetails.getStatus());
            cozinheiro.setSenha(cozinheiroDetails.getSenha()); // Atualiza a senha

            Cozinheiro updatedCozinheiro = cozinheiroRepository.save(cozinheiro);
            return ResponseEntity.ok(updatedCozinheiro);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCozinheiro(@PathVariable Long id) {
        if (cozinheiroRepository.existsById(id)) {
            cozinheiroRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
