/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dn_tp3_1191513_1181600.model;

import java.util.ArrayList;
import java.util.List;


/**
 * Class Freelancer utilizada para instanciar Freelancers que irão realizar
 * Candidaturas aos Anúncios relativos a Tarefas.
 */
public class Freelancer {


    private String str_nome;
    private String str_NIF;
    private String str_telf;
    private String str_email;
    private static final String NOME_OMISSAO = "sem nome";
    private static final String NIF_OMISSAO = "sem NIF";
    private static final String TELF_OMISSAO = "sem telf";
    private static final String EMAIL_OMISSAO = "sem mail";
    private List<CompetenciaTecnica> listaCompt;

    public Freelancer(String nome, String NIF, String telf, String email) {
        if (nome == null || nome.isEmpty() || NIF == null || NIF.isEmpty() ||
                telf == null || telf.isEmpty() || email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Nenhum dos argumentos pode ser nulo ou vazio.");
        }

        this.str_nome = nome;
        this.str_NIF = NIF;
        this.str_telf = telf;
        this.str_email = email;
        this.listaCompt = new ArrayList<CompetenciaTecnica>();

    }

    Freelancer(Freelancer freelancer) {
        str_nome = freelancer.getStr_nome();
        str_NIF = freelancer.getStr_NIF();
        str_telf = freelancer.getStr_telf();
        str_email = freelancer.getStr_email();
        listaCompt = freelancer.getListaCompt();
    }

    Freelancer() {
        str_nome = NOME_OMISSAO;
        str_NIF = NIF_OMISSAO;
        str_telf = TELF_OMISSAO;
        str_email = EMAIL_OMISSAO;
    }


    public String getStr_email() {
        return str_email;
    }

    public String getStr_nome() {
        return str_nome;
    }

    public String getStr_NIF() {
        return str_NIF;
    }

    public String getStr_telf() {
        return str_telf;
    }

    public List<CompetenciaTecnica> getListaCompt() {
        return listaCompt;
    }


    public void setStr_email(String str_email) {
        this.str_email = str_email;
    }

    public void setStr_nome(String str_nome) {
        this.str_nome = str_nome;
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
        Freelancer obj = (Freelancer) o;
        boolean equal = false;
        if (obj.str_nome.equalsIgnoreCase(str_nome) && obj.str_NIF.equalsIgnoreCase(str_NIF) && obj.str_telf.equalsIgnoreCase(str_telf) &&
                obj.str_email.equalsIgnoreCase(str_email)) {
            equal = true;
        }
        // método inacabado, falta verificar igualdade de listas (sem ser por referencia)
        throw new java.lang.UnsupportedOperationException("Not supported yet.");

    }

    @Override
    public String toString() {
        return String.format("%s ", this.str_nome);
    }
}
