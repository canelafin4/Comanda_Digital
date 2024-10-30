package com.ibeus.Comanda.Digital.repository;

import com.ibeus.Comanda.Digital.model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
    // Métodos personalizados podem ser adicionados aqui, se necessário
}
