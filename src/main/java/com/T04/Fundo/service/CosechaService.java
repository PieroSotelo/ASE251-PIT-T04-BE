package com.T04.Fundo.service;

import com.T04.Fundo.entity.Cosecha;
import com.T04.Fundo.repository.CosechaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CosechaService {

    private final CosechaRepository cosechaRepository;

    public List<Cosecha> listarTodos() {
        return cosechaRepository.findAll();
    }

    public Optional<Cosecha> buscarPorId(Integer id) {
        return cosechaRepository.findById(id);
    }

    public List<Cosecha> buscarPorProducto(Integer idProducto) {
        return cosechaRepository.findByProductoIdProducto(idProducto);
    }

    public List<Cosecha> buscarPorRangoFecha(LocalDate inicio, LocalDate fin) {
        return cosechaRepository.findByFechaCosechaBetween(inicio, fin);
    }

    public Cosecha guardar(Cosecha cosecha) {
        return cosechaRepository.save(cosecha);
    }

    public Optional<Cosecha> actualizar(Integer id, Cosecha datos) {
        return cosechaRepository.findById(id).map(c -> {
            c.setProducto(datos.getProducto());
            c.setCantidadCosechada(datos.getCantidadCosechada());
            c.setFechaCosecha(datos.getFechaCosecha());
            c.setObservaciones(datos.getObservaciones());
            return cosechaRepository.save(c);
        });
    }

    public boolean eliminar(Integer id) {
        if (cosechaRepository.existsById(id)) {
            cosechaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
