package com.T04.Fundo.controller;

import com.T04.Fundo.entity.Cosecha;
import com.T04.Fundo.service.CosechaService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/cosechas")
@RequiredArgsConstructor
public class CosechaController {

    private final CosechaService cosechaService;

    @GetMapping
    public List<Cosecha> listar() {
        return cosechaService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cosecha> buscarPorId(@PathVariable Integer id) {
        return cosechaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/producto/{idProducto}")
    public List<Cosecha> buscarPorProducto(@PathVariable Integer idProducto) {
        return cosechaService.buscarPorProducto(idProducto);
    }

    @GetMapping("/rango")
    public List<Cosecha> buscarPorRango(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate inicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fin) {
        return cosechaService.buscarPorRangoFecha(inicio, fin);
    }

    @PostMapping
    public ResponseEntity<Cosecha> crear(@RequestBody Cosecha cosecha) {
        return ResponseEntity.ok(cosechaService.guardar(cosecha));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cosecha> actualizar(@PathVariable Integer id, @RequestBody Cosecha cosecha) {
        return cosechaService.actualizar(id, cosecha)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        return cosechaService.eliminar(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}
