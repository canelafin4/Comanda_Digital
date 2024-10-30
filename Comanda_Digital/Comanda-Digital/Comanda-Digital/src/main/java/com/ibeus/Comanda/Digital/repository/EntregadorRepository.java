package com.ibeus.Comanda.Digital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibeus.Comanda.Digital.model.Entregador;

public interface EntregadorRepository extends JpaRepository<Entregador, Long> {
    // Adicione métodos de consulta customizados aqui, se necessário.
}
