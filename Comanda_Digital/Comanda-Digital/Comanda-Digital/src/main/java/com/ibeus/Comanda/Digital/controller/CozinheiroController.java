package com.ibeus.Comanda.Digital.controller;

import com.ibeus.Comanda.Digital.model.Cozinheiro;
import com.ibeus.Comanda.Digital.repository.CozinheiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cozinheiros")
public class CozinheiroController {

    @Autowired
    private CozinheiroRepository cozinheiroRepository;

    // Listar todos os cozinheiros
    @GetMapping
    public List<Cozinheiro> getAllCozinheiros() {
        return cozinheiroRepository.findAll();
    }

    // Obter um cozinheiro pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<Cozinheiro> getCozinheiroById(@PathVariable Long id) {
        Optional<Cozinheiro> cozinheiro = cozinheiroRepository.findById(id);
        return cozinheiro.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Criar um novo cozinheiro
    @PostMapping
    public Cozinheiro createCozinheiro(@RequestBody Cozinheiro cozinheiro) {
        return cozinheiroRepository.save(cozinheiro);
    }

    // Atualizar um cozinheiro
    @PutMapping("/{id}")
    public ResponseEntity<Cozinheiro> updateCozinheiro(@PathVariable Long id, @RequestBody Cozinheiro cozinheiroDetails) {
        Optional<Cozinheiro> optionalCozinheiro = cozinheiroRepository.findById(id);

        if (optionalCozinheiro.isPresent()) {
            Cozinheiro cozinheiro = optionalCozinheiro.get();
            cozinheiro.setUserName(cozinheiroDetails.getUserName());
            cozinheiro.setCargo(cozinheiroDetails.getCargo());
            cozinheiro.setStatus(cozinheiroDetails.getStatus());

            Cozinheiro updatedCozinheiro = cozinheiroRepository.save(cozinheiro);
            return ResponseEntity.ok(updatedCozinheiro);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Excluir um cozinheiro
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