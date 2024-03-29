package com.curso.tcc.model.dto;

public class OrdemServicoDto {

    private String codOS;
    private String dataFinalizacao;
    private String dataOS;
    private String descricaoProblema;
    private String descricaoServico;
    private String quilometragem;
    private String statusOS;
    private String totalProdutos;
    private String totalServico;
    private String valorServico;
    private String valorTotal;
    private String placaVeiculo;
    private String chassiVeiculo;
    private String corVeiculo;
    private String marcaVeiculo;
    private String modeloVeiculo;
    private String nomeCliente;

    public OrdemServicoDto(String codOS, String dataFinalizacao, String dataOS, String descricaoProblema, String descricaoServico, String quilometragem, String statusOS, String totalProdutos, String totalServico, String valorServico, String valorTotal, String placaVeiculo, String chassiVeiculo, String corVeiculo, String marcaVeiculo, String modeloVeiculo, String nomeCliente) {
        this.codOS = codOS;
        this.dataFinalizacao = dataFinalizacao;
        this.dataOS = dataOS;
        this.descricaoProblema = descricaoProblema;
        this.descricaoServico = descricaoServico;
        this.quilometragem = quilometragem;
        this.statusOS = statusOS;
        this.totalProdutos = totalProdutos;
        this.totalServico = totalServico;
        this.valorServico = valorServico;
        this.valorTotal = valorTotal;
        this.placaVeiculo = placaVeiculo;
        this.chassiVeiculo = chassiVeiculo;
        this.corVeiculo = corVeiculo;
        this.marcaVeiculo = marcaVeiculo;
        this.modeloVeiculo = modeloVeiculo;
        this.nomeCliente = nomeCliente;
    }

    public String getCodOS() {
        return codOS;
    }

    public void setCodOS(String codOS) {
        this.codOS = codOS;
    }

    public String getDataFinalizacao() {
        return dataFinalizacao;
    }

    public void setDataFinalizacao(String dataFinalizacao) {
        this.dataFinalizacao = dataFinalizacao;
    }

    public String getDataOS() {
        return dataOS;
    }

    public void setDataOS(String dataOS) {
        this.dataOS = dataOS;
    }

    public String getDescricaoProblema() {
        return descricaoProblema;
    }

    public void setDescricaoProblema(String descricaoProblema) {
        this.descricaoProblema = descricaoProblema;
    }

    public String getDescricaoServico() {
        return descricaoServico;
    }

    public void setDescricaoServico(String descricaoServico) {
        this.descricaoServico = descricaoServico;
    }

    public String getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(String quilometragem) {
        this.quilometragem = quilometragem;
    }

    public String getStatusOS() {
        return statusOS;
    }

    public void setStatusOS(String statusOS) {
        this.statusOS = statusOS;
    }

    public String getTotalProdutos() {
        return totalProdutos;
    }

    public void setTotalProdutos(String totalProdutos) {
        this.totalProdutos = totalProdutos;
    }

    public String getTotalServico() {
        return totalServico;
    }

    public void setTotalServico(String totalServico) {
        this.totalServico = totalServico;
    }

    public String getValorServico() {
        return valorServico;
    }

    public void setValorServico(String valorServico) {
        this.valorServico = valorServico;
    }

    public String getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(String valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getPlacaVeiculo() {
        return placaVeiculo;
    }

    public void setPlacaVeiculo(String placaVeiculo) {
        this.placaVeiculo = placaVeiculo;
    }

    public String getChassiVeiculo() {
        return chassiVeiculo;
    }

    public void setChassiVeiculo(String chassiVeiculo) {
        this.chassiVeiculo = chassiVeiculo;
    }

    public String getCorVeiculo() {
        return corVeiculo;
    }

    public void setCorVeiculo(String corVeiculo) {
        this.corVeiculo = corVeiculo;
    }

    public String getMarcaVeiculo() {
        return marcaVeiculo;
    }

    public void setMarcaVeiculo(String marcaVeiculo) {
        this.marcaVeiculo = marcaVeiculo;
    }

    public String getModeloVeiculo() {
        return modeloVeiculo;
    }

    public void setModeloVeiculo(String modeloVeiculo) {
        this.modeloVeiculo = modeloVeiculo;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }
}
