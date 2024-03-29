package com.curso.tcc.controller;

import com.curso.tcc.controller.form.LoginForm;
import com.curso.tcc.controller.form.Response;
import com.curso.tcc.model.Usuario;
import com.curso.tcc.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.TransactionScoped;
import javax.validation.Valid;

@RestController
@RequestMapping("/cadastro")
public class CadastroController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    @TransactionScoped
    public ResponseEntity<Response> cadastroUsuario(@RequestBody @Valid LoginForm form){
        Usuario usuario = form.converterToUsuario();
        if(usuario == null){
            return ResponseEntity.ok(new Response("0"));
        }
        usuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getSenha()));
        usuarioRepository.save(usuario);
        return ResponseEntity.ok(new Response("1"));
    }
}
