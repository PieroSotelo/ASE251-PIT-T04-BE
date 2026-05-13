package com.T04.Fundo.controller;

import com.T04.Fundo.entity.Trabajador;
import com.T04.Fundo.service.TrabajadorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/trabajadores")
@RequiredArgsConstructor
public class TrabajadorController {

    private final TrabajadorService trabajadorService;

    @GetMapping
    public List<Trabajador> listar() {
        return trabajadorService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trabajador> buscarPorId(@PathVariable Integer id) {
        return trabajadorService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/cargo/{cargo}")
    public List<Trabajador> buscarPorCargo(@PathVariable String cargo) {
        return trabajadorService.buscarPorCargo(cargo);
    }

    @PostMapping
    public ResponseEntity<Trabajador> crear(@RequestBody Trabajador trabajador) {
        return ResponseEntity.ok(trabajadorService.guardar(trabajador));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Trabajador> actualizar(@PathVariable Integer id, @RequestBody Trabajador trabajador) {
        return trabajadorService.actualizar(id, trabajador)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        return trabajadorService.eliminar(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}
