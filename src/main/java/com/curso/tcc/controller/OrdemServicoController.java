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
        OrdemServico ordemServico = receberPedido(form);
        if(ordemServico != null){
            return ResponseEntity.ok(ordemServico);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    private OrdemServico receberPedido(OrdemServicoForm form) {
        Optional<OrdemServico> ordemServico;
        if(form.getPedido() != null){
            if(form.getPedido() != null && !form.getPedido().equals("")){
                ordemServico = ordemServicoRepository.findByCodOS(form.getPedido());
                if(ordemServico.isPresent()) {
                    return ordemServico.get();
                }
            }else if(form.getPlaca() != null && !form.getPlaca().equals("")){
                ordemServico = ordemServicoRepository.findByPlacaVeiculo(form.getPlaca());
                if(ordemServico.isPresent()) {
                    return ordemServico.get();
                }
            }
        }
        return null;
    }
}
