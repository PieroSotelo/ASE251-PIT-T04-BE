package com.T04.Fundo.repository;

import com.T04.Fundo.entity.Cosecha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface CosechaRepository extends JpaRepository<Cosecha, Integer> {
    List<Cosecha> findByProductoIdProducto(Integer idProducto);
    List<Cosecha> findByFechaCosechaBetween(LocalDate inicio, LocalDate fin);
}
