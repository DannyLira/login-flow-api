package com.login.flow.api.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.login.flow.api.dto.RedefinicaoSenhaDTO;
import com.login.flow.api.model.Usuario;
import com.login.flow.api.repository.UsuarioRepository;

@RestController
public class RedifiniçaoSenhaController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping(value = "/redefinicaoSenhaDTO")
    public Object redefinicaoSenhaDTO (@RequestBody RedefinicaoSenhaDTO redefinicaoSenhaDTO ){
        String email= redefinicaoSenhaDTO.getEmail();
        String senhaAtual= redefinicaoSenhaDTO.getSenhaAtual();
        String novaSenha = redefinicaoSenhaDTO.getNovaSenha();

        Optional<Usuario> usuarioEmail = usuarioRepository.findByEmail(email);

        if( usuarioEmail.isEmpty()){
         return "Usuário não cadastrado ";
         
        }

        Usuario usuario = usuarioEmail.get();
        String senhaUsuario =usuario.getSenha();

        if(!senhaAtual.equals(senhaUsuario)){
         return "Senha inválida";

        }

        
        usuario.setSenha(novaSenha);

        return usuarioRepository.save(usuario);  

    }


}