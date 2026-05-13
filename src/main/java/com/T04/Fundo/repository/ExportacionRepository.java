package com.T04.Fundo.repository;

import com.T04.Fundo.entity.Exportacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ExportacionRepository extends JpaRepository<Exportacion, Integer> {
    List<Exportacion> findByVentaIdVenta(Integer idVenta);
    List<Exportacion> findByEstadoExportacion(String estado);
    List<Exportacion> findByPaisDestino(String paisDestino);
}
