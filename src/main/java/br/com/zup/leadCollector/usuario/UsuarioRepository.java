package br.com.zup.leadCollector.usuario;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface UsuarioRepositorio extends CrudRepository<Usuario, UUID> {
}
