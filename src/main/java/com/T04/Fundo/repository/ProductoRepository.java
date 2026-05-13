package com.T04.Fundo.repository;

import com.T04.Fundo.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    List<Producto> findByTipoProducto(String tipoProducto);
    List<Producto> findByNombreProductoContainingIgnoreCase(String nombre);
}
