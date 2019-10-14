package com.curso.tcc.controller;

import com.curso.tcc.controller.form.OrdemServicoForm;
import com.curso.tcc.model.OrdemServico;
import com.curso.tcc.repository.OrdemServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/ordens")
public class OrdemServicoController {

    @Autowired
    private OrdemServicoRepository ordemServicoRepository;

    @PostMapping
    public ResponseEntity<OrdemServico> consultarOrdens(@RequestBody @Valid OrdemServicoForm form) {
        if(form.getPedido() != null && !form.getPedido().equals("") ){
            Optional<OrdemServico> ordemServico = ordemServicoRepository.findByCodOS(form.getPedido());
            if(ordemServico.isPresent()) {
                return ResponseEntity.ok(ordemServico.get());
            }else{
                return ResponseEntity.notFound().build();
            }
        }else if(form.getPlaca() != null && !form.getPlaca().equals("")){
            Optional<OrdemServico> ordemServico = ordemServicoRepository.findByPlacaVeiculo(form.getPlaca());
            if(ordemServico.isPresent()) {
                return ResponseEntity.ok(ordemServico.get());
            }else{
                return ResponseEntity.notFound().build();
            }
        }else{
           return ResponseEntity.notFound().build();
        }
    }
}
