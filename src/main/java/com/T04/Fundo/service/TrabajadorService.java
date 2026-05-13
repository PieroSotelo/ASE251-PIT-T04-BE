package com.T04.Fundo.service;

import com.T04.Fundo.entity.Trabajador;
import com.T04.Fundo.repository.TrabajadorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TrabajadorService {

    private final TrabajadorRepository trabajadorRepository;

    public List<Trabajador> listarTodos() {
        return trabajadorRepository.findAll();
    }

    public Optional<Trabajador> buscarPorId(Integer id) {
        return trabajadorRepository.findById(id);
    }

    public List<Trabajador> buscarPorCargo(String cargo) {
        return trabajadorRepository.findByCargo(cargo);
    }

    public Trabajador guardar(Trabajador trabajador) {
        return trabajadorRepository.save(trabajador);
    }

    public Optional<Trabajador> actualizar(Integer id, Trabajador datos) {
        return trabajadorRepository.findById(id).map(t -> {
            t.setNombre(datos.getNombre());
            t.setApellido(datos.getApellido());
            t.setTelefono(datos.getTelefono());
            t.setCargo(datos.getCargo());
            t.setSueldo(datos.getSueldo());
            return trabajadorRepository.save(t);
        });
    }

    public boolean eliminar(Integer id) {
        if (trabajadorRepository.existsById(id)) {
            trabajadorRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
