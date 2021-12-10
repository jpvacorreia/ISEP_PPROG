/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dn_tp3_1191513_1181600.model;

import java.util.List;

/**
 * Class Candidatura utilizada para instanciar Candidaturas realizadas por Freelancers
 * 1 determinada Tarefa.
 */
public class Candidatura {
    private Data dataCand;
    private double custo;
    private int dias;
    private String textoMotivacao;
    private String textoApresentacao;
    private Freelancer freelancer;
    private int classificacao;


    public Candidatura(Data dataCand,double custo, int dias, String textoMotivacao, String textoApresentacao, Freelancer freelancer) {
        this.dataCand = dataCand;
        this.custo = custo;
        this.dias = dias;
        this.textoMotivacao = textoMotivacao;
        this.textoApresentacao = textoApresentacao;
        this.freelancer = new Freelancer(freelancer);
    }
    
    public Candidatura(Data dataCand,double custo, int dias, String textoMotivacao, String textoApresentacao) {
        this.dataCand = dataCand;
        this.custo = custo;
        this.dias = dias;
        this.textoMotivacao = textoMotivacao;
        this.textoApresentacao = textoApresentacao;
        this.freelancer = new Freelancer();
       
    }

    public Data getDataCand() {
        return dataCand;
    }
    

    public double getCusto() {
        return custo;
    }

    public int getDias() {
        return dias;
    }

    public String getTextoApresentacao() {
        return textoApresentacao;
    }

    public String getTextoMotivacao() {
        return textoMotivacao;
    }

    public Freelancer getFreelancer() {
        return new Freelancer(freelancer);
    }

    public int getClassificacao() {
        return classificacao;
    }

    public void setFreelancer(Freelancer freelancer) {
        this.freelancer = new Freelancer(freelancer); 
    }

    public void setClassificacao(int classificacao) {
        this.classificacao = classificacao;
    }

    /**
     * Método equals utilizado para comparar 2 objetos.
     *
     * @param o objeto passado por parâmetro a comparar.
     * return True se objeto for equivalente ao objeto passado por parâmetro.
     * return False se objeto não for equivalente ao objeto passado por parâmetro.
     */
    public boolean equals(Object o) {
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
        Candidatura obj = (Candidatura) o;
        if (obj.custo == custo && obj.dias == dias && obj.textoMotivacao.equalsIgnoreCase(textoMotivacao) &&
                obj.textoApresentacao.equalsIgnoreCase(textoApresentacao)) {
            return true;
        }
        return false;
    }


    /**
     * Método que calcula e retorna a média dos graus de proficiência em cada uma das
     * Competências Técnicas do Freelancer exigidas para a tarefa.
     *
     * return Média dos graus de proficiência em cada uma das Competências Técnicas do Freelancer.
     */
    public double mediaGrau(){ 
        double soma = 0;
      List<CompetenciaTecnica> comp =  getFreelancer().getListaCompt();
      for(int i = 0; i < comp.size() ; i++){
          soma = soma + comp.get(i).getM_oGrau().getValor();
      }      
        return soma/comp.size();   
    }

    /**
     * Método que calcula e retorna o desvio padrão dos graus de proficiência em cada
     * uma das Competências Técnicas do Freelancer exigidas para a tarefa.
     *
     * return Desvio Padrão dos graus de proficiência em cada uma das Competências Técnicas do Freelancer.
     */
    public double desvioPadrao(){
        double desvio = 0;
        List<CompetenciaTecnica> comp =  getFreelancer().getListaCompt();
      for(int i = 0; i < comp.size() ; i++){
          desvio = desvio + Math.pow(comp.get(i).getM_oGrau().getValor() - mediaGrau(),2);
      }        
        return Math.sqrt(desvio/comp.size());  
    }
    
    

}
