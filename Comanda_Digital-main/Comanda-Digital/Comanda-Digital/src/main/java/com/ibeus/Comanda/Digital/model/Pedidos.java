package com.ibeus.Comanda.Digital.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Pedidos")
@Data
public class Pedidos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_cliente", referencedColumnName = "userId", nullable = false)
    private Cliente cliente;

    private double valorTotal;
    private String status;
    private String donoPedido;
    private String lanches;
}
