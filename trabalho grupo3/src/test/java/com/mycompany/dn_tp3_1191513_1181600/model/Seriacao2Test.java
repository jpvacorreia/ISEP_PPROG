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
public class Seriacao2Test {

    public Seriacao2Test() {
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

     /** candidaturas iguais
     * Test of compare method, of class Seriacao2.
     */
    @Test
    public void testCompare() {
        System.out.println("compare");
        Data a1 = new Data(2000,12,3);
        Candidatura d1 = new Candidatura(a1,50,3,"","");
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
        d1.setFreelancer(f1);

        Data a2 = new Data(2000,12,3);
        Candidatura d2 = new Candidatura(a2,50,3,"","");
        GrauProficiencia m1 = new GrauProficiencia("Capaz",9);
        GrauProficiencia m2 = new GrauProficiencia("Capaz",1);
        GrauProficiencia m3 = new GrauProficiencia("Capaz",0);
        GrauProficiencia m4 = new GrauProficiencia("Capaz",4);
        CompetenciaTecnica e1 = new CompetenciaTecnica("a","a","a");
        CompetenciaTecnica e2 = new CompetenciaTecnica("a","a","a");
        CompetenciaTecnica e3 = new CompetenciaTecnica("a","a","a");
        CompetenciaTecnica e4 = new CompetenciaTecnica("a","a","a");
        e1.setM_oGrau(m1);
        e2.setM_oGrau(m2);
        e3.setM_oGrau(m3);
        e4.setM_oGrau(m4);
        Freelancer j1 = new Freelancer("a","a","a","a");
        j1.getListaCompt().add(e1);
        j1.getListaCompt().add(e2);
        j1.getListaCompt().add(e3);
        j1.getListaCompt().add(e4);
        d2.setFreelancer(j1);


        Seriacao2 instance = new Seriacao2();
        int expResult = 0;
        int result = instance.compare(d1, d2);
        assertEquals(expResult, result);

    }

    /** medias diferentes
     * media d1 > media d2
     * Test of compare method, of class Seriacao2.
     */
    @Test
    public void testCompare0() {
        System.out.println("compare");
        Data a1 = new Data(2000,12,3);
        Candidatura d1 = new Candidatura(a1,50,3,"","");
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
        d1.setFreelancer(f1);

        Data a2 = new Data(2000,12,3);
        Candidatura d2 = new Candidatura(a2,50,3,"","");
        GrauProficiencia m1 = new GrauProficiencia("Capaz",2);
        GrauProficiencia m2 = new GrauProficiencia("Capaz",1);
        GrauProficiencia m3 = new GrauProficiencia("Capaz",0);
        GrauProficiencia m4 = new GrauProficiencia("Capaz",1);
        CompetenciaTecnica e1 = new CompetenciaTecnica("a","a","a");
        CompetenciaTecnica e2 = new CompetenciaTecnica("a","a","a");
        CompetenciaTecnica e3 = new CompetenciaTecnica("a","a","a");
        CompetenciaTecnica e4 = new CompetenciaTecnica("a","a","a");
        e1.setM_oGrau(m1);
        e2.setM_oGrau(m2);
        e3.setM_oGrau(m3);
        e4.setM_oGrau(m4);
        Freelancer j1 = new Freelancer("a","a","a","a");
        j1.getListaCompt().add(e1);
        j1.getListaCompt().add(e2);
        j1.getListaCompt().add(e3);
        j1.getListaCompt().add(e4);
        d2.setFreelancer(j1);


        Seriacao2 instance = new Seriacao2();
        int expResult = -1;
        int result = instance.compare(d1, d2);
        assertEquals(expResult, result);

    }

    /**media igual
     * desvio padrao d2 > desvio padrao d1
     * Test of compare method, of class Seriacao2.
     */
    @Test
    public void testCompare1() {
        System.out.println("compare");
        Data a1 = new Data(2000,12,3);
        Candidatura d1 = new Candidatura(a1,50,3,"","");
        GrauProficiencia g1 = new GrauProficiencia("Capaz",3);
        GrauProficiencia g2 = new GrauProficiencia("Capaz",3);
        GrauProficiencia g3 = new GrauProficiencia("Capaz",3);
        GrauProficiencia g4 = new GrauProficiencia("Capaz",5);
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
        d1.setFreelancer(f1);

        Data a2 = new Data(2000,12,3);
        Candidatura d2 = new Candidatura(a2,60,3,"","");
        GrauProficiencia m1 = new GrauProficiencia("Capaz",9);
        GrauProficiencia m2 = new GrauProficiencia("Capaz",1);
        GrauProficiencia m3 = new GrauProficiencia("Capaz",0);
        GrauProficiencia m4 = new GrauProficiencia("Capaz",4);
        CompetenciaTecnica e1 = new CompetenciaTecnica("a","a","a");
        CompetenciaTecnica e2 = new CompetenciaTecnica("a","a","a");
        CompetenciaTecnica e3 = new CompetenciaTecnica("a","a","a");
        CompetenciaTecnica e4 = new CompetenciaTecnica("a","a","a");
        e1.setM_oGrau(m1);
        e2.setM_oGrau(m2);
        e3.setM_oGrau(m3);
        e4.setM_oGrau(m4);
        Freelancer j1 = new Freelancer("a","a","a","a");
        j1.getListaCompt().add(e1);
        j1.getListaCompt().add(e2);
        j1.getListaCompt().add(e3);
        j1.getListaCompt().add(e4);
        d2.setFreelancer(j1);


        Seriacao2 instance = new Seriacao2();
        int expResult = -1;
        int result = instance.compare(d1, d2);
        assertEquals(expResult, result);

    }

     /**media igual e desvio padrao igual
      * preco d1 < preco d2
     * Test of compare method, of class Seriacao2.
     */
    @Test
    public void testCompare2() {
        System.out.println("compare");
        Data a1 = new Data(2020,02,3);
        Candidatura d1 = new Candidatura(a1,50,3,"","");
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
        d1.setFreelancer(f1);

        Data a2 = new Data(2020,05,3);
        Candidatura d2 = new Candidatura(a2,60,3,"","");
        GrauProficiencia m1 = new GrauProficiencia("Capaz",9);
        GrauProficiencia m2 = new GrauProficiencia("Capaz",1);
        GrauProficiencia m3 = new GrauProficiencia("Capaz",0);
        GrauProficiencia m4 = new GrauProficiencia("Capaz",4);
        CompetenciaTecnica e1 = new CompetenciaTecnica("a","a","a");
        CompetenciaTecnica e2 = new CompetenciaTecnica("a","a","a");
        CompetenciaTecnica e3 = new CompetenciaTecnica("a","a","a");
        CompetenciaTecnica e4 = new CompetenciaTecnica("a","a","a");
        e1.setM_oGrau(m1);
        e2.setM_oGrau(m2);
        e3.setM_oGrau(m3);
        e4.setM_oGrau(m4);
        Freelancer j1 = new Freelancer("a","a","a","a");
        j1.getListaCompt().add(e1);
        j1.getListaCompt().add(e2);
        j1.getListaCompt().add(e3);
        j1.getListaCompt().add(e4);
        d2.setFreelancer(j1);


        Seriacao2 instance = new Seriacao2();
        int expResult = -1;
        int result = instance.compare(d1, d2);
        assertEquals(expResult, result);

    }

/**media igual e desvio padrao igual , preço igual
      * data d1> data d2
     * Test of compare method, of class Seriacao2.
     */
    @Test
    public void testCompare3() {
        System.out.println("compare");
        Data a1 = new Data(2020,02,3);
        Candidatura d1 = new Candidatura(a1,50,3,"","");
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
        d1.setFreelancer(f1);

        Data a2 = new Data(2020,05,3);
        Candidatura d2 = new Candidatura(a2,50,3,"","");
        GrauProficiencia m1 = new GrauProficiencia("Capaz",9);
        GrauProficiencia m2 = new GrauProficiencia("Capaz",1);
        GrauProficiencia m3 = new GrauProficiencia("Capaz",0);
        GrauProficiencia m4 = new GrauProficiencia("Capaz",4);
        CompetenciaTecnica e1 = new CompetenciaTecnica("a","a","a");
        CompetenciaTecnica e2 = new CompetenciaTecnica("a","a","a");
        CompetenciaTecnica e3 = new CompetenciaTecnica("a","a","a");
        CompetenciaTecnica e4 = new CompetenciaTecnica("a","a","a");
        e1.setM_oGrau(m1);
        e2.setM_oGrau(m2);
        e3.setM_oGrau(m3);
        e4.setM_oGrau(m4);
        Freelancer j1 = new Freelancer("a","a","a","a");
        j1.getListaCompt().add(e1);
        j1.getListaCompt().add(e2);
        j1.getListaCompt().add(e3);
        j1.getListaCompt().add(e4);
        d2.setFreelancer(j1);


        Seriacao2 instance = new Seriacao2();
        int expResult = -1;
        int result = instance.compare(d1, d2);
        assertEquals(expResult, result);

    }





}
