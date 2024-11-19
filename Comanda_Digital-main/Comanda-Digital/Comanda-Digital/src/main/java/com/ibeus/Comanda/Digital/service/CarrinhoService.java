package com.ibeus.Comanda.Digital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibeus.Comanda.Digital.model.Carrinho;
import com.ibeus.Comanda.Digital.model.Prato;
import com.ibeus.Comanda.Digital.repository.CarrinhoRepository;
import com.ibeus.Comanda.Digital.repository.PratoRepository;

@Service
public class CarrinhoService {

    @Autowired
    private CarrinhoRepository carrinhoRepository;

    @Autowired
    private PratoRepository pratoRepository;

    public List<Carrinho> listarTodos() {
        return carrinhoRepository.findAll();
    }

    public Carrinho adicionarPratoAoCarrinho(Long pratoId, Integer quantidade) {
        Prato prato = pratoRepository.findById(pratoId)
                .orElseThrow(() -> new RuntimeException("Prato não encontrado!"));

        Carrinho carrinhoExistente = carrinhoRepository.findAll().stream()
                .filter(c -> c.getPrato().getId().equals(pratoId))
                .findFirst()
                .orElse(null);

        if (carrinhoExistente != null) {
            carrinhoExistente.setQuantidade(carrinhoExistente.getQuantidade() + quantidade);
            return carrinhoRepository.save(carrinhoExistente);
        } else {
            Carrinho novoItem = new Carrinho();
            novoItem.setPrato(prato);
            novoItem.setQuantidade(quantidade);
            return carrinhoRepository.save(novoItem);
        }
    }

    public Carrinho atualizarQuantidade(Long idItem, Integer quantidade) {
        Carrinho carrinho = carrinhoRepository.findById(idItem)
                .orElseThrow(() -> new RuntimeException("Item do carrinho não encontrado!"));
        carrinho.setQuantidade(quantidade);
        return carrinhoRepository.save(carrinho);
    }

    public void deletarItem(Long idItem) {
        if (!carrinhoRepository.existsById(idItem)) {
            throw new RuntimeException("Item do carrinho não encontrado!");
        }
        carrinhoRepository.deleteById(idItem);
    }
}
