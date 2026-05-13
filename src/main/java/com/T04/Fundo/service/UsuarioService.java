package com.T04.Fundo.service;

import com.T04.Fundo.entity.Usuario;
import com.T04.Fundo.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> buscarPorId(Integer id) {
        return usuarioRepository.findById(id);
    }

    public Optional<Usuario> buscarPorUsuario(String usuario) {
        return usuarioRepository.findByUsuario(usuario);
    }

    public Usuario guardar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Optional<Usuario> actualizar(Integer id, Usuario datos) {
        return usuarioRepository.findById(id).map(u -> {
            u.setNombre(datos.getNombre());
            u.setApellido(datos.getApellido());
            u.setTelefono(datos.getTelefono());
            u.setCargo(datos.getCargo());
            u.setUsuario(datos.getUsuario());
            if (datos.getContrasena() != null && !datos.getContrasena().isBlank()) {
                u.setContrasena(datos.getContrasena());
            }
            return usuarioRepository.save(u);
        });
    }

    public boolean eliminar(Integer id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
