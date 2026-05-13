package com.T04.Fundo.controller;

import com.T04.Fundo.entity.DetalleVenta;
import com.T04.Fundo.service.DetalleVentaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/detalle-ventas")
@RequiredArgsConstructor
public class DetalleVentaController {

    private final DetalleVentaService detalleVentaService;

    @GetMapping
    public List<DetalleVenta> listar() {
        return detalleVentaService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalleVenta> buscarPorId(@PathVariable Integer id) {
        return detalleVentaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/venta/{idVenta}")
    public List<DetalleVenta> buscarPorVenta(@PathVariable Integer idVenta) {
        return detalleVentaService.buscarPorVenta(idVenta);
    }

    @GetMapping("/producto/{idProducto}")
    public List<DetalleVenta> buscarPorProducto(@PathVariable Integer idProducto) {
        return detalleVentaService.buscarPorProducto(idProducto);
    }

    @PostMapping
    public ResponseEntity<DetalleVenta> crear(@RequestBody DetalleVenta detalle) {
        return ResponseEntity.ok(detalleVentaService.guardar(detalle));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetalleVenta> actualizar(@PathVariable Integer id, @RequestBody DetalleVenta detalle) {
        return detalleVentaService.actualizar(id, detalle)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        return detalleVentaService.eliminar(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}
