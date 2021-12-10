/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dn_tp3_1191513_1181600.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Class Tarefa utilizada para instanciar Tarefas pertencentes aos Colaboradores.
 */
public class Tarefa {
    private String referencia;
    private String designacao;
    private String descricaoInformal;
    private String descricaoCaracterTecnico;
    private double duracao;
    private double custo;
    private Anuncio anuncio;
    private List<CompetenciaTecnica> listaCompt;

    public Tarefa(String referencia, String designacao, String descricaoInformal, String descricaoCaracterTecnico, double duracao, double custo, Anuncio anuncio) {
        if ((designacao == null) || (descricaoInformal == null) || (descricaoCaracterTecnico == null) ||
                (duracao == 0) || (custo == 0))
            throw new IllegalArgumentException("Nenhum dos argumentos pode ser nulo ou vazio.");

        this.referencia = referencia;
        this.designacao = designacao;
        this.descricaoInformal = descricaoInformal;
        this.descricaoCaracterTecnico = descricaoCaracterTecnico;
        this.duracao = duracao;
        this.custo = custo;
        this.anuncio = new Anuncio(anuncio);

    }

    public Tarefa(String referencia, String designacao, String descricaoInformal, String descricaoCaracterTecnico, double duracao, double custo) {
        if ((designacao == null) || (descricaoInformal == null) || (descricaoCaracterTecnico == null) ||
                (duracao == 0) || (custo == 0))
            throw new IllegalArgumentException("Nenhum dos argumentos pode ser nulo ou vazio.");

        this.referencia = referencia;
        this.designacao = designacao;
        this.descricaoInformal = descricaoInformal;
        this.descricaoCaracterTecnico = descricaoCaracterTecnico;
        this.duracao = duracao;
        this.custo = custo;
        this.anuncio = new Anuncio();
        this.listaCompt = new ArrayList<CompetenciaTecnica>();
    }

    public String getReferencia() {
        return referencia;
    }

    public String getDesignacao() {
        return designacao;
    }

    public String getDescricaoInformal() {
        return descricaoInformal;
    }

    public String getDescricaoCaracterTecnico() {
        return descricaoCaracterTecnico;
    }

    public double getDuracao() {
        return duracao;
    }

    public double getCusto() {
        return custo;
    }

    public Anuncio getAnuncio() {
        return new Anuncio(anuncio);
    }

    public List<CompetenciaTecnica> getListaCompt() {
        return listaCompt;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }

    public void setDescricaoInformal(String descricaoInformal) {
        this.descricaoInformal = descricaoInformal;
    }

    public void setDescricaoCaracterTecnico(String descricaoCaracterTecnico) {
        this.descricaoCaracterTecnico = descricaoCaracterTecnico;
    }

    public void setDuracao(double duracao) {
        this.duracao = duracao;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }

    public void setAnuncio(Anuncio anuncio) {
        this.anuncio = new Anuncio(anuncio);
    }


    /**
     * Método equals utilizado para comparar 2 objetos.
     *
     * @param o objeto passado por parâmetro a comparar.
     * return True se objeto for equivalente ao objeto passado por parâmetro.
     * return False se objeto não for equivalente ao objeto passado por parâmetro.
     */
    @Override
    public boolean equals(Object o) {
        // Inspirado em https://www.sitepoint.com/implement-javas-equals-method-correctly/

        // self check
        if (this == o)
            return true;
        // null check
        if (o == null)
            return false;
        // type check and cast
        if (getClass() != o.getClass())
            return false;
        // field comparison
        Tarefa obj = (Tarefa) o;
        return (Objects.equals(designacao, obj.designacao) &&
                Objects.equals(descricaoInformal, obj.descricaoInformal) &&
                Objects.equals(descricaoCaracterTecnico, obj.descricaoCaracterTecnico) &&
                Objects.equals(duracao, obj.duracao) &&
                Objects.equals(custo, obj.custo));
    }

    @Override
    public String toString() {
        return String.format("Designação tarefa : %s \n "
                + "Descrição Informal : %s \n"
                + "Descrição Caracter Técnico : %s \n"
                + "Duração : %f \n"
                + "Custo : %f ", this.designacao, this.descricaoInformal, this.descricaoCaracterTecnico, this.duracao, this.custo);
    }


}   

