package com.ibeus.Comanda.Digital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ibeus.Comanda.Digital.model.Carrinho;
import com.ibeus.Comanda.Digital.service.CarrinhoService;

@RestController
@RequestMapping("/carrinhos")
@CrossOrigin(origins = "http://localhost:4200")
public class CarrinhoController {

    @Autowired
    private CarrinhoService carrinhoService;

    // Retorna todos os itens do carrinho
    @GetMapping
    public List<Carrinho> getAllCarrinho() {
        return carrinhoService.findAll();
    }

    // Atualiza a quantidade de itens no carrinho
    @PutMapping("/{id}/quantidade")
    public Carrinho updateQuantidade(@PathVariable Long id, @RequestParam int quantidade) {
        return carrinhoService.updateQuantidade(id, quantidade);
    }

    // Adiciona um prato ao carrinho pelo ID
    @PostMapping("/{id}")
    public Carrinho addPedido(@PathVariable Long id, @RequestParam int quantidade) {
        return carrinhoService.addPedido(id, quantidade);
    }

    // Remove um prato do carrinho pelo ID
    @DeleteMapping("/{id}")
    public void deletePedido(@PathVariable Long id) {
        carrinhoService.deletePedido(id);
    }
}
