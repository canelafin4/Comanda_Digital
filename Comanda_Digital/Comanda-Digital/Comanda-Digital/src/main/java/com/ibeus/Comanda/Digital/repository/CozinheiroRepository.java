package com.ibeus.Comanda.Digital.repository;

import com.ibeus.Comanda.Digital.model.Cozinheiro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CozinheiroRepository extends JpaRepository<Cozinheiro, Long> {
    // Métodos personalizados podem ser adicionados aqui, se necessário
}
