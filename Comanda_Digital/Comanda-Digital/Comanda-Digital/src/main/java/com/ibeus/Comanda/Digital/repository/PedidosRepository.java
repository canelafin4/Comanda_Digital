package com.ibeus.Comanda.Digital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibeus.Comanda.Digital.model.Pedidos;

public interface PedidosRepository extends JpaRepository<Pedidos, Long> {
    // Métodos customizados podem ser adicionados aqui, se necessário
}
