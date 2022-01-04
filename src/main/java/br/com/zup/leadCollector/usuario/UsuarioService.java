package br.com.zup.leadCollector.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private BCryptPasswordEncoder encoder;

    public Usuario salvarUsuario(Usuario usuario){
        //Para encriptar senha do usuario no Banco de Dados

        String senhaEscondida = encoder.encode(usuario.getSenha());

        return usuarioRepository.save(usuario);
    }
}
