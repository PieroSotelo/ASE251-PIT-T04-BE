package com.T04.Fundo.repository;

import com.T04.Fundo.entity.Trabajador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TrabajadorRepository extends JpaRepository<Trabajador, Integer> {
    List<Trabajador> findByCargo(String cargo);
    List<Trabajador> findByNombreContainingIgnoreCase(String nombre);
}
