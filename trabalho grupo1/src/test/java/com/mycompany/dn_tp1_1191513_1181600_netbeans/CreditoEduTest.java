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
public class CreditoEduTest {  

    /**
     * Test of calcularMontanteAReceberPorCadaCredito method, of class CreditoEdu.
     */
    @Test
    public void testcalcularMontanteAReceberPorCadaCredito() {
        //test1
        CreditoEdu credEdu1 = new CreditoEdu("Paulo", "Estudante",18000, 60, 2, 24);

        double result1 = credEdu1.calcularMontanteAReceberPorCadaCredito();
        double expected1 = 19275.0;

        assertEquals(expected1, result1, 0.5);
        
        //test2 
        CreditoEdu credEdu2 = new CreditoEdu("João ", "Estudante",43000, 30, 2, 12);

        double result2 = credEdu2.calcularMontanteAReceberPorCadaCredito();
        double expected2 = 44540.83;

        assertEquals(expected2, result2, 0.5);
    }

    @Test
    public void testcalcularMontanteTotalJuros() {
        //test1
        CreditoEdu credEdu1 = new CreditoEdu("Paulo", "Estudante",18000, 60, 2, 24);

        double result1 = credEdu1.calcularMontanteTotalJuros();
        double expected1 = 1275.0;

        assertEquals(expected1, result1, 0.5);
        
        //test2
        CreditoEdu credEdu2 = new CreditoEdu("João ", "Estudante",43000, 30, 2, 12);

        double result2 = credEdu2.calcularMontanteTotalJuros();
        double expected2 = 1540.83;

        assertEquals(expected2, result2, 0.5);
    }
    
}


