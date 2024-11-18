package com.ibeus.Comanda.Digital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibeus.Comanda.Digital.model.Carrinho;
import com.ibeus.Comanda.Digital.repository.CarrinhoRepository;

@Service
public class CarrinhoService {

    @Autowired
    private CarrinhoRepository carrinhoRepository;

    public List<Carrinho> findAll() {
        return carrinhoRepository.findAll();
    }

    // Atualiza a quantidade de itens no carrinho
    public Carrinho updateQuantidade(Long id, int quantidade) {
        Carrinho carrinho = carrinhoRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Carrinho não encontrado com o ID: " + id));

        carrinho.setQuantidade(quantidade);
        return carrinhoRepository.save(carrinho);
    }

    // Adiciona um pedido ao carrinho
    public Carrinho addPedido(Long id, int quantidade) {
        Carrinho carrinho = carrinhoRepository.findById(id).orElse(new Carrinho());
        carrinho.setId(id);
        carrinho.setQuantidade(quantidade);
        return carrinhoRepository.save(carrinho);
    }

    // Remove um pedido do carrinho
    public void deletePedido(Long id) {
        if (!carrinhoRepository.existsById(id)) {
            throw new IllegalArgumentException("Carrinho não encontrado com o ID: " + id);
        }
        carrinhoRepository.deleteById(id);
    }
}
