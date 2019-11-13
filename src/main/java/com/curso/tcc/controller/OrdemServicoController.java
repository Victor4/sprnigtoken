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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ordens")
public class OrdemServicoController {

    @Autowired
    private OrdemServicoRepository ordemServicoRepository;

    @PostMapping
    public ResponseEntity<List<OrdemServico>> consultarOrdens(@RequestBody @Valid OrdemServicoForm form) {
        List<OrdemServico> ordensServico = receberPedido(form);
        if(ordensServico != null){
            return ResponseEntity.ok(ordensServico);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    private List<OrdemServico> receberPedido(OrdemServicoForm form) {
        List<OrdemServico> ordens = new ArrayList<>();
        Optional<OrdemServico> ordemServico;
        if(form.getPedido() != null){
            if(form.getPedido() != null && !form.getPedido().equals("")){
                ordemServico = ordemServicoRepository.findByCodOS(form.getPedido());
                if(ordemServico.isPresent()) {
                    ordens.add(ordemServico.get());
                    return ordens;
                }
            }else if(form.getPlaca() != null && !form.getPlaca().equals("")){
                ordens = ordemServicoRepository.findByPlacaVeiculo(form.getPlaca());
                return ordens;
            }
        }
        return null;
    }
}
