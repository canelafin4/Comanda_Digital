package com.ibeus.Comanda.Digital.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Pedidos")
@Data
public class Pedidos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private int idPedido;
    private double valorTotal;
    private String status;
    private String donoPedido;
    private String lanches;
    
}