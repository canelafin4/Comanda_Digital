package com.ibeus.Comanda.Digital.model;

public class Prato {
    private String nomePrato;
    private String descricaoPrato;
    private String tipoPrato;
    private double valorPrato;
    private String variante;

    public Prato() {
    }

    public Prato(String nomePrato, String descricaoPrato, String tipoPrato, double valorPrato, String variante) {
        this.nomePrato = nomePrato;
        this.descricaoPrato = descricaoPrato;
        this.tipoPrato = tipoPrato;
        this.valorPrato = valorPrato;
        this.variante = variante;
    }

    public String getNomePrato() {
        return nomePrato;
    }

    public void setNomePrato(String nomePrato) {
        this.nomePrato = nomePrato;
    }

    public String getDescricaoPrato() {
        return descricaoPrato;
    }

    public void setDescricaoPrato(String descricaoPrato) {
        this.descricaoPrato = descricaoPrato;
    }

    public String getTipoPrato() {
        return tipoPrato;
    }

    public void setTipoPrato(String tipoPrato) {
        this.tipoPrato = tipoPrato;
    }

    public double getValorPrato() {
        return valorPrato;
    }

    public void setValorPrato(double valorPrato) {
        this.valorPrato = valorPrato;
    }

    public String getVariante() {
        return variante;
    }

    public void setVariante(String variante) {
        this.variante = variante;
    }

    public void listarPrato() {
        System.out.println("Listando prato: " + nomePrato);
    }

    public void adicionarPrato() {
        System.out.println("Prato adicionado.");
    }

    public void editarPrato() {
        System.out.println("Prato editado.");
    }
}
