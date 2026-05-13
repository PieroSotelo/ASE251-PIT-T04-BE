package com.T04.Fundo.service;

import com.T04.Fundo.entity.Producto;
import com.T04.Fundo.repository.ProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductoService {

    private final ProductoRepository productoRepository;

    public List<Producto> listarTodos() {
        return productoRepository.findAll();
    }

    public Optional<Producto> buscarPorId(Integer id) {
        return productoRepository.findById(id);
    }

    public List<Producto> buscarPorTipo(String tipo) {
        return productoRepository.findByTipoProducto(tipo);
    }

    public Producto guardar(Producto producto) {
        return productoRepository.save(producto);
    }

    public Optional<Producto> actualizar(Integer id, Producto datos) {
        return productoRepository.findById(id).map(p -> {
            p.setNombreProducto(datos.getNombreProducto());
            p.setTipoProducto(datos.getTipoProducto());
            p.setDescripcion(datos.getDescripcion());
            p.setStockActual(datos.getStockActual());
            p.setUnidadMedida(datos.getUnidadMedida());
            return productoRepository.save(p);
        });
    }

    public boolean eliminar(Integer id) {
        if (productoRepository.existsById(id)) {
            productoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
