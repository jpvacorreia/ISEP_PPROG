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
public class CreditoEdu extends CreditoConsumo {
    
    
    /**
     * Indicação da coluna onde se encontra a informação dos juros no array arrayMontantes.
     */
    private static final int JUROS = 0;
    
    /**
     * Indicação da coluna onde se encontra a informação da prestaÃ§Ã£o mensal no array arrayMontantes.
     */
    private static final int PRESTACAOMENSAL = 1;
    
    /**
     * Indicação da coluna onde se encontra a informação do capital em divida no array arrayMontantes.
     */
    private static final int CAPITALDIVIDAMENSAL = 2;
    
    /**
     * percentagem de carencia
     */
    private double perCarencia;
    
    /**
     * percentagem de carencia por defeito
     */
    private final static double perCarenciaDefault = 0.0;

    /**
     *
     * Constrói uma instância de CreditoEdu com todos os parametros em baixo
     * descritos recebidos.
     *
     * @param nomeCliente
     * @param profissao
     * @param montante
     * @param prazoFinanciamento
     * @param taxaJuroAnual
     * @param perCarencia
     */
    public CreditoEdu(String nomeCliente, String profissao, double montante, int prazoFinanciamento, double taxaJuroAnual, double perCarencia) {
        super(nomeCliente, profissao, montante, prazoFinanciamento, taxaJuroAnual);
        this.perCarencia = perCarencia;
    }

    /**
     * Constrói uma instância de CreditoEdu com todos os parametros recebidos
     * por omissão.
     */
    public CreditoEdu() {
        super();
        perCarencia = perCarenciaDefault;
    }
    
    /**
     * permite a visualizaçao da perCarencia
     * @return perCarencia
     */
    public double getPerCarencia() {
        return perCarencia;
    }
    
    /**
     * permite a alteracao da perCarencia
     * @param perCarencia 
     */
    public void setPerCarencia(double perCarencia) {
        this.perCarencia = perCarencia;
    }
    
    /**
     * Devolve a descrição dos atributos de creditoEdu
     * @return atriburos do creditoEdu
     */
    @Override
    public String toString() {
        return super.toString()
                + "do tipo ConsumoEdu{"
                + "percentagem carencia=" + perCarencia + '}';
    }

    /**
     * Devolve a descrição em formato tabela dos atributos de credito
     * edu.
     *
     * @return atributos de credito edu em formato tabela
     */
    public String toListagem() {
        return String.format(super.toListagem() + "%7.2f|", perCarencia);
    }

     /**
     * Devolve a descrição em formato tabela do nome e valor final a receber pelo credito edu.
     *
     * @return nomeCliente e montante de credito edu em formato tabela
     */
    public String toListagemResumoMontante() {
        return String.format("|%-25s|%15.2f|", nomeCliente, calcularMontanteAReceberPorCadaCredito());
    }

    /**
     * Devolve a descrição em formato tabela do nome e os juros a receber pelo credito edu.
     *
     * @return atributos de credito edu em formato tabela
     */
    public String toListagemResumoJuros() {
        return String.format("|%-25s|%15.2f|", nomeCliente, calcularMontanteTotalJuros());
    }


     /**
     * Devolve o montante a receber até ao final de cada credito edu
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
     * Devolve os juros a receber até ao final de cada credito edu
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
    public double[][] calcularMontantesMensaisPrestacoes(){
        double capitalAmortizarMensalmente = montante / (prazoFinanciamento - perCarencia);
        double montanteCreditoEmDivida = this.montante;
        double[][] arrayMontantes = new double[prazoFinanciamento][3];

        for (int i = 0; i < prazoFinanciamento; i++) {
            if (i <= this.perCarencia - 1) {
                arrayMontantes[i][JUROS] = montanteCreditoEmDivida * ((getTaxaJuroAnual() / 100 / 12));
                arrayMontantes[i][PRESTACAOMENSAL] = arrayMontantes[i][JUROS];
                arrayMontantes[i][CAPITALDIVIDAMENSAL] = montanteCreditoEmDivida;
            } else {
                arrayMontantes[i][JUROS] = montanteCreditoEmDivida * ((getTaxaJuroAnual() / 100 / 12));
                arrayMontantes[i][PRESTACAOMENSAL] = arrayMontantes[i][JUROS] + capitalAmortizarMensalmente;
                arrayMontantes[i][CAPITALDIVIDAMENSAL] = montanteCreditoEmDivida - capitalAmortizarMensalmente;
            }
            montanteCreditoEmDivida = arrayMontantes[i][CAPITALDIVIDAMENSAL];
        }
        return arrayMontantes;
    }
    
}

