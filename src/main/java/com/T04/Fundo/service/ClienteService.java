package com.T04.Fundo.service;

import com.T04.Fundo.entity.Cliente;
import com.T04.Fundo.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> buscarPorId(Integer id) {
        return clienteRepository.findById(id);
    }

    public List<Cliente> buscarPorTipo(String tipo) {
        return clienteRepository.findByTipoCliente(tipo);
    }

    public Cliente guardar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Optional<Cliente> actualizar(Integer id, Cliente datos) {
        return clienteRepository.findById(id).map(c -> {
            c.setNombreCliente(datos.getNombreCliente());
            c.setTelefono(datos.getTelefono());
            c.setDireccion(datos.getDireccion());
            c.setTipoCliente(datos.getTipoCliente());
            return clienteRepository.save(c);
        });
    }

    public boolean eliminar(Integer id) {
        if (clienteRepository.existsById(id)) {
            clienteRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
