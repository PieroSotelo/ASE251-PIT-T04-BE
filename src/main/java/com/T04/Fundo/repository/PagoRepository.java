package com.T04.Fundo.repository;

import com.T04.Fundo.entity.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface PagoRepository extends JpaRepository<Pago, Integer> {
    List<Pago> findByTrabajadorIdTrabajador(Integer idTrabajador);
    List<Pago> findByFechaPagoBetween(LocalDate inicio, LocalDate fin);
}
