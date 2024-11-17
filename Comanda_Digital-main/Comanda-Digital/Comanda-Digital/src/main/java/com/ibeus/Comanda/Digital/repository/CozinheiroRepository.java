package com.ibeus.Comanda.Digital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibeus.Comanda.Digital.model.Cozinheiro;

@Repository
public interface CozinheiroRepository extends JpaRepository<Cozinheiro, Long> {

}
