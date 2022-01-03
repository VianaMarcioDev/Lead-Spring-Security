package br.com.zup.leadCollector.usuario;

import br.com.zup.leadCollector.usuario.dtos.CadastroUsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping()
    public Usuario cadastrarUsuario(@RequestBody CadastroUsuarioDTO cadastroUsuarioDTO){

        return usuarioService.salvarUsuario(cadastroUsuarioDTO);
    }
}
