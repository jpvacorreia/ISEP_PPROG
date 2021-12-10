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
public class DN1_TP1_1191513_1181600 {
 public static void main(String[] args) {

        // a) Criação do seguinte conjunto de instâncias:
        
        
        //▪ 2 créditos à habitação; 
        CreditoHabitacao credHab1 = new CreditoHabitacao("Joaquim Moreira", "Estafeta", 120000, 240, 1, 0.1);
        CreditoHabitacao credHab2 = new CreditoHabitacao("Amélia Amaro", "Fadista", 35000, 60, 1, 1);
        //▪ 2 créditos automóvel; 
        CreditoAuto credAuto1 = new CreditoAuto("Luísa", "Professora", 10000, 26, 6, 2);
        CreditoAuto credAuto2 = new CreditoAuto("Fátima", "Militar", 50000, 55, 6, 4);
         //▪ 2 créditos à educação;
        CreditoEdu credEdu1 = new CreditoEdu("Carlos", "Estudante",19000, 60, 2, 24);
        CreditoEdu credEdu2 = new CreditoEdu("Sebastião", "Estudante",45000, 30, 2, 12);

        // b) Criação de um contentor do tipo array e armazenamento no mesmo das instâncias criadas; 
        Credito[] arrayCreditos = new Credito[10];
        arrayCreditos[0] = credHab1;
        arrayCreditos[1] = credHab2;
        arrayCreditos[2] = credAuto1;
        arrayCreditos[3] = credAuto2;
        arrayCreditos[4] = credEdu1;
        arrayCreditos[5] = credEdu2;

        // c) 1.
        System.out.println("c) 1. obter o nome do cliente e o valor que a instituição bancária irá receber " +
                "até ao final de cada contrato de crédito ao consumo realizado;");
        System.out.printf("|Nome                     |Credito Consumo|%n");
        System.out.printf("|*****************************************|%n");
        for (int i = 0; i < arrayCreditos.length; i++) {
            if (arrayCreditos[i] != null && arrayCreditos[i] instanceof CreditoConsumo) {
                CreditoConsumo obj = (CreditoConsumo) arrayCreditos[i];
                System.out.println(obj.toListagemResumoMontante());
            }
        }
   

         // c) 2.
        System.out.println();
        System.out.println("c) 2. obter o nome do cliente e o valor dos juros (para além do montante do empréstimo) que o\n" +
                "cliente terá de pagar até ao final de cada contrato de crédito bancário realizado.");
        System.out.printf("|Nome                     |Juros a Receber|%n");
        System.out.printf("|*****************************************|%n");
        for (int i = 0; i < arrayCreditos.length; i++) {
            if (arrayCreditos[i] != null && arrayCreditos[i] instanceof CreditoHabitacao) {
                CreditoHabitacao obj = (CreditoHabitacao) arrayCreditos[i];
                System.out.println(obj.toListagemResumoJuros());
            }
        }

        // d)
        System.out.println();
        System.out.println("d) Apresentação das quantidades de instâncias de créditos à habitação e de\n" +
                "créditos ao consumo criadas em separado), sem percorrer o contentor;");
        System.out.printf("|Tipo de Instancia        |Quantidade     |%n");
        System.out.printf("|*****************************************|%n");
        System.out.printf("|Credito Habitacao        |%15d|%n", CreditoHabitacao.getContadorInstancias());
        System.out.printf("|Credito Consumo          |%15d|%n", CreditoConsumo.getContadorInstancias());


        // e)
        double totalJurosReceber= 0;
        double totalMontanteReceber = 0;
        for (int i = 0; i < arrayCreditos.length; i++) {
            if (arrayCreditos[i] != null) {
                totalJurosReceber += arrayCreditos[i].calcularMontanteTotalJuros();
                totalMontanteReceber += arrayCreditos[i].calcularMontanteAReceberPorCadaCredito();
            }
        }
        System.out.println();
        System.out.println("e) Cálculo e apresentação do valor total e dos respetivos juros que a \n" +
                "instituição bancária irá receber por\n" +
                "todos os créditos bancários realizados, percorrendo apenas uma vez o contentor.");
        System.out.printf("|TOTAL:                   |Valor          |%n");
        System.out.printf("|*****************************************|%n");
        System.out.printf("|Total Juros a receber    |%15.2f|%n", totalJurosReceber);
        System.out.printf("|Total Montante a receber |%15.2f|%n", totalMontanteReceber);
    }
}
    
