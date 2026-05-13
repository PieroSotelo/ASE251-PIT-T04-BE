package com.T04.Fundo.controller;

import com.T04.Fundo.entity.Gasto;
import com.T04.Fundo.service.GastoService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/gastos")
@RequiredArgsConstructor
public class GastoController {

    private final GastoService gastoService;

    @GetMapping
    public List<Gasto> listar() {
        return gastoService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Gasto> buscarPorId(@PathVariable Integer id) {
        return gastoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/tipo/{tipo}")
    public List<Gasto> buscarPorTipo(@PathVariable String tipo) {
        return gastoService.buscarPorTipo(tipo);
    }

    @GetMapping("/rango")
    public List<Gasto> buscarPorRango(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate inicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fin) {
        return gastoService.buscarPorRangoFecha(inicio, fin);
    }

    @PostMapping
    public ResponseEntity<Gasto> crear(@RequestBody Gasto gasto) {
        return ResponseEntity.ok(gastoService.guardar(gasto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Gasto> actualizar(@PathVariable Integer id, @RequestBody Gasto gasto) {
        return gastoService.actualizar(id, gasto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        return gastoService.eliminar(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}
