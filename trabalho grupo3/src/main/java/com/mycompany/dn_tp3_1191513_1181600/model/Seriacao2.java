/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dn_tp3_1191513_1181600.model;

import java.util.Comparator;

/**
 * Class Seriacao2 utilizada para instanciar um objeto de Seriacao2 para posteriormente
 * ser utilizado como critério de ordenação de uma determinada lista de Candidaturas.
 */
public class Seriacao2 implements Comparator<Candidatura>, Seriavel {

    /**
     * Método compare utilizado na ordenação de uma lista de Candidaturas utilizando
     * os seguintes critérios de ordenação:
     * 1º Maior média dos níveis de proficiência em cada uma das competências
     * técnicas exigidas para a tarefa;
     * 2º Desvio padrão mais baixo;
     * 3º Preço	mais baixo;
     * 4º Candidatura registada mais cedo;
     *
     */
    @Override
    public int compare(Candidatura c1, Candidatura c2) {
        int c = Double.compare(c2.mediaGrau(), c1.mediaGrau());
        if (c == 0) {
            c = Double.compare(c1.desvioPadrao(), c2.desvioPadrao());
            if (c == 0) {
                c = Double.compare(c1.getCusto(), c2.getCusto());
                if (c == 0) {
                    c = c1.getDataCand().compareTo(c2.getDataCand());
                }
            }
        }
        return c;
    }

    @Override
    public String toString() {
        return String.format("Seriacao2");
    }


}
