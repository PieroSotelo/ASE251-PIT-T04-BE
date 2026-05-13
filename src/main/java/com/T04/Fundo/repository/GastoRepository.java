package com.T04.Fundo.repository;

import com.T04.Fundo.entity.Gasto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface GastoRepository extends JpaRepository<Gasto, Integer> {
    List<Gasto> findByTipoGasto(String tipoGasto);
    List<Gasto> findByFechaGastoBetween(LocalDate inicio, LocalDate fin);
}
