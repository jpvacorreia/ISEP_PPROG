/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dn_tp3_1191513_1181600.model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Óscar Folha
 */
public class CandidaturaTest {

    public CandidaturaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }


       /**
     * Test of desvioPadrao method, of class Candidatura.
     */
    @Test
    public void testDesvioPadrao() {
        System.out.println("desvioPadrao");
        Data a1 = new Data(2000,12,3);
        Candidatura instance = new Candidatura(a1,50,3,"","");
        GrauProficiencia g1 = new GrauProficiencia("Capaz",9);
        GrauProficiencia g2 = new GrauProficiencia("Capaz",1);
        GrauProficiencia g3 = new GrauProficiencia("Capaz",0);
        GrauProficiencia g4 = new GrauProficiencia("Capaz",4);
        CompetenciaTecnica c1 = new CompetenciaTecnica("a","a","a");
        CompetenciaTecnica c2 = new CompetenciaTecnica("a","a","a");
        CompetenciaTecnica c3 = new CompetenciaTecnica("a","a","a");
        CompetenciaTecnica c4 = new CompetenciaTecnica("a","a","a");
        c1.setM_oGrau(g1);
        c2.setM_oGrau(g2);
        c3.setM_oGrau(g3);
        c4.setM_oGrau(g4);
        Freelancer f1 = new Freelancer("a","a","a","a");
        f1.getListaCompt().add(c1);
        f1.getListaCompt().add(c2);
        f1.getListaCompt().add(c3);
        f1.getListaCompt().add(c4);
        instance.setFreelancer(f1);

        double expResult = 3.5;
        double result = instance.desvioPadrao();
        assertEquals(expResult, result, 0.00);
    }


    /**
     * Test of mediaGrau method, of class Candidatura.
     */
    @Test
    public void testMediaGrau() {
        System.out.println("mediaGrau");
         Data a1 = new Data(2000,12,3);
        Candidatura instance = new Candidatura(a1,50,3,"","");
        GrauProficiencia g1 = new GrauProficiencia("Capaz",2);
        GrauProficiencia g2 = new GrauProficiencia("Capaz",2);
        GrauProficiencia g3 = new GrauProficiencia("Capaz",0);
        GrauProficiencia g4 = new GrauProficiencia("Capaz",6);
        CompetenciaTecnica c1 = new CompetenciaTecnica("a","a","a");
        CompetenciaTecnica c2 = new CompetenciaTecnica("a","a","a");
        CompetenciaTecnica c3 = new CompetenciaTecnica("a","a","a");
        CompetenciaTecnica c4 = new CompetenciaTecnica("a","a","a");
        c1.setM_oGrau(g1);
        c2.setM_oGrau(g2);
        c3.setM_oGrau(g3);
        c4.setM_oGrau(g4);
        Freelancer f1 = new Freelancer("a","a","a","a");
        f1.getListaCompt().add(c1);
        f1.getListaCompt().add(c2);
        f1.getListaCompt().add(c3);
        f1.getListaCompt().add(c4);
        instance.setFreelancer(f1);

        double expResult = 2.5;
        double result = instance.mediaGrau();
        assertEquals(expResult, result, 0.00);
    }

}
