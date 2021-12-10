/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dn_tp3_1191513_1181600.model;

/**
 * Class GrauProficiencia utilizada para instanciar Graus de Proficiência de uma
 * determinada Competência Técnicas.
 */
public class GrauProficiencia {
    
    private String designacao;
    private int valor;
    
    private static final String DESIGNACAO_POR_OMISSAO = "Capaz";
    private static final int VALOR_POR_OMISSAO = 1;

    public GrauProficiencia() {
        this.designacao = DESIGNACAO_POR_OMISSAO;
        this.valor = VALOR_POR_OMISSAO;
    }

    public GrauProficiencia(String designacao, int valor) {
        this.designacao = designacao;
        this.valor = valor;
    }

    GrauProficiencia(GrauProficiencia m_1srGrau) {
        this.designacao = m_1srGrau.getDesignacao();
        this.valor = m_1srGrau.getValor(); 
    }

    public String getDesignacao() {
        return designacao;
    }

    public int getValor() {
        return valor;
    }

    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return String.format("Designação: %s Valor: %d", this.designacao, this.valor);
    }
    
    
    
    
    
}
