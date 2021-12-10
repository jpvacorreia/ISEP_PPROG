/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dn_tp3_1191513_1181600.model;

import java.util.Objects;

/**
 * Class AreaAtividade utilizada para instanciar Areas de Atividade referentes a Tarefas.
 */
public class AreaAtividade {
    private String m_strCodigo;
    private String m_strDescricaoBreve;
    private String m_strDescricaoDetalhada;
    private static final String CODIGO_OMISSAO = "semCod";
    private static final String DESCRICAO_BREVE_OMISSAO = "semBreve";
    private static final String DESCRICAO_DETALHADA_OMISSAO = "semDetalhada";


    public AreaAtividade(String strCodigo, String strDescricaoBreve, String strDescricaoDetalhada) {
        if ((strCodigo == null) || (strDescricaoBreve == null) || (strDescricaoDetalhada == null) ||
                (strCodigo.isEmpty()) || (strDescricaoBreve.isEmpty()) || (strDescricaoDetalhada.isEmpty()))
            throw new IllegalArgumentException("Nenhum dos argumentos pode ser nulo ou vazio.");

        this.m_strCodigo = strCodigo;
        this.m_strDescricaoBreve = strDescricaoBreve;
        this.m_strDescricaoDetalhada = strDescricaoDetalhada;
    }

    public AreaAtividade(AreaAtividade CT) {
        this.m_strCodigo = CT.getCodigo();
        this.m_strDescricaoBreve = CT.getM_strDescricaoBreve();
        this.m_strDescricaoDetalhada = CT.getM_strDescricaoDetalhada();
    }

    AreaAtividade() {
        m_strCodigo = CODIGO_OMISSAO;
        m_strDescricaoBreve = DESCRICAO_BREVE_OMISSAO;
        m_strDescricaoDetalhada = DESCRICAO_DETALHADA_OMISSAO;
    }

    public boolean hasId(String strId) {
        return this.m_strCodigo.equalsIgnoreCase(strId);
    }

    public String getCodigo() {
        return this.m_strCodigo;
    }

    public String getM_strDescricaoBreve() {
        return m_strDescricaoBreve;
    }

    public String getM_strDescricaoDetalhada() {
        return m_strDescricaoDetalhada;
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
        AreaAtividade obj = (AreaAtividade) o;
        return (Objects.equals(m_strCodigo, obj.m_strCodigo));
    }

    @Override
    public String toString() {
        return String.format("%s - %s - %s ", this.m_strCodigo, this.m_strDescricaoBreve, this.m_strDescricaoDetalhada);
    }

}
