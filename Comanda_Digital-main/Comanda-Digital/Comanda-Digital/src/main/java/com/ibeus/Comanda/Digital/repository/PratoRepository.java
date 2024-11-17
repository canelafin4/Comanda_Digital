package com.ibeus.Comanda.Digital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ibeus.Comanda.Digital.model.Prato;

public interface PratoRepository extends JpaRepository<Prato, Long> {
}