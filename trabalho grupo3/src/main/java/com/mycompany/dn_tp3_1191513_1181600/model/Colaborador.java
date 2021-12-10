
package com.mycompany.dn_tp3_1191513_1181600.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Class Colaborador utilizada para instanciar Colaboradores existentes na Plataforma
 * sendo que cada um deles tem uma conjunto de Tarefas como atributo.
 */
public class Colaborador {
    private String nome;
    private String funcao;
    private String telefone;
    private String email;
    private List<Tarefa> listaTarefas;


    public Colaborador(String strNome, String strFuncao, String strTelefone, String strEmail) {
        if ((strNome == null) || (strFuncao == null) || (strTelefone == null) || (strEmail == null) ||
                (strNome.isEmpty()) || (strFuncao.isEmpty()) || (strTelefone.isEmpty()) || (strEmail.isEmpty()))
            throw new IllegalArgumentException("Nenhum dos argumentos pode ser nulo ou vazio.");

        this.nome = strNome;
        this.funcao = strFuncao;
        this.telefone = strTelefone;
        this.email = strEmail;
        this.listaTarefas = new ArrayList<Tarefa>();
    }

    public Colaborador(Colaborador outroColaborador) {
        nome = outroColaborador.getNome();
        funcao = outroColaborador.getFuncao();
        telefone = outroColaborador.getTelefone();
        email = outroColaborador.getEmail();
        listaTarefas = outroColaborador.getListaTarefas();

    }

    public boolean hasId(String strId) {
        return this.email.equalsIgnoreCase(strId);
    }

    public String getNome() {
        return this.nome;
    }

    public String getEmail() {
        return this.email;
    }

    public String getFuncao() {
        return funcao;
    }

    public String getTelefone() {
        return telefone;
    }

    public List<Tarefa> getListaTarefas() {
        return listaTarefas;
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
        Colaborador obj = (Colaborador) o;
        return (Objects.equals(email, obj.email));
    }

    @Override
    public String toString() {
        return String.format("%s - %s - %s - %s", this.nome, this.funcao, this.telefone, this.email);
    }
}   

