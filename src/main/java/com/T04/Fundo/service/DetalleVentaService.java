package com.T04.Fundo.service;

import com.T04.Fundo.entity.DetalleVenta;
import com.T04.Fundo.repository.DetalleVentaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DetalleVentaService {

    private final DetalleVentaRepository detalleVentaRepository;

    public List<DetalleVenta> listarTodos() {
        return detalleVentaRepository.findAll();
    }

    public Optional<DetalleVenta> buscarPorId(Integer id) {
        return detalleVentaRepository.findById(id);
    }

    public List<DetalleVenta> buscarPorVenta(Integer idVenta) {
        return detalleVentaRepository.findByVentaIdVenta(idVenta);
    }

    public List<DetalleVenta> buscarPorProducto(Integer idProducto) {
        return detalleVentaRepository.findByProductoIdProducto(idProducto);
    }

    public DetalleVenta guardar(DetalleVenta detalle) {
        return detalleVentaRepository.save(detalle);
    }

    public Optional<DetalleVenta> actualizar(Integer id, DetalleVenta datos) {
        return detalleVentaRepository.findById(id).map(d -> {
            d.setVenta(datos.getVenta());
            d.setProducto(datos.getProducto());
            d.setCantidad(datos.getCantidad());
            d.setPrecioUnitario(datos.getPrecioUnitario());
            d.setSubtotal(datos.getSubtotal());
            return detalleVentaRepository.save(d);
        });
    }

    public boolean eliminar(Integer id) {
        if (detalleVentaRepository.existsById(id)) {
            detalleVentaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
