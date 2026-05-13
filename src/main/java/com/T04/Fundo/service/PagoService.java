package com.T04.Fundo.service;

import com.T04.Fundo.entity.Pago;
import com.T04.Fundo.repository.PagoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PagoService {

    private final PagoRepository pagoRepository;

    public List<Pago> listarTodos() {
        return pagoRepository.findAll();
    }

    public Optional<Pago> buscarPorId(Integer id) {
        return pagoRepository.findById(id);
    }

    public List<Pago> buscarPorTrabajador(Integer idTrabajador) {
        return pagoRepository.findByTrabajadorIdTrabajador(idTrabajador);
    }

    public List<Pago> buscarPorRangoFecha(LocalDate inicio, LocalDate fin) {
        return pagoRepository.findByFechaPagoBetween(inicio, fin);
    }

    public Pago guardar(Pago pago) {
        return pagoRepository.save(pago);
    }

    public Optional<Pago> actualizar(Integer id, Pago datos) {
        return pagoRepository.findById(id).map(p -> {
            p.setTrabajador(datos.getTrabajador());
            p.setFechaPago(datos.getFechaPago());
            p.setMonto(datos.getMonto());
            p.setDescripcion(datos.getDescripcion());
            return pagoRepository.save(p);
        });
    }

    public boolean eliminar(Integer id) {
        if (pagoRepository.existsById(id)) {
            pagoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
