package br.com.zup.leadCollector.config.security;

import br.com.zup.leadCollector.usuario.Usuario;
import br.com.zup.leadCollector.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioLoginService implements UserDetailsService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Usuario> usuarioOptional = usuarioRepository.findByEmail(email);
        if (usuarioOptional.isEmpty()){
            throw new UsernameNotFoundException("");
        }
        Usuario usuario = usuarioOptional.get();
        return new UsuarioLogado (usuario.getEmail(), usuario.getSenha(), usuario.getId());
    }
}
