package com.T04.Fundo.service;

import com.T04.Fundo.entity.Gasto;
import com.T04.Fundo.repository.GastoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GastoService {

    private final GastoRepository gastoRepository;

    public List<Gasto> listarTodos() {
        return gastoRepository.findAll();
    }

    public Optional<Gasto> buscarPorId(Integer id) {
        return gastoRepository.findById(id);
    }

    public List<Gasto> buscarPorTipo(String tipo) {
        return gastoRepository.findByTipoGasto(tipo);
    }

    public List<Gasto> buscarPorRangoFecha(LocalDate inicio, LocalDate fin) {
        return gastoRepository.findByFechaGastoBetween(inicio, fin);
    }

    public Gasto guardar(Gasto gasto) {
        return gastoRepository.save(gasto);
    }

    public Optional<Gasto> actualizar(Integer id, Gasto datos) {
        return gastoRepository.findById(id).map(g -> {
            g.setDescripcion(datos.getDescripcion());
            g.setMonto(datos.getMonto());
            g.setFechaGasto(datos.getFechaGasto());
            g.setTipoGasto(datos.getTipoGasto());
            return gastoRepository.save(g);
        });
    }

    public boolean eliminar(Integer id) {
        if (gastoRepository.existsById(id)) {
            gastoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
