package com.ibeus.Comanda.Digital.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "carrinho")
@Data
public class Carrinho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idItem; 
    //tirei o id cliente pq tava dando erro #sorry
    @ManyToOne
    @JoinColumn(name = "id_prato", referencedColumnName = "id", nullable = false)
    private Prato prato;

    @Column(nullable = false)
    private Integer quantidade;
}
