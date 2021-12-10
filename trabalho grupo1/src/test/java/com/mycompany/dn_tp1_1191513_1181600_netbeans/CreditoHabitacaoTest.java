/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dn_tp1_1191513_1181600_netbeans;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Óscar Folha
 */
public class CreditoHabitacaoTest {
    
    /**
     * Test of calcularMontanteAReceberPorCadaCredito method, of class CreditoHabitacao.
     */
    @Test
     public void testcalcularMontanteAReceberPorCadaCredito() {
        //test1
        CreditoHabitacao credHab1 = new CreditoHabitacao("Joaquim Moreira", "Estafeta", 120000, 240, 1, 0.1);

        double result1 = credHab1.calcularMontanteAReceberPorCadaCredito();
        double expected1 = 133255;

        assertEquals(expected1, result1, 0.0001);

        //test2
        CreditoHabitacao credHab2 = new CreditoHabitacao("Joaquim Moreira", "Estafeta", 78000, 240, 1, 0.1);

        double result2 = credHab2.calcularMontanteAReceberPorCadaCredito();
        double expected2 = 86615.75;

        assertEquals(expected2, result2, 0.0001);

    }

    @Test
    public void testcalcularMontanteTotalJuros() {
        //test1
        CreditoHabitacao credHab1 = new CreditoHabitacao("Joaquim Moreira", "Estafeta", 120000, 240, 1, 0.1);

        double result1 = credHab1.calcularMontanteTotalJuros();
        double expected1 = 13255;

        assertEquals(expected1, result1, 0.0001);

        //test2
        CreditoHabitacao credHab2 = new CreditoHabitacao("Joaquim Moreira", "Estafeta", 78000, 240, 1, 0.1);

        double result2 = credHab2.calcularMontanteTotalJuros();
        double expected2 = 8615.75;

        assertEquals(expected2, result2, 0.0001);

    }
}
    

