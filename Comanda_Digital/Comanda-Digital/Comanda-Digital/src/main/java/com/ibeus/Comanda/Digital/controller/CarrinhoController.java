package com.ibeus.Comanda.Digital.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibeus.Comanda.Digital.model.Carrinho;
import com.ibeus.Comanda.Digital.model.Prato;

@RestController
@RequestMapping("/carrinhos")
public class CarrinhoController {

    // Lista de carrinhos simulando um banco de dados
    private List<Carrinho> listaCarrinhos = new ArrayList<>();

    // Adicionar um novo carrinho
    @PostMapping
    public String criarCarrinho(@RequestBody Carrinho carrinho) {
        listaCarrinhos.add(carrinho);
        return "Carrinho criado com sucesso!";
    }

    // Buscar um carrinho pelo ID
    @GetMapping("/{idCarrinho}")
    public Carrinho buscarCarrinhoPorId(@PathVariable int idCarrinho) {
        return listaCarrinhos.stream()
                .filter(c -> c.getIdCarrinho() == idCarrinho)
                .findFirst()
                .orElse(null);
    }

    // Adicionar um prato a um carrinho
    @PostMapping("/{idCarrinho}/pratos")
    public String adicionarPratoAoCarrinho(@PathVariable int idCarrinho, @RequestBody Prato prato) {
        Carrinho carrinho = buscarCarrinhoPorId(idCarrinho);
        if (carrinho != null) {
            carrinho.adicionarPrato(prato);
            return "Prato adicionado ao carrinho!";
        } else {
            return "Carrinho não encontrado.";
        }
    }

    // Remover um prato de um carrinho
    @DeleteMapping("/{idCarrinho}/pratos")
    public String removerPratoDoCarrinho(@PathVariable int idCarrinho, @RequestBody Prato prato) {
        Carrinho carrinho = buscarCarrinhoPorId(idCarrinho);
        if (carrinho != null) {
            carrinho.deletarPrato(prato);
            return "Prato removido do carrinho!";
        } else {
            return "Carrinho não encontrado.";
        }
    }

    // Listar pratos de um carrinho
    @GetMapping("/{idCarrinho}/pratos")
    public List<Prato> listarPratosDoCarrinho(@PathVariable int idCarrinho) {
        Carrinho carrinho = buscarCarrinhoPorId(idCarrinho);
        if (carrinho != null) {
            return carrinho.getPratos();
        } else {
            return new ArrayList<>();
        }
    }

    // Esvaziar um carrinho
    @DeleteMapping("/{idCarrinho}/esvaziar")
    public String esvaziarCarrinho(@PathVariable int idCarrinho) {
        Carrinho carrinho = buscarCarrinhoPorId(idCarrinho);
        if (carrinho != null) {
            carrinho.esvaziarCarrinho();
            return "Carrinho esvaziado com sucesso!";
        } else {
            return "Carrinho não encontrado.";
        }
    }

    // Obter o valor total de um carrinho
    @GetMapping("/{idCarrinho}/valorTotal")
    public double obterValorTotal(@PathVariable int idCarrinho) {
        Carrinho carrinho = buscarCarrinhoPorId(idCarrinho);
        if (carrinho != null) {
            return carrinho.getValorTotal();
        } else {
            return 0.0;
        }
    }

    // Remover um carrinho
    @DeleteMapping("/{idCarrinho}")
    public String removerCarrinho(@PathVariable int idCarrinho) {
        Carrinho carrinho = buscarCarrinhoPorId(idCarrinho);
        if (carrinho != null) {
            listaCarrinhos.remove(carrinho);
            return "Carrinho removido com sucesso!";
        } else {
            return "Carrinho não encontrado.";
        }
    }
}
