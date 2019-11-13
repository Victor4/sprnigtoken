package com.curso.tcc.repository;

import com.curso.tcc.model.OrdemServico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrdemServicoRepository extends JpaRepository<OrdemServico, Long> {

    List<OrdemServico> findByPlacaVeiculo(String placa);

    Optional<OrdemServico> findByCodOS(String codOS);
}
