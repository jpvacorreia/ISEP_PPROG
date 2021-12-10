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
public class CreditoAutoTest {
    
    /**
     * Test of calcularMontanteAReceberPorCadaCredito method, of class CreditoAuto.
     */
    @Test
    public void testCalcularMontanteAReceberPorCadaCredito() {
       //test1
        CreditoAuto credAuto1 = new CreditoAuto("Paulo", "Estudante",18000, 60, 6, 1);

        double result1 = credAuto1.calcularMontanteAReceberPorCadaCredito();
        double expected1 = 20745;

        assertEquals(expected1, result1, 0.5);

        //test2
        CreditoAuto credAuto2 = new CreditoAuto("Paulo", "Estudante",18000, 24, 6, 1);

        double result2 = credAuto2.calcularMontanteAReceberPorCadaCredito();
        double expected2 = 18937.5;

        assertEquals(expected2, result2, 0.5);
    }

    /**
     * Test of calcularMontanteTotalJuros method, of class CreditoAuto.
     */
    @Test
    public void testCalcularMontanteTotalJuros() {
         //test1
        CreditoAuto credAuto1 = new CreditoAuto("Paulo", "Estudante",18000, 60, 6, 1);

        double result1 = credAuto1.calcularMontanteTotalJuros();
        double expected1 = 2745;

        assertEquals(expected1, result1, 0.5);

        //test2
        CreditoAuto credAuto2 = new CreditoAuto("Paulo", "Estudante",18000, 24, 6, 1);

        double result2 = credAuto2.calcularMontanteTotalJuros();
        double expected2 = 937.5;

        assertEquals(expected2, result2, 0.5);
    }
}
