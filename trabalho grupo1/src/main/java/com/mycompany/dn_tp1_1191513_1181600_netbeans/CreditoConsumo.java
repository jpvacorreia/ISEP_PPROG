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
public abstract class CreditoConsumo extends Credito {

    /**
     * A taxa de juro Anual do crédito.
     */
    private double taxaJuroAnual;

    /**
     * O número de instâncias criadas de crédito ao Consumo.
     */
    private static int contadorInstancias;

    /**
     * A taxa de juro Anual do crédito, por defeito.
     */
    private final static double taxaJuroAnualDefault = 0.0;

    /**
     *
     * Constrói uma instância de CreditoConsumo com todos os parametros em baixo
     * descritos recebidos.
     *
     * @param nomeCliente
     * @param profissao
     * @param montante
     * @param prazoFinanciamento
     * @param taxaJuroAnual
     */
    public CreditoConsumo(String nomeCliente, String profissao, double montante, int prazoFinanciamento, double taxaJuroAnual) {
        super(nomeCliente, profissao, montante, prazoFinanciamento);
        this.taxaJuroAnual = taxaJuroAnual;
        contadorInstancias++;
    }

    /**
     * Constrói uma instância de CreditoConsumo com todos os parametros
     * recebidos por omissão.
     */
    public CreditoConsumo() {
        super();
        taxaJuroAnual = taxaJuroAnualDefault;
        contadorInstancias++;
    }
    /**
     * devolve a Taxa de Juro Anual
     * @return taxaJuroAnual
     */
    public double getTaxaJuroAnual() {
        return taxaJuroAnual;
    }

    /**
     * Devolve o número de instâncias de Crédito Consumo criadas.
     *
     * @return número instâncias CreditoConsumo criadas.
     */
    public static int getContadorInstancias() {
        return contadorInstancias;
    }

    /**
     * permite a alteração da taxa de juro anual
     * @param taxaJuroAnual 
     */
    public void setTaxaJuroAnual(double taxaJuroAnual) {
        this.taxaJuroAnual = taxaJuroAnual;
    }

    /**
     * Devolve a descrição textual dos atributos do credito consumo.
     *
     * @return atributos do credito consumo
     */
    @Override
    public String toString() {
        return super.toString()
                + "CreditoConsumo{"
                + "taxa juro anual=" + taxaJuroAnual + '}';
    }

    /**
     * Devolve a descrição em formato tabela dos atributos de credito
     * consumo.
     *
     * @return atributos de credito consumo em formato tabela
     */
    public String toListagem() {
        return String.format(super.toListagem() + "%7.2f|", taxaJuroAnual);
    }
    
     /**
     * Devolve a descrição em formato tabela do nome e valor final a receber pelo credito consumo.
     *
     * @return nomeCliente e montante de credito consumo em formato tabela
     */
    public abstract String toListagemResumoMontante() ;
    
     /**
     * Devolve a descrição em formato tabela do nome e os juros a receber pelo credito consumo.
     *
     * @return atributos de credito consumo em formato tabela
     */
    public abstract String toListagemResumoJuros() ;

    /**
     * Permite o calculo do montante a receber ate final de cada credito
     * consumo realizado pela instituição bancaria atraves do polimorfismo.
     *
     * @return montante a receber ate ao final de cada credito
     */
    public abstract double calcularMontanteAReceberPorCadaCredito();

    /**
     * Permite o calculo dos juros a receber ate ao final de cada credito
     * consumo realizado pela instituição bancaria atraves do polimorfismo.
     *
     * @return juros a receber ate ao final de cada credito
     */
    public abstract double calcularMontanteTotalJuros();
    
    /**
     * Devolve um array com a informação dos juros e montante a receber mensalmente pela instituição bancária
     * e capital ainda em divida apos prestação
     *
     * @return array com toda a informação do credito, cada linha tem a informação de cada prestação mensal.
     */
    public abstract double[][] calcularMontantesMensaisPrestacoes();

}

