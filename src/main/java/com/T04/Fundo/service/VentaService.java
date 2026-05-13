package com.T04.Fundo.service;

import com.T04.Fundo.entity.Venta;
import com.T04.Fundo.repository.VentaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VentaService {

    private final VentaRepository ventaRepository;

    public List<Venta> listarTodos() {
        return ventaRepository.findAll();
    }

    public Optional<Venta> buscarPorId(Integer id) {
        return ventaRepository.findById(id);
    }

    public List<Venta> buscarPorCliente(Integer idCliente) {
        return ventaRepository.findByClienteIdCliente(idCliente);
    }

    public List<Venta> buscarPorTipo(String tipo) {
        return ventaRepository.findByTipoVenta(tipo);
    }

    public List<Venta> buscarPorRangoFecha(LocalDate inicio, LocalDate fin) {
        return ventaRepository.findByFechaVentaBetween(inicio, fin);
    }

    public Venta guardar(Venta venta) {
        return ventaRepository.save(venta);
    }

    public Optional<Venta> actualizar(Integer id, Venta datos) {
        return ventaRepository.findById(id).map(v -> {
            v.setCliente(datos.getCliente());
            v.setFechaVenta(datos.getFechaVenta());
            v.setTotal(datos.getTotal());
            v.setTipoVenta(datos.getTipoVenta());
            return ventaRepository.save(v);
        });
    }

    public boolean eliminar(Integer id) {
        if (ventaRepository.existsById(id)) {
            ventaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
