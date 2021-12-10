/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dn_tp1_1191513_1181600_netbeans;

/**
 *
 * @author Óscar Folha
 */
public abstract class Credito {

    /**
     * O nome do cliente.
     */
    public String nomeCliente;

    /**
     * A profissao do cliente.
     */
    public String profissao;

    /**
     * O montante de credito requerido pelo cliente.
     */
    public double montante;

    /**
     * O prazo de financiamento a credito requerido pelo cliente.
     */
    public int prazoFinanciamento;

    /**
     * O nome do cliente por defeito.
     */
    public final String nomeClienteDefault = "sem nome";

    /**
     * A profissao do cliente por defeito.
     */
    public final String profissaoDefault = "sem profissao";

    /**
     * O montante de credito, por defeito, requerido pelo cliente.
     */
    public final double montanteDefault = 0;

    /**
     * O prazo de financiamento a credito, por defeito, requerido pelo cliente.
     */
    public final int prazoFinanciamentoDefault = 0;


    // Constructors

    /**
     * Inicializa o nome e a profissao do cliente e o montante de credito e o prazo
     * de financiamento a credito requeridos pelo cliente com os parametros de entrada
     * nomeCliente, profissao, montante e prazoFinanciamento recebidos.
     *
     * @param nomeCliente        o nome do cliente.
     * @param profissao          a profissao do cliente.
     * @param montante           o montante de credito requerido pelo cliente.
     * @param prazoFinanciamento o prazo de financiamento a credito requerido pelo cliente.
     */
    public Credito(String nomeCliente, String profissao, double montante, int prazoFinanciamento) {
        this.nomeCliente = nomeCliente;
        this.profissao = profissao;
        this.montante = montante;
        this.prazoFinanciamento = prazoFinanciamento;
    }

    /**
     * Inicializa o nome e a profissao do cliente e o montante de credito e o prazo
     * de financiamento a credito requeridos pelo cliente com os atributos
     * por omissao indicados acima.
     */
    public Credito() {
        this.nomeCliente = nomeClienteDefault;
        this.profissao = profissaoDefault;
        this.montante = montanteDefault;
        this.prazoFinanciamento = prazoFinanciamentoDefault;
    }

    /**
     * Devolve o nome do cliente.
     *
     * @return nome do cliente
     */
    public String getNomeCliente() {
        return nomeCliente;
    }

    /**
     * Devolve a profissao do cliente.
     *
     * @return profissao do cliente
     */
    public String getProfissao() {
        return profissao;
    }

    /**
     * Devolve o montante de credito requerido pelo cliente.
     *
     * @return montante de credito requerido pelo cliente
     */
    public double getMontante() {
        return montante;
    }

    /**
     * Devolve o prazo de financiamento a credito requerido pelo cliente.
     *
     * @return prazo de financiamento a credito requerido pelo cliente
     */
    public int getPrazoFinanciamento() {
        return prazoFinanciamento;
    }

    /**
     * Modifica o nome do cliente.
     *
     * @param nomeCliente o nome do cliente
     */
    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    /**
     * Modifica a profissao do cliente.
     *
     * @param profissao a profissao do cliente
     */
    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    /**
     * Modifica o montante de credito requerido pelo cliente.
     *
     * @param montante o montante de credito requerido pelo cliente
     */
    public void setMontante(double montante) {
        this.montante = montante;
    }

    /**
     * Modifica o prazo de financiamento a credito requerido pelo cliente.
     *
     * @param prazoFinanciamento o prazo de financiamento a credito requerido pelo cliente
     */
    public void setPrazoFinanciamento(int prazoFinanciamento) {
        this.prazoFinanciamento = prazoFinanciamento;
    }

    /**
     * Devolve a descricao textual dos atributos base do credito.
     *
     * @return atributos base do credito
     */
    @Override
    public String toString() {
        return String.format("CREDITO: Nome Cliente= %s%nProfissao= %s%nMontante= %.2f\u20ac%nPrazo Financiamento= %d meses%n",
                nomeCliente, profissao, montante, prazoFinanciamento);
    }

    /**
     * Devolve a descricao em formato tabela dos atributos base do credito.
     *
     * @return atributos base do credito em formato tabela
     */
    public String toListagem() {
        return String.format("|%-25s|%-15s|%10.2f|%6d|", nomeCliente, profissao, montante, prazoFinanciamento);
    }

     /**
     * Devolve a descricao em formato tabela do nome e valor final a receber pelo credito habitacao.
     *
     * @return nomeCliente e montante de credito habitacao em formato tabela
     */
    public abstract String toListagemResumoMontante() ;
    /**
     * Devolve a descricao em formato tabela do nome e os juros a receber pelo credito habitacao.
     *
     * @return atributos de credito habitacao em formato tabela
     */
    public abstract String toListagemResumoJuros() ;


    /**
     * Permite o calculo do montante a receber ate ao final de cada credito bancario
     * realizado pela instituicao bancaria atraves do polimorfismo.
     *
     * @return montante a receber ate ao final de cada credito
     */
    public abstract double calcularMontanteAReceberPorCadaCredito();

    /**
     * Permite o calculo dos juros a receber ate ao final de cada credito bancario
     * realizado pela instituicao bancaria atraves do polimorfismo.
     *
     * @return juros a receber ate ao final de cada credito
     */
    public abstract double calcularMontanteTotalJuros();
    
    /**
     * Devolve um array com a informacao dos juros e montante a receber mensalmente pela instituicao bancaria
     * e capital ainda em divida apos prestacao
     *
     * @return array com toda a informacao do credito, cada linha tem a informacao de cada prestacao mensal.
     */
    public abstract double[][] calcularMontantesMensaisPrestacoes();

}

