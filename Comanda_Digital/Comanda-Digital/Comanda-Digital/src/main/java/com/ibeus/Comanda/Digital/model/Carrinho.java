package com.ibeus.Comanda.Digital.model;
import java.util.ArrayList;

public class Carrinho {
    private int idCarrinho;
    private int idUser;
    private ArrayList<Prato> pratos;
    private String variante;
    private double valorTotal;

    public Carrinho() {
    }

    public Carrinho(int idCarrinho, int idUser, String variante) {
        this.idCarrinho = idCarrinho;
        this.idUser = idUser;
        this.variante = variante;
        this.pratos = new ArrayList<>();
        this.valorTotal = 0.0;
    }

    public int getIdCarrinho() {
        return idCarrinho;
    }

    public void setIdCarrinho(int idCarrinho) {
        this.idCarrinho = idCarrinho;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public ArrayList<Prato> getPratos() {
        return pratos;
    }

    public String getVariante() {
        return variante;
    }

    public void setVariante(String variante) {
        this.variante = variante;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public void listarItens() {
        for (Prato prato : pratos) {
            System.out.println("Prato: " + prato.getNomePrato() + " - Valor: " + prato.getValorPrato());
        }
    }

    public void adicionarPrato(Prato prato) {
        pratos.add(prato);
        valorTotal += prato.getValorPrato();
        System.out.println("Prato adicionado ao carrinho.");
    }

    public void deletarPrato(Prato prato) {
        if (pratos.remove(prato)) {
            valorTotal -= prato.getValorPrato();
            System.out.println("Prato removido do carrinho.");
        } else {
            System.out.println("Prato não encontrado no carrinho.");
        }
    }

    public void esvaziarCarrinho() {
        pratos.clear();
        valorTotal = 0.0;
        System.out.println("Carrinho esvaziado.");
    }
}
