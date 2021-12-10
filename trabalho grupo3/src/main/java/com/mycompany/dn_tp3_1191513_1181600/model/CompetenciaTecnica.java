/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dn_tp3_1191513_1181600.model;

import java.util.Objects;

/**
 * Class CompetenciaTecnica utilizada para instanciar Competencias Técnicas
 * pertencentes a Freelancers e Tarefas.
 */
public class CompetenciaTecnica {
    private String m_strId;
    private String m_strDescricaoBreve;
    private String m_strDescricaoDetalhada;
    private AreaAtividade m_oAreaAtividade;
    private GrauProficiencia m_oGrau;


    public CompetenciaTecnica(String strId, String strDescricaoBreve, String strDescricaoDetalhada, AreaAtividade oArea, GrauProficiencia m_1srGrau) {
        if ((strId == null) || (strDescricaoBreve == null) || (strDescricaoDetalhada == null) ||
                (oArea == null) || (strId.isEmpty()) || (strDescricaoBreve.isEmpty()) || (strDescricaoDetalhada.isEmpty()))
            throw new IllegalArgumentException("Nenhum dos argumentos pode ser nulo ou vazio.");

        this.m_strId = strId;
        this.m_strDescricaoBreve = strDescricaoBreve;
        this.m_strDescricaoDetalhada = strDescricaoDetalhada;
        this.m_oAreaAtividade = new AreaAtividade(oArea);
        this.m_oGrau = new GrauProficiencia(m_1srGrau);
    }

    public CompetenciaTecnica(String strId, String strDescricaoBreve, String strDescricaoDetalhada) {
        this.m_strId = strId;
        this.m_strDescricaoBreve = strDescricaoBreve;
        this.m_strDescricaoDetalhada = strDescricaoDetalhada;
        this.m_oAreaAtividade = new AreaAtividade();
        this.m_oGrau = new GrauProficiencia();
    }

    public CompetenciaTecnica(CompetenciaTecnica CT) {
        m_strId = CT.getM_strId();
        m_strDescricaoBreve = CT.getM_strDescricaoBreve();
        m_strDescricaoDetalhada = CT.getM_strDescricaoDetalhada();
        m_oAreaAtividade = CT.getM_oAreaAtividade();
    }


    public boolean hasId(String strId) {
        return this.m_strId.equalsIgnoreCase(strId);
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

        if (this == o)
            return true;

        if (o == null)
            return false;

        if (getClass() != o.getClass())
            return false;

        CompetenciaTecnica obj = (CompetenciaTecnica) o;
        return (Objects.equals(m_strId, obj.m_strId));
    }

    @Override
    public String toString() {
        return String.format("%s - %s - %s  - Area Atividade: %s", this.m_strId, this.m_strDescricaoBreve, this.m_strDescricaoDetalhada, this.m_oAreaAtividade.toString());
    }


    public String getM_strId() {
        return m_strId;
    }

    public AreaAtividade getM_oAreaAtividade() {
        return new AreaAtividade(m_oAreaAtividade);
    }

    public String getM_strDescricaoBreve() {
        return m_strDescricaoBreve;
    }

    public String getM_strDescricaoDetalhada() {
        return m_strDescricaoDetalhada;
    }

    public GrauProficiencia getM_oGrau() {
        return new GrauProficiencia(m_oGrau);
    }


    public void setM_strId(String m_strId) {
        this.m_strId = m_strId;
    }

    public void setM_strDescricaoBreve(String m_strDescricaoBreve) {
        this.m_strDescricaoBreve = m_strDescricaoBreve;
    }

    public void setM_strDescricaoDetalhada(String m_strDescricaoDetalhada) {
        this.m_strDescricaoDetalhada = m_strDescricaoDetalhada;
    }

    public void setM_oAreaAtividade(AreaAtividade m_oAreaAtividade) {
        this.m_oAreaAtividade = new AreaAtividade(m_oAreaAtividade);
    }

    public void setM_oGrau(GrauProficiencia m_oGrau) {
        this.m_oGrau = new GrauProficiencia(m_oGrau);
    }


}
