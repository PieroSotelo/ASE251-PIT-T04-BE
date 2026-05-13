package com.T04.Fundo.repository;

import com.T04.Fundo.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    List<Cliente> findByTipoCliente(String tipoCliente);
    List<Cliente> findByNombreClienteContainingIgnoreCase(String nombre);
}
