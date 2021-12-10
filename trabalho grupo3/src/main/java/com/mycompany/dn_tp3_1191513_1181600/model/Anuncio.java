/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dn_tp3_1191513_1181600.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Class Anuncio utilizada para instanciar Anuncios referentes a Tarefas.
 */
public class Anuncio {

    private Data dtInicioPublicitacao;
    private Data dtFimPublicitacao;
    private Data dtInicioCandidatura;
    private Data dtFimCandidatura;
    private Data dtInicioSeriacao;
    private Data dtFimSeriacao;
    private static final Data DATA_OMISSAO = new Data(0, 0, 0);
    private List<Candidatura> listaCandidatura;


    public Anuncio(Data dtInicioPublicitacao, Data dtFimPublicitacao, Data dtInicioCandidatura, Data dtFimCandidatura, Data dtInicioSeriacao, Data dtFimSeriacao) {
        this.dtInicioPublicitacao = dtInicioPublicitacao;
        this.dtFimPublicitacao = dtFimPublicitacao;
        this.dtInicioCandidatura = dtInicioCandidatura;
        this.dtFimCandidatura = dtFimCandidatura;
        this.dtInicioSeriacao = dtInicioSeriacao;
        this.dtFimSeriacao = dtFimSeriacao;
        this.listaCandidatura = new ArrayList<Candidatura>();
    }


    public Anuncio(Anuncio outroAnuncio) {
        dtInicioPublicitacao = outroAnuncio.getDtInicioPublicitacao();
        dtFimPublicitacao = outroAnuncio.getDtFimPublicitacao();
        dtInicioCandidatura = outroAnuncio.getDtInicioCandidatura();
        dtFimCandidatura = outroAnuncio.getDtFimCandidatura();
        dtInicioSeriacao = outroAnuncio.getDtInicioSeriacao();
        dtFimSeriacao = outroAnuncio.getDtFimSeriacao();
        listaCandidatura = outroAnuncio.getListaCandidatura();
    }

    Anuncio() {
        dtInicioPublicitacao = DATA_OMISSAO;
        dtFimPublicitacao = DATA_OMISSAO;
        dtInicioCandidatura = DATA_OMISSAO;
        dtFimCandidatura = DATA_OMISSAO;
        dtInicioSeriacao = DATA_OMISSAO;
        dtFimSeriacao = DATA_OMISSAO;
    }

    public Data getDtInicioPublicitacao() {
        return dtInicioPublicitacao;
    }

    public Data getDtFimPublicitacao() {
        return dtFimPublicitacao;
    }

    public Data getDtInicioCandidatura() {
        return dtInicioCandidatura;
    }

    public Data getDtFimCandidatura() {
        return dtFimCandidatura;
    }

    public Data getDtInicioSeriacao() {
        return dtInicioSeriacao;
    }

    public Data getDtFimSeriacao() {
        return dtFimSeriacao;
    }

    public List<Candidatura> getListaCandidatura() {
        return listaCandidatura;
    }

    @Override
    public String toString() {
        return String.format("Data inicio", this.dtInicioPublicitacao);
    }

}
