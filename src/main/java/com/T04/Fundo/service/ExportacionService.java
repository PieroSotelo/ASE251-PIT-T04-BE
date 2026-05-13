package com.T04.Fundo.service;

import com.T04.Fundo.entity.Exportacion;
import com.T04.Fundo.repository.ExportacionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExportacionService {

    private final ExportacionRepository exportacionRepository;

    public List<Exportacion> listarTodos() {
        return exportacionRepository.findAll();
    }

    public Optional<Exportacion> buscarPorId(Integer id) {
        return exportacionRepository.findById(id);
    }

    public List<Exportacion> buscarPorVenta(Integer idVenta) {
        return exportacionRepository.findByVentaIdVenta(idVenta);
    }

    public List<Exportacion> buscarPorEstado(String estado) {
        return exportacionRepository.findByEstadoExportacion(estado);
    }

    public List<Exportacion> buscarPorPais(String pais) {
        return exportacionRepository.findByPaisDestino(pais);
    }

    public Exportacion guardar(Exportacion exportacion) {
        return exportacionRepository.save(exportacion);
    }

    public Optional<Exportacion> actualizar(Integer id, Exportacion datos) {
        return exportacionRepository.findById(id).map(e -> {
            e.setVenta(datos.getVenta());
            e.setPaisDestino(datos.getPaisDestino());
            e.setFechaExportacion(datos.getFechaExportacion());
            e.setEmpresaTransporte(datos.getEmpresaTransporte());
            e.setEstadoExportacion(datos.getEstadoExportacion());
            return exportacionRepository.save(e);
        });
    }

    public boolean eliminar(Integer id) {
        if (exportacionRepository.existsById(id)) {
            exportacionRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
