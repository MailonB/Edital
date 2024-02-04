package com.example.demo.Model;

import jakarta.persistence.*;


@Entity
public class Edital {


    @Id
    @Column(nullable = false)
    private int licitacao;
    @Column(nullable = false, columnDefinition = "VARCHAR(255)")
    private String Edital;
    @Column(nullable = false, columnDefinition = "VARCHAR(600)")
    private String Objeto;
    @Column(nullable = false, columnDefinition = "VARCHAR(255)")
    private String modalidade;
    @Column(nullable = false, columnDefinition = "VARCHAR(255)")
    private String tipo;
    @Column(nullable = false, columnDefinition = "VARCHAR(255)")
    private String dtPublicacao;
    @Column(nullable = false, columnDefinition = "VARCHAR(255)")
    private String portal;

    public Edital() {
    }

    public Edital(int licitacao, String edital, String objeto, String modalidade, String tipo, String dtPublicacao, String portal) {
        this.licitacao = licitacao;
        Edital = edital;
        Objeto = objeto;
        this.modalidade = modalidade;
        this.tipo = tipo;
        this.dtPublicacao = dtPublicacao;
        this.portal = portal;
    }

    public String getPortal() {
        return portal;
    }

    public void setPortal(String portal) {
        this.portal = portal;
    }

    public int getLicitacao() {
        return licitacao;
    }

    public void setLicitacao(int licitacao) {
        this.licitacao = licitacao;
    }

    public String getEdital() {
        return Edital;
    }

    public void setEdital(String edital) {
        Edital = edital;
    }

    public String getObjeto() {
        return Objeto;
    }

    public void setObjeto(String objeto) {
        Objeto = objeto;
    }

    public String getModalidade() {
        return modalidade;
    }

    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDtPublicacao() {
        String texto = "" + dtPublicacao;
        return texto;
    }

    public void setDtPublicacao(String dtPublicacao) {
        this.dtPublicacao = dtPublicacao;
    }

    @Override
    public String toString() {
        return "Edital{" +
                "licitacao=" + licitacao +
                ", Edital='" + Edital + '\'' +
                ", Objeto='" + Objeto + '\'' +
                ", modalidade='" + modalidade + '\'' +
                ", tipo='" + tipo + '\'' +
                ", dtPublicacao='" + dtPublicacao + '\'' +
                ", portal='" + portal + '\'' +
                '}';
    }
}


