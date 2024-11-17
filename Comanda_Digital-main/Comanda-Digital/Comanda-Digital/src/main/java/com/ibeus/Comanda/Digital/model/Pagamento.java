package com.ibeus.Comanda.Digital.model;

import lombok.Data;

@Data
public class Pagamento {
    private String tipoPagamento; // Opções: "Cartão de Crédito", "Cartão de Débito", "Pix", "Dinheiro"
    private String mensagem;      // Mensagem de retorno após pagamento

    public Pagamento(String tipoPagamento, String mensagem) {
        this.tipoPagamento = tipoPagamento;
        this.mensagem = mensagem;
    }
}
