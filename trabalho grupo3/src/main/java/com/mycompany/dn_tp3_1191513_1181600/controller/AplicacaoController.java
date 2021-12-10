package com.mycompany.dn_tp3_1191513_1181600.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.mycompany.dn_tp3_1191513_1181600.model.*;

public class AplicacaoController {

    private List<Colaborador> listaColaboradores;
    private List<Tarefa> listaTarefas;
    private List<Candidatura> listaCandidaturas;
    private Seriavel seriacao;

    /**
     * Contrutor da classe AplicacaoController
     */
    public AplicacaoController(){
        listaColaboradores = new ArrayList<Colaborador>();
        listaTarefas = new ArrayList<Tarefa>();
        listaCandidaturas = new ArrayList<Candidatura>();
    }

    /**
     * Método que pede à class que cria as instâncias a partir dos ficheiros de texto
     * a lista de Colaboradores existente. A class LerFicheirosTexto, num contexto de
     * ESOFT, poderia ser chamada de PLataforma.
     *
     * return Lista de Colaboradores.
     */
    public List<Colaborador> getListaColaboradores(){
        return LerFicheirosTexto.getListaColaborador();
    }

    /**
     * Método que pede à class Colaborador a sua lista de Tarefas, retornando-a.
     *
     * return Lista de Tarefas
     */
    public List<Tarefa> getListaTarefasDoColaborador(Colaborador colab) {
        return colab.getListaTarefas();
    }

    /**
     * Método que pede à class Tarefa a sua lista de Candidaturas, retornando-a.
     *
     * return Lista de Candidaturas.
     */
    public List<Candidatura> getListaCandidaturasTarefa(Tarefa tarefa) {
        return tarefa.getAnuncio().getListaCandidatura();
    }

    /**
     * Método que cria as instâncias das Seriações já configuradas e as coloca
     * numa List<Seriavel>, retornando-a.
     *
     * return Lista de Seriações.
     */
    public List<Seriavel> getListaSeriacoes() {
        Seriacao1 ser1 = new Seriacao1();
        Seriacao2 ser2 = new Seriacao2();
        List<Seriavel> listaSeriacoes = new ArrayList<>();
        listaSeriacoes.add(ser1);
        listaSeriacoes.add(ser2);
        return listaSeriacoes;
    }

    /**
     * Método que recebe como parâmetro uma Seriação escolhida pelo utilizador e
     * a guarda como atributo da Controller.
     *
     * @param seriacao Seriação escolhida pela utilizador
     */
    public void transferSeriacaoEscolhida(Seriavel seriacao) {
        this.seriacao = seriacao;
    }

    /**
     * Método que realiza a seriação da lista de Candidaturas passada por parâmetro
     * utilizando a Seriação escolhida pelo utilizador. Classifica as Candidaturas
     * por ordem de seriação.
     *
     * @param listaCandidaturas Lista de Candidaturas a seriar
     */
    public void runSeriacao(List<Candidatura> listaCandidaturas) {
        this.listaCandidaturas = listaCandidaturas;
        Collections.sort(this.listaCandidaturas, seriacao);

        for (int i = 0; i < listaCandidaturas.size(); i++) {
            Candidatura c = listaCandidaturas.get(i);
            int l = i+1;
            c.setClassificacao(l);
        }
    }

    /**
     * Método que retorna a Lista de Candidaturas previamente seriadas.
     *
     * return Lista de Candidaturas.
     */
    public List<Candidatura> getListaCandidaturasSeriadas(){
        return listaCandidaturas;
    }
}
