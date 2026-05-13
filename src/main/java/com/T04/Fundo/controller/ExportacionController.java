package com.T04.Fundo.controller;

import com.T04.Fundo.entity.Exportacion;
import com.T04.Fundo.service.ExportacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/exportaciones")
@RequiredArgsConstructor
public class ExportacionController {

    private final ExportacionService exportacionService;

    @GetMapping
    public List<Exportacion> listar() {
        return exportacionService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Exportacion> buscarPorId(@PathVariable Integer id) {
        return exportacionService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/venta/{idVenta}")
    public List<Exportacion> buscarPorVenta(@PathVariable Integer idVenta) {
        return exportacionService.buscarPorVenta(idVenta);
    }

    @GetMapping("/estado/{estado}")
    public List<Exportacion> buscarPorEstado(@PathVariable String estado) {
        return exportacionService.buscarPorEstado(estado);
    }

    @GetMapping("/pais/{pais}")
    public List<Exportacion> buscarPorPais(@PathVariable String pais) {
        return exportacionService.buscarPorPais(pais);
    }

    @PostMapping
    public ResponseEntity<Exportacion> crear(@RequestBody Exportacion exportacion) {
        return ResponseEntity.ok(exportacionService.guardar(exportacion));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Exportacion> actualizar(@PathVariable Integer id, @RequestBody Exportacion exportacion) {
        return exportacionService.actualizar(id, exportacion)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        return exportacionService.eliminar(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}
