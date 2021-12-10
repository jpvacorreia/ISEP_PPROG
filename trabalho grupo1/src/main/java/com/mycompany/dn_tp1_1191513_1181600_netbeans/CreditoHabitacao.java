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
public class CreditoHabitacao extends Credito {

    /**
     * indicacao da coluna onde se encontra a informacao dos juros no array arrayMontantes.
     */
    private static final int JUROS = 0;
    /**
     * indicacao da coluna onde se encontra a informacao da prestacao mensal no array arrayMontantes.
     */
    private static final int PRESTACAOMENSAL = 1;
    /**
     * indicacao da coluna onde se encontra a informacao do capital em divida no array arrayMontantes.
     */
    private static final int CAPITALDIVIDAMENSAL = 2;


    /**
     * O spread do credito
     */
    public double spread;

    /**
     * A taxa Euribor do credito
     */
    public double taxaEuribor;

    /**
     * O numero de instancias criadas de credito habitacao.
     */
    private static int contadorInstancias;

    /**
     * O spread, por defeito, do credito
     */
    public final double spreadDefault = 0;

    /**
     * A taxa Euribor, por defeito, do credito
     */
    public final double taxaEuriborDefault = 0.1;

    /**
     * O numero de instancias criadas de credito habitacao.
     */
    private static int contadorInstanciasDefault = 0;


    // Constructors

    /**
     * Constroi uma instancia de Creditohabitacao com o nome e a profissao do cliente e o
     * montante de credito e o prazo de financiamento a credito requeridos pelo cliente com
     * os parametros de entrada nomeCliente, profissao, montante e prazoFinanciamento recebidos.
     *
     * @param nomeCliente        o nome do cliente.
     * @param profissao          a profissao do cliente.
     * @param montante           o montante de credito requerido pelo cliente.
     * @param prazoFinanciamento o prazo de financiamento a credito requerido pelo cliente.
     * @param spread             o spread do credito
     * @param taxaEuribor        a taxa Euribor do credito
     */
    public CreditoHabitacao(String nomeCliente, String profissao, double montante, int prazoFinanciamento, double spread, double taxaEuribor) {
        super(nomeCliente, profissao, montante, prazoFinanciamento);
        this.spread = spread;
        this.taxaEuribor = taxaEuribor;
        contadorInstancias++;
    }

    /**
     * Constroi uma instancia de CreditoHabitacao com o nome e a profissao do cliente e o
     * montante de credito e o prazo de financiamento a credito requeridos pelo cliente com
     * os atributos por omissao indicados acima.
     */
    public CreditoHabitacao() {
        super();
        this.spread = spreadDefault;
        this.taxaEuribor = taxaEuriborDefault;
        contadorInstancias++;
    }

    /**
     * Devolve o spread do credito
     *
     * @return spread do credito
     */
    public double getSpread() {
        return spread;
    }

    /**
     * Devolve a taxa euribor do credito
     *
     * @return taxa euribor do credito
     */
    public double getTaxaEuribor() {
        return taxaEuribor;
    }

    /**
     * Devolve o numero de instancias de credito habitacao criadas.
     *
     * @return numero instancias CreditoHabitacao criadas.
     */
    public static int getContadorInstancias() {
        return contadorInstancias;
    }

    /**
     * Modifica o spread do credito
     *
     * @param spread spread do credito
     */
    public void setSpread(double spread) {
        this.spread = spread;
    }

    /**
     * Modifica a taxa euribor do credito
     *
     * @param taxaEuribor taxa euribor do credito
     */
    public void setTaxaEuribor(double taxaEuribor) {
        this.taxaEuribor = taxaEuribor;
    }

    /**
     * Devolve a descricao textual dos atributos do credito habitacao.
     *
     * @return atributos do credito habitacao
     */
    @Override
    public String toString() {
        return String.format(super.toString() + "TIPO: Credito Habitacao%nSpread= %.2f%nTaxa Euribor= %.2f%%%n",
                spread, taxaEuribor);
    }

    /**
     * Devolve a descricao em formato tabela dos atributos de credito habitacao.
     *
     * @return atributos de credito habitacao em formato tabela
     */
    public String toListagem() {
        return String.format(super.toListagem() + "%7.2f|%8.2f|", spread, taxaEuribor);
    }

    /**
     * Devolve a descricao em formato tabela do nome e valor final a receber pelo credito habitacao.
     *
     * @return nomeCliente e montante de credito habitacao em formato tabela
     */
    public String toListagemResumoMontante() {
        return String.format("|%-25s|%15.2f|", nomeCliente, calcularMontanteAReceberPorCadaCredito());
    }

    /**
     * Devolve a descricao em formato tabela do nome e os juros a receber pelo credito habitacao.
     *
     * @return atributos de credito habitacao em formato tabela
     */
    public String toListagemResumoJuros() {
        return String.format("|%-25s|%15.2f|", nomeCliente, calcularMontanteTotalJuros());
    }

    /**
     * Devolve o montante a receber ate ao final de cada credito bancario
     * realizado pela instituicao bancaria
     *
     * @return montante a receber por cada credito realizado
     */
    public double calcularMontanteAReceberPorCadaCredito() {
        double montantesFinais[][] = calcularMontantesMensaisPrestacoes();
        double montanteFinalReceber = 0;

        for (int i = 0; i < montantesFinais.length; i++) {
            montanteFinalReceber += montantesFinais[i][PRESTACAOMENSAL];
        }
        return montanteFinalReceber;
    }


    /**
     * Devolve os juros a receber ate ao final de cada credito bancario
     * realizado pela instituicao bancaria
     *
     * @return juros a receber por cada credito realizado
     */
    public double calcularMontanteTotalJuros() {
        double montantesFinais[][] = calcularMontantesMensaisPrestacoes();
        double montanteFinalReceber = 0;

        for (int i = 0; i < montantesFinais.length; i++) {
            montanteFinalReceber += montantesFinais[i][JUROS];
        }
        return montanteFinalReceber;
    }

    /**
     * Devolve um array com a informacao dos juros e montante a receber mensalmente pela instituicao bancaria
     * e capital ainda em divida apos prestacao
     *
     * @return array com toda a informacao do credito, cada linha tem a informacao de cada prestacao mensal.
     */
    public double[][] calcularMontantesMensaisPrestacoes() {
        double capitalAmortizarMensalmente = montante / prazoFinanciamento;
        double montanteCreditoEmDivida = this.montante;
        double[][] arrayMontantes = new double[prazoFinanciamento][3];

        for (int i = 0; i < prazoFinanciamento; i++) {
            arrayMontantes[i][JUROS] = montanteCreditoEmDivida * ((this.taxaEuribor / 100 / 12) + (this.spread / 100) / 12);
            arrayMontantes[i][PRESTACAOMENSAL] = arrayMontantes[i][JUROS] + capitalAmortizarMensalmente;
            arrayMontantes[i][CAPITALDIVIDAMENSAL] = montanteCreditoEmDivida - capitalAmortizarMensalmente;

            montanteCreditoEmDivida = arrayMontantes[i][CAPITALDIVIDAMENSAL];
        }
        return arrayMontantes;
    }
}
