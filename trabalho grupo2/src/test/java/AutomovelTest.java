/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Óscar Folha
 */
public class AutomovelTest {
    
    public AutomovelTest() {
    }
    
    @Test
    public void testCalcularValorAluguer() {
        System.out.println("calcularValorAluguer");
        Automovel instance = new Automovel("Bugatti", "X", 0, 1000);
        double expResult = 1050;
        double result = instance.calcularValorAluguer();
        assertEquals(expResult, result, 0.0);
        
    }

    /**
     * Test of calcularValorVenda method, of class Automovel.
     */
    @Test
    public void testCalcularValorVenda() {
        System.out.println("calcularValorVenda");
        Automovel instance = new Automovel("Bugatti", "X", 500000, 0);
        double expResult = 515000;
        double result = instance.calcularValorVenda();
        assertEquals(expResult, result, 0.0);
        
    }
    
}
