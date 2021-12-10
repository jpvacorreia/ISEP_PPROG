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
public class CreditoAuto extends CreditoConsumo {

    /**
     * Indicação da coluna onde se encontra a informação dos juros no array arrayMontantes.
     */
    private static final int JUROS = 0;

    /**
     * Indicação da coluna onde se encontra a informação da prestação mensal no array arrayMontantes.
     */
    private static final int PRESTACAOMENSAL = 1;

    /**
     * Indicação da coluna onde se encontra a informação do capital em divida no array arrayMontantes.
     */
    private static final int CAPITALDIVIDAMENSAL = 2;

    /**
     * Limite de meses onde o desconto é aplicável.
     */
    private static final int LIMITEMESES = 24;

    /**
     * o desconto do credito auto
     */
    private double desconto;

    /**
     * desconto do credito auto por defeito
     */
    private final static double descontoDefault = 0.0;

    /**
     * Constrói uma instância de CreditoAuto com todos os parametros em baixo
     * descritos recebidos.
     *
     * @param nomeCliente
     * @param profissao
     * @param montante
     * @param prazoFinanciamento
     * @param taxaJuroAnual
     * @param desconto
     */
    public CreditoAuto(String nomeCliente, String profissao, double montante, int prazoFinanciamento, double taxaJuroAnual, double desconto) {
        super(nomeCliente, profissao, montante, prazoFinanciamento, taxaJuroAnual);
        this.desconto = desconto;
    }
    
    /**
     * Constrói uma instância de CreditoAuto com todos os parametros em baixo
     * descritos recebidos, caso não exista desconto.
     *
     * @param nomeCliente
     * @param profissao
     * @param montante
     * @param prazoFinanciamento
     * @param taxaJuroAnual
     */
    public CreditoAuto(String nomeCliente, String profissao, double montante, int prazoFinanciamento, double taxaJuroAnual) {
        super(nomeCliente, profissao, montante, prazoFinanciamento, taxaJuroAnual);
        desconto = descontoDefault;
    }

    /**
     * Constrói uma instância de CreditoAuto com todos os parametros recebidos
     * por omissão.
     */
    public CreditoAuto() {
        super();
        desconto = descontoDefault;
    }

    /**
     * retorna o desconto
     *
     * @return desconto
     */
    public double getDesconto() {
        return desconto;
    }

    /**
     * permite a alteração do desconto
     *
     * @param desconto
     */
    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    /**
     * Devolve a descrição textual dos atributos do creditoAuto.
     *
     * @return atributos do crÃ©dito Auto
     */
    @Override
    public String toString() {
        return super.toString()
                + "do tipo ConsumoAuto{"
                + "desconto=" + desconto + '}';
    }

    /**
     * Devolve a descrição em formato tabela dos atributos de credito
     * auto.
     *
     * @return atributos de credito auto em formato tabela
     */
    public String toListagem() {
        return String.format(super.toListagem() + "%7.2f|", desconto);
    }

     /**
     * Devolve a descrição em formato tabela do nome e valor final a receber pelo credito auto.
     *
     * @return nomeCliente e montante de credito auto em formato tabela
     */
    public String toListagemResumoMontante() {
        return String.format("|%-25s|%15.2f|", nomeCliente, calcularMontanteAReceberPorCadaCredito());
    }
    

    /**
     * Devolve a descrição em formato tabela do nome e os juros a receber pelo credito auto.
     *
     * @return atributos de credito auto em formato tabela
     */
    public String toListagemResumoJuros() {
        return String.format("|%-25s|%15.2f|", nomeCliente, calcularMontanteTotalJuros());
    }

    /**
     * Devolve o montante a receber até ao final de cada credito auto
     * realizado pela instituição bancária
     *
     * @return montante a receber por cada credito realizado
     */
    @Override
    public double calcularMontanteAReceberPorCadaCredito() {
        double montantesFinais[][] = calcularMontantesMensaisPrestacoes();
        double montanteFinalReceber = 0;

        for (int i = 0; i < montantesFinais.length; i++) {
            montanteFinalReceber += montantesFinais[i][PRESTACAOMENSAL];
        }
        return montanteFinalReceber;
    }

    /**
     * Devolve os juros a receber até ao final de cada credito auto
     * realizado pela instituição bancária
     *
     * @return juros a receber por cada credito realizado
     */
    @Override
    public double calcularMontanteTotalJuros() {
        double montantesFinais[][] = calcularMontantesMensaisPrestacoes();
        double montanteFinalReceber = 0;

        for (int i = 0; i < montantesFinais.length; i++) {
            montanteFinalReceber += montantesFinais[i][JUROS];
        }
        return montanteFinalReceber;
    }

   /**
     * Devolve um array com a informação dos juros e montante a receber mensalmente pela instituiçõ bancária
     * e capital ainda em dívida após prestação
     *
     * @return array com toda a informação do credito, cada linha tem a informação de cada prestação mensal.
     */
    public double[][] calcularMontantesMensaisPrestacoes() {
        double capitalAmortizarMensalmente = montante / prazoFinanciamento;
        double montanteCreditoEmDivida = this.montante;
        double[][] arrayMontantes = new double[prazoFinanciamento][3];

        for (int i = 0; i < prazoFinanciamento; i++) {
            if (prazoFinanciamento <= LIMITEMESES) {
                arrayMontantes[i][JUROS] = montanteCreditoEmDivida * (getTaxaJuroAnual() / 100 / 12) - (montanteCreditoEmDivida * desconto / 100 / 12);
                arrayMontantes[i][PRESTACAOMENSAL] = arrayMontantes[i][JUROS] + capitalAmortizarMensalmente;
                arrayMontantes[i][CAPITALDIVIDAMENSAL] = montanteCreditoEmDivida - capitalAmortizarMensalmente;
            } else {
                arrayMontantes[i][JUROS] = montanteCreditoEmDivida * (getTaxaJuroAnual() / 100 / 12);
                arrayMontantes[i][PRESTACAOMENSAL] = arrayMontantes[i][JUROS] + capitalAmortizarMensalmente;
                arrayMontantes[i][CAPITALDIVIDAMENSAL] = montanteCreditoEmDivida - capitalAmortizarMensalmente;
            }
            montanteCreditoEmDivida = arrayMontantes[i][CAPITALDIVIDAMENSAL];
        }
        return arrayMontantes;
    }

}
