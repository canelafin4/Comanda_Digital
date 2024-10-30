package com.ibeus.Comanda.Digital.service;

import com.ibeus.Comanda.Digital.model.Pagamento;
import com.ibeus.Comanda.Digital.repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    // Listar todos os pagamentos
    public List<Pagamento> getAllPagamentos() {
        return pagamentoRepository.findAll();
    }

    // Obter um pagamento pelo ID
    public Optional<Pagamento> getPagamentoById(Long id) {
        return pagamentoRepository.findById(id);
    }

    // Criar um novo pagamento
    public Pagamento createPagamento(Pagamento pagamento) {
        return pagamentoRepository.save(pagamento);
    }

    // Atualizar um pagamento
    public Optional<Pagamento> updatePagamento(Long id, Pagamento pagamentoDetails) {
        return pagamentoRepository.findById(id).map(pagamento -> {
            pagamento.setIdPagamento(pagamentoDetails.getIdPagamento());
            pagamento.setTipoPagamento(pagamentoDetails.getTipoPagamento());
            pagamento.setStatus(pagamentoDetails.getStatus());
            pagamento.setValorTotal(pagamentoDetails.getValorTotal());
            return pagamentoRepository.save(pagamento);
        });
    }

    // Excluir um pagamento
    public boolean deletePagamento(Long id) {
        if (pagamentoRepository.existsById(id)) {
            pagamentoRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
