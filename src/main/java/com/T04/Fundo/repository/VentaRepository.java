package com.T04.Fundo.repository;

import com.T04.Fundo.entity.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Integer> {
    List<Venta> findByClienteIdCliente(Integer idCliente);
    List<Venta> findByTipoVenta(String tipoVenta);
    List<Venta> findByFechaVentaBetween(LocalDate inicio, LocalDate fin);
}
