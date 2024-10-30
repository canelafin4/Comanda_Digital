package com.ibeus.Comanda.Digital.controller;

import com.ibeus.Comanda.Digital.model.Pagamento;
import com.ibeus.Comanda.Digital.service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pagamentos")
public class PagamentoController {

    @Autowired
    private PagamentoService pagamentoService;

    // Listar todos os pagamentos
    @GetMapping
    public List<Pagamento> getAllPagamentos() {
        return pagamentoService.getAllPagamentos();
    }

    // Obter um pagamento pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<Pagamento> getPagamentoById(@PathVariable Long id) {
        Optional<Pagamento> pagamento = pagamentoService.getPagamentoById(id);
        return pagamento.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Criar um novo pagamento
    @PostMapping
    public Pagamento createPagamento(@RequestBody Pagamento pagamento) {
        return pagamentoService.createPagamento(pagamento);
    }

    // Atualizar um pagamento
    @PutMapping("/{id}")
    public ResponseEntity<Pagamento> updatePagamento(@PathVariable Long id, @RequestBody Pagamento pagamentoDetails) {
        Optional<Pagamento> updatedPagamento = pagamentoService.updatePagamento(id, pagamentoDetails);
        return updatedPagamento.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Excluir um pagamento
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePagamento(@PathVariable Long id) {
        if (pagamentoService.deletePagamento(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
