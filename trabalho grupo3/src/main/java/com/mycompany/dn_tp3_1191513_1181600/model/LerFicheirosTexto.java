/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dn_tp3_1191513_1181600.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Óscar Folha
 */
public class LerFicheirosTexto {
   
 public static final String NOME_FICH_COLABORADOR = "Colaborador.txt";
     /**
     * ficheiro com tarefas
     */
    public static final String NOME_FICH_TAREFA = "Tarefa.txt";
    
     /**
     * ficheiro com anuncio
     */
    public static final String NOME_FICH_ANUNCIO = "Anuncio.txt";
    
    /**
     * ficheiro com Areas de atividade
     */
    public static final String NOME_FICH_AREA_ATIVIDADE = "AreaAtividade.txt";
     /**
     * ficheiro com candidaturas
     */
    public static final String NOME_FICH_CANDIDATURA = "Candidatura.txt";
    
     /**
     * ficheiro com competencias tecnics
     */
    public static final String NOME_FICH_CT = "CompetenciaTecnica.txt";
    
    /**
     * ficheiro com freelancers
     */
    public static final String NOME_FICH_FREELANCER = "Freelancer.txt";
     /**
     * ficheiro com graus profeciencia
     */
    public static final String NOME_FICH_GRAU = "GrauProfeciencia.txt";
    
    
  
    /**
     * novo array de Colaboradores
     */
    private static List<Colaborador> ListaColaborador = new ArrayList();
    
   /**
    * novo array de Tarefas
    */ 
   private static List<Tarefa> ListaTarefa = new ArrayList();
   
    /**
    * novo array de Anuncio
    */ 
   private static List<Anuncio> ListaAnuncio = new ArrayList();
   /**
     * novo array de areas atividade
     */
    private static List<AreaAtividade> ListaAreasAtividade = new ArrayList();
    
   /**
    * novo array de candidaturas
    */ 
   private static List<Candidatura> ListaCandidatura = new ArrayList();
   
    /**
    * novo array de CT
    */ 
   private static List<CompetenciaTecnica> ListaCT = new ArrayList();
   
   /**
     * novo array de Freelancers
     */
    private static List<Freelancer> ListaFreelancer = new ArrayList();
    
   /**
    * novo array de graus Proficiencia
    */ 
   private static List<GrauProficiencia> ListaGrau = new ArrayList();
   
    
    /**
     * lê todos os ficheiros e criar todos os objetos necessários para o trabalho
     * @throws FileNotFoundException 
     */
    public static void lerFicheirosCriacao() throws FileNotFoundException {
        lerFichColaborador();
        lerFichTarefa();
        lerFichAnuncio();
        lerFichAreaAtividade();
        lerFichCandidatura();
        lerFichCT();
        lerFichFreelancer();
        lerFichGrau();
        criarObjetos();
        
    }
  
    /**
     * a partir das listas com ficheiros txt forma e molda os objetos
     * necessarios
     */
    public static void criarObjetos() {
        criarCT();
        criarFree();
        criarCandidatura();
        criarAnuncio();
        criarTarefa();
        criarColaborador();
    }

    /**
     *
     * @throws FileNotFoundException
     */
    public static void lerFichColaborador() throws FileNotFoundException {

        Scanner fich = new Scanner(new File(NOME_FICH_COLABORADOR));

        while (fich.hasNext()) {

            String linha = fich.nextLine();
            String[] temp = linha.trim().split(";");
            Colaborador col = new Colaborador(temp[0], temp[1], temp[2], temp[3]);

            ListaColaborador.add(col);
        }
    }

    /**
     *
     * @throws FileNotFoundException
     */
    public static void lerFichTarefa() throws FileNotFoundException {

        Scanner fich = new Scanner(new File(NOME_FICH_TAREFA));

        while (fich.hasNext()) {

            String linha = fich.nextLine();
            String[] temp = linha.trim().split(";");

            Tarefa tar = new Tarefa(temp[0], temp[1], temp[2], temp[3], Double.parseDouble(temp[4]), Double.parseDouble(temp[5]));

            ListaTarefa.add(tar);
        }

    }

    public static void lerFichAnuncio() throws FileNotFoundException {

        Scanner fich = new Scanner(new File(NOME_FICH_ANUNCIO));

        while (fich.hasNext()) {

            String linha = fich.nextLine();
            String[] temp = linha.trim().split(";");
            Data data1 = new Data((Integer.parseInt(temp[0])), (Integer.parseInt(temp[1])), (Integer.parseInt(temp[2])));
            Data data2 = new Data((Integer.parseInt(temp[3])), (Integer.parseInt(temp[4])), (Integer.parseInt(temp[5])));
            Data data3 = new Data((Integer.parseInt(temp[6])), (Integer.parseInt(temp[7])), (Integer.parseInt(temp[8])));
            Data data4 = new Data((Integer.parseInt(temp[9])), (Integer.parseInt(temp[10])), (Integer.parseInt(temp[11])));
            Data data5 = new Data((Integer.parseInt(temp[12])), (Integer.parseInt(temp[13])), (Integer.parseInt(temp[14])));
            Data data6 = new Data((Integer.parseInt(temp[15])), (Integer.parseInt(temp[16])), (Integer.parseInt(temp[17])));

            Anuncio anu = new Anuncio(data1, data2, data3, data4, data5, data6);

            ListaAnuncio.add(anu);
        }

    }

    /**
     *
     * @throws FileNotFoundException
     */
    public static void lerFichAreaAtividade() throws FileNotFoundException {

        Scanner fich = new Scanner(new File(NOME_FICH_AREA_ATIVIDADE));

        while (fich.hasNext()) {

            String linha = fich.nextLine();
            String[] temp = linha.trim().split(";");

            AreaAtividade are = new AreaAtividade(temp[0], temp[1], temp[2]);

            ListaAreasAtividade.add(are);
        }
    }

    /**
     *
     * @throws FileNotFoundException
     */
    public static void lerFichCandidatura() throws FileNotFoundException {

        Scanner fich = new Scanner(new File(NOME_FICH_CANDIDATURA));

        while (fich.hasNext()) {

            String linha = fich.nextLine();
            String[] temp = linha.trim().split(";");
            Data data1 = new Data((Integer.parseInt(temp[0])), (Integer.parseInt(temp[1])), (Integer.parseInt(temp[2])));
            Candidatura cand = new Candidatura(data1,Double.parseDouble(temp[3]), Integer.parseInt(temp[4]), temp[5], temp[6]);

            ListaCandidatura.add(cand);
        }
    }

    /**
     *
     * @throws FileNotFoundException
     */
    public static void lerFichCT() throws FileNotFoundException {

        Scanner fich = new Scanner(new File(NOME_FICH_CT));

        while (fich.hasNext()) {

            String linha = fich.nextLine();
            String[] temp = linha.trim().split(";");

            CompetenciaTecnica ct = new CompetenciaTecnica(temp[0], temp[1], temp[2]);

            ListaCT.add(ct);
        }
    }

    /**
     *
     * @throws FileNotFoundException
     */
    public static void lerFichFreelancer() throws FileNotFoundException {

        Scanner fich = new Scanner(new File(NOME_FICH_FREELANCER));

        while (fich.hasNext()) {

            String linha = fich.nextLine();
            String[] temp = linha.trim().split(";");

            Freelancer free = new Freelancer(temp[0], temp[1], temp[2], temp[3]);

            ListaFreelancer.add(free);
        }
    }

    /**
     *
     * @throws FileNotFoundException
     */
    public static void lerFichGrau() throws FileNotFoundException {

        Scanner fich = new Scanner(new File(NOME_FICH_GRAU));

        while (fich.hasNext()) {

            String linha = fich.nextLine();
            String[] temp = linha.trim().split(";");

            GrauProficiencia gp = new GrauProficiencia(temp[0], Integer.parseInt(temp[1]));

            ListaGrau.add(gp);
        }
    }

    public static void criarCT() {

        // COLABORADOR 1 CT'S
        
        // aqui são criados os CT's para os freelancers que vão realizar Tarefa e o CT da mesma tarefa com o seu grau prof. minimo
        
        // tarefa1
        ListaCT.get(0).setM_oGrau(ListaGrau.get(1));  // prof. minimo
        ListaCT.get(1).setM_oGrau(ListaGrau.get(2));
        ListaCT.get(2).setM_oGrau(ListaGrau.get(3));
        ListaCT.get(0).setM_oAreaAtividade(ListaAreasAtividade.get(0));
        ListaCT.get(1).setM_oAreaAtividade(ListaAreasAtividade.get(0));
        ListaCT.get(2).setM_oAreaAtividade(ListaAreasAtividade.get(0));

        // tarefa2
        ListaCT.get(3).setM_oGrau(ListaGrau.get(1));    // prof minimo
        ListaCT.get(4).setM_oGrau(ListaGrau.get(2));
        ListaCT.get(5).setM_oGrau(ListaGrau.get(3));
        ListaCT.get(3).setM_oAreaAtividade(ListaAreasAtividade.get(1));
        ListaCT.get(4).setM_oAreaAtividade(ListaAreasAtividade.get(1));
        ListaCT.get(5).setM_oAreaAtividade(ListaAreasAtividade.get(1));
        
        // tarefa2
        ListaCT.get(6).setM_oGrau(ListaGrau.get(1));    // prof minimo
        ListaCT.get(7).setM_oGrau(ListaGrau.get(2));
        ListaCT.get(8).setM_oGrau(ListaGrau.get(3));
        ListaCT.get(6).setM_oAreaAtividade(ListaAreasAtividade.get(2));
        ListaCT.get(7).setM_oAreaAtividade(ListaAreasAtividade.get(2));
        ListaCT.get(8).setM_oAreaAtividade(ListaAreasAtividade.get(2));
        
        // COLABORADOR 2 CT'S
        
        // aqui são criados os CT's para os freelancers que vão realizar Tarefa e o CT da mesma tarefa com o seu grau prof. minimo
        
        // tarefa1
        ListaCT.get(9).setM_oGrau(ListaGrau.get(1));  // prof. minimo
        ListaCT.get(10).setM_oGrau(ListaGrau.get(2));
        ListaCT.get(11).setM_oGrau(ListaGrau.get(3));
        ListaCT.get(9).setM_oAreaAtividade(ListaAreasAtividade.get(3));
        ListaCT.get(10).setM_oAreaAtividade(ListaAreasAtividade.get(3));
        ListaCT.get(11).setM_oAreaAtividade(ListaAreasAtividade.get(3));

        // tarefa2
        ListaCT.get(12).setM_oGrau(ListaGrau.get(1));    // prof minimo
        ListaCT.get(13).setM_oGrau(ListaGrau.get(2));
        ListaCT.get(14).setM_oGrau(ListaGrau.get(3));
        ListaCT.get(12).setM_oAreaAtividade(ListaAreasAtividade.get(4));
        ListaCT.get(13).setM_oAreaAtividade(ListaAreasAtividade.get(4));
        ListaCT.get(14).setM_oAreaAtividade(ListaAreasAtividade.get(4));
        
        // tarefa2
        ListaCT.get(15).setM_oGrau(ListaGrau.get(1));    // prof minimo
        ListaCT.get(16).setM_oGrau(ListaGrau.get(2));
        ListaCT.get(17).setM_oGrau(ListaGrau.get(3));
        ListaCT.get(15).setM_oAreaAtividade(ListaAreasAtividade.get(5));
        ListaCT.get(16).setM_oAreaAtividade(ListaAreasAtividade.get(5));
        ListaCT.get(17).setM_oAreaAtividade(ListaAreasAtividade.get(5));
      
        // COLABORADOR 3 CT'S
        
        // aqui são criados os CT's para os freelancers que vão realizar Tarefa e o CT da mesma tarefa com o seu grau prof. minimo
        
        // tarefa1
        ListaCT.get(18).setM_oGrau(ListaGrau.get(1));  // prof. minimo
        ListaCT.get(19).setM_oGrau(ListaGrau.get(2));
        ListaCT.get(20).setM_oGrau(ListaGrau.get(3));
        ListaCT.get(18).setM_oAreaAtividade(ListaAreasAtividade.get(6));
        ListaCT.get(19).setM_oAreaAtividade(ListaAreasAtividade.get(6));
        ListaCT.get(20).setM_oAreaAtividade(ListaAreasAtividade.get(6));

        // tarefa2
        ListaCT.get(21).setM_oGrau(ListaGrau.get(1));    // prof minimo
        ListaCT.get(22).setM_oGrau(ListaGrau.get(2));
        ListaCT.get(23).setM_oGrau(ListaGrau.get(3));
        ListaCT.get(21).setM_oAreaAtividade(ListaAreasAtividade.get(7));
        ListaCT.get(22).setM_oAreaAtividade(ListaAreasAtividade.get(7));
        ListaCT.get(23).setM_oAreaAtividade(ListaAreasAtividade.get(7));
        
        // tarefa3
        ListaCT.get(24).setM_oGrau(ListaGrau.get(1));    // prof minimo
        ListaCT.get(25).setM_oGrau(ListaGrau.get(2));
        ListaCT.get(26).setM_oGrau(ListaGrau.get(3));
        ListaCT.get(24).setM_oAreaAtividade(ListaAreasAtividade.get(8));
        ListaCT.get(25).setM_oAreaAtividade(ListaAreasAtividade.get(8));
        ListaCT.get(26).setM_oAreaAtividade(ListaAreasAtividade.get(8));
        
        // COLABORADOR 4 CT'S
        
        // aqui são criados os CT's para os freelancers que vão realizar Tarefa e o CT da mesma tarefa com o seu grau prof. minimo
        
        // tarefa1
        ListaCT.get(27).setM_oGrau(ListaGrau.get(3));
        ListaCT.get(28).setM_oGrau(ListaGrau.get(2));
        ListaCT.get(29).setM_oGrau(ListaGrau.get(2));
        ListaCT.get(30).setM_oGrau(ListaGrau.get(2));
        ListaCT.get(31).setM_oGrau(ListaGrau.get(3));
        ListaCT.get(32).setM_oGrau(ListaGrau.get(2));
        ListaCT.get(33).setM_oGrau(ListaGrau.get(2));
        ListaCT.get(34).setM_oGrau(ListaGrau.get(2));
        ListaCT.get(27).setM_oAreaAtividade(ListaAreasAtividade.get(9));
        ListaCT.get(28).setM_oAreaAtividade(ListaAreasAtividade.get(9));
        ListaCT.get(29).setM_oAreaAtividade(ListaAreasAtividade.get(9));
        ListaCT.get(30).setM_oAreaAtividade(ListaAreasAtividade.get(9));
        ListaCT.get(31).setM_oAreaAtividade(ListaAreasAtividade.get(9));
        ListaCT.get(32).setM_oAreaAtividade(ListaAreasAtividade.get(9));
        ListaCT.get(33).setM_oAreaAtividade(ListaAreasAtividade.get(9));
        ListaCT.get(34).setM_oAreaAtividade(ListaAreasAtividade.get(9));
       
        
        
        // tarefa2
        ListaCT.get(35).setM_oGrau(ListaGrau.get(3));
        ListaCT.get(36).setM_oGrau(ListaGrau.get(2));
        ListaCT.get(37).setM_oGrau(ListaGrau.get(1));
        ListaCT.get(38).setM_oGrau(ListaGrau.get(1));
        ListaCT.get(39).setM_oGrau(ListaGrau.get(1));
        ListaCT.get(40).setM_oGrau(ListaGrau.get(3));
        ListaCT.get(41).setM_oGrau(ListaGrau.get(2));
        ListaCT.get(42).setM_oGrau(ListaGrau.get(3));
        ListaCT.get(43).setM_oGrau(ListaGrau.get(3));
        ListaCT.get(44).setM_oGrau(ListaGrau.get(3));
        ListaCT.get(35).setM_oAreaAtividade(ListaAreasAtividade.get(9));
        ListaCT.get(36).setM_oAreaAtividade(ListaAreasAtividade.get(9));
        ListaCT.get(37).setM_oAreaAtividade(ListaAreasAtividade.get(9));
        ListaCT.get(38).setM_oAreaAtividade(ListaAreasAtividade.get(9));
        ListaCT.get(39).setM_oAreaAtividade(ListaAreasAtividade.get(9));
        ListaCT.get(40).setM_oAreaAtividade(ListaAreasAtividade.get(9));
        ListaCT.get(41).setM_oAreaAtividade(ListaAreasAtividade.get(9));
        ListaCT.get(42).setM_oAreaAtividade(ListaAreasAtividade.get(9));
        ListaCT.get(43).setM_oAreaAtividade(ListaAreasAtividade.get(9));
        ListaCT.get(44).setM_oAreaAtividade(ListaAreasAtividade.get(9));
        

    }

    public static void criarFree() {

        // COLABORADOR 1 FREELANCERS
        
        // os freelancers já existentes recebem um CT.
        
        // tarefa 1
        ListaFreelancer.get(0).getListaCompt().add(ListaCT.get(0));
        ListaFreelancer.get(1).getListaCompt().add(ListaCT.get(1));
        ListaFreelancer.get(2).getListaCompt().add(ListaCT.get(2));

        // tarefa 2
        ListaFreelancer.get(3).getListaCompt().add(ListaCT.get(5));
        ListaFreelancer.get(4).getListaCompt().add(ListaCT.get(4));
        ListaFreelancer.get(5).getListaCompt().add(ListaCT.get(3));
        
        // tarefa 3
        ListaFreelancer.get(6).getListaCompt().add(ListaCT.get(6));
        ListaFreelancer.get(7).getListaCompt().add(ListaCT.get(8));
        ListaFreelancer.get(8).getListaCompt().add(ListaCT.get(7));
        
        // COLABORADOR 2 FREELANCERS
        
        // os freelancers já existentes recebem um CT.
        
        // tarefa 1
        ListaFreelancer.get(9).getListaCompt().add(ListaCT.get(9));
        ListaFreelancer.get(10).getListaCompt().add(ListaCT.get(10));
        ListaFreelancer.get(11).getListaCompt().add(ListaCT.get(11));

        // tarefa 2
        ListaFreelancer.get(12).getListaCompt().add(ListaCT.get(14));
        ListaFreelancer.get(13).getListaCompt().add(ListaCT.get(13));
        ListaFreelancer.get(14).getListaCompt().add(ListaCT.get(12));
        
        // tarefa 3
        ListaFreelancer.get(15).getListaCompt().add(ListaCT.get(17));
        ListaFreelancer.get(16).getListaCompt().add(ListaCT.get(15));
        ListaFreelancer.get(17).getListaCompt().add(ListaCT.get(16));
        
        // COLABORADOR 3 FREELANCERS
        
        // os freelancers já existentes recebem um CT.
        
        // tarefa 1
        ListaFreelancer.get(18).getListaCompt().add(ListaCT.get(18));
        ListaFreelancer.get(19).getListaCompt().add(ListaCT.get(19));
        ListaFreelancer.get(20).getListaCompt().add(ListaCT.get(20));

        // tarefa 2
        ListaFreelancer.get(21).getListaCompt().add(ListaCT.get(23));
        ListaFreelancer.get(22).getListaCompt().add(ListaCT.get(22));
        ListaFreelancer.get(23).getListaCompt().add(ListaCT.get(21));
        
        // tarefa 3
        ListaFreelancer.get(24).getListaCompt().add(ListaCT.get(25));
        ListaFreelancer.get(25).getListaCompt().add(ListaCT.get(24));
        ListaFreelancer.get(26).getListaCompt().add(ListaCT.get(26));
        
        // COLABORADOR 4 FREELANCERS
        
        // os freelancers já existentes recebem um CT.
        
        // tarefa 1
        ListaFreelancer.get(27).getListaCompt().add(ListaCT.get(27));
        ListaFreelancer.get(28).getListaCompt().add(ListaCT.get(28));
        ListaFreelancer.get(29).getListaCompt().add(ListaCT.get(29));
        ListaFreelancer.get(30).getListaCompt().add(ListaCT.get(30));
        ListaFreelancer.get(27).getListaCompt().add(ListaCT.get(31));
        ListaFreelancer.get(28).getListaCompt().add(ListaCT.get(31));
        ListaFreelancer.get(29).getListaCompt().add(ListaCT.get(33));
        ListaFreelancer.get(30).getListaCompt().add(ListaCT.get(34));

        // tarefa 2
        ListaFreelancer.get(31).getListaCompt().add(ListaCT.get(35));
        ListaFreelancer.get(32).getListaCompt().add(ListaCT.get(36));
        ListaFreelancer.get(33).getListaCompt().add(ListaCT.get(37));
        ListaFreelancer.get(34).getListaCompt().add(ListaCT.get(38));
        ListaFreelancer.get(35).getListaCompt().add(ListaCT.get(39));
        ListaFreelancer.get(31).getListaCompt().add(ListaCT.get(40));
        ListaFreelancer.get(32).getListaCompt().add(ListaCT.get(41));
        ListaFreelancer.get(33).getListaCompt().add(ListaCT.get(42));
        ListaFreelancer.get(34).getListaCompt().add(ListaCT.get(43));
        ListaFreelancer.get(35).getListaCompt().add(ListaCT.get(44));
        
    

    }

    public static void criarCandidatura() {

        //COLABORADOR 1 CANDIDATURAS
        
        // as candidaturas já existentes recebem um freelancer
        
        // tarefa 1
        ListaCandidatura.get(0).setFreelancer(ListaFreelancer.get(0));
        ListaCandidatura.get(1).setFreelancer(ListaFreelancer.get(1));
        ListaCandidatura.get(2).setFreelancer(ListaFreelancer.get(2));

        // tarefa 2
        ListaCandidatura.get(3).setFreelancer(ListaFreelancer.get(3));
        ListaCandidatura.get(4).setFreelancer(ListaFreelancer.get(4));
        ListaCandidatura.get(5).setFreelancer(ListaFreelancer.get(5));
        
        // tarefa 3
        ListaCandidatura.get(6).setFreelancer(ListaFreelancer.get(6));
        ListaCandidatura.get(7).setFreelancer(ListaFreelancer.get(7));
        ListaCandidatura.get(8).setFreelancer(ListaFreelancer.get(8));
        
        //COLABORADOR 2 CANDIDATURAS
        
        // as candidaturas já existentes recebem um freelancer
        
        // tarefa 1
        ListaCandidatura.get(9).setFreelancer(ListaFreelancer.get(9));
        ListaCandidatura.get(10).setFreelancer(ListaFreelancer.get(10));
        ListaCandidatura.get(11).setFreelancer(ListaFreelancer.get(11));

        // tarefa 2
        ListaCandidatura.get(12).setFreelancer(ListaFreelancer.get(12));
        ListaCandidatura.get(13).setFreelancer(ListaFreelancer.get(13));
        ListaCandidatura.get(14).setFreelancer(ListaFreelancer.get(14));
        
        // tarefa 3
        ListaCandidatura.get(15).setFreelancer(ListaFreelancer.get(15));
        ListaCandidatura.get(16).setFreelancer(ListaFreelancer.get(16));
        ListaCandidatura.get(17).setFreelancer(ListaFreelancer.get(17));
        
         //COLABORADOR 3 CANDIDATURAS
        
        // as candidaturas já existentes recebem um freelancer
        
        // tarefa 1
        ListaCandidatura.get(18).setFreelancer(ListaFreelancer.get(18));
        ListaCandidatura.get(19).setFreelancer(ListaFreelancer.get(19));
        ListaCandidatura.get(20).setFreelancer(ListaFreelancer.get(20));

        // tarefa 2
        ListaCandidatura.get(21).setFreelancer(ListaFreelancer.get(21));
        ListaCandidatura.get(22).setFreelancer(ListaFreelancer.get(22));
        ListaCandidatura.get(23).setFreelancer(ListaFreelancer.get(23));
        
        // tarefa 3
        ListaCandidatura.get(24).setFreelancer(ListaFreelancer.get(24));
        ListaCandidatura.get(25).setFreelancer(ListaFreelancer.get(25));
        ListaCandidatura.get(26).setFreelancer(ListaFreelancer.get(26));
        
         //COLABORADOR 4 CANDIDATURAS
        
        // as candidaturas já existentes recebem um freelancer
        
        // tarefa 1
        ListaCandidatura.get(27).setFreelancer(ListaFreelancer.get(27));
        ListaCandidatura.get(28).setFreelancer(ListaFreelancer.get(28));
        ListaCandidatura.get(29).setFreelancer(ListaFreelancer.get(29));
        ListaCandidatura.get(30).setFreelancer(ListaFreelancer.get(30));

        // tarefa 2
        ListaCandidatura.get(31).setFreelancer(ListaFreelancer.get(31));
        ListaCandidatura.get(32).setFreelancer(ListaFreelancer.get(32));
        ListaCandidatura.get(33).setFreelancer(ListaFreelancer.get(33));
        ListaCandidatura.get(34).setFreelancer(ListaFreelancer.get(34));
        ListaCandidatura.get(35).setFreelancer(ListaFreelancer.get(35));
        
        
        
    }
    

    public static void criarAnuncio() {

        // COLABORADOR 1 ANUNCIOS
        
        // os Anuncios já existentes, recebem as suas candidaturas
        
        // tarefa 1
        ListaAnuncio.get(0).getListaCandidatura().add(ListaCandidatura.get(0));
        ListaAnuncio.get(0).getListaCandidatura().add(ListaCandidatura.get(1));
        ListaAnuncio.get(0).getListaCandidatura().add(ListaCandidatura.get(2));

        // tarefa 2
        ListaAnuncio.get(1).getListaCandidatura().add(ListaCandidatura.get(3));
        ListaAnuncio.get(1).getListaCandidatura().add(ListaCandidatura.get(4));
        ListaAnuncio.get(1).getListaCandidatura().add(ListaCandidatura.get(5));
        
        // tarefa 3
        ListaAnuncio.get(2).getListaCandidatura().add(ListaCandidatura.get(6));
        ListaAnuncio.get(2).getListaCandidatura().add(ListaCandidatura.get(7));
        ListaAnuncio.get(2).getListaCandidatura().add(ListaCandidatura.get(8));
        
        // COLABORADOR 2 ANUNCIOS
        
        // os Anuncios já existentes, recebem as suas candidaturas
        
        // tarefa 1
        ListaAnuncio.get(3).getListaCandidatura().add(ListaCandidatura.get(9));
        ListaAnuncio.get(3).getListaCandidatura().add(ListaCandidatura.get(10));
        ListaAnuncio.get(3).getListaCandidatura().add(ListaCandidatura.get(11));

        // tarefa 2
        ListaAnuncio.get(4).getListaCandidatura().add(ListaCandidatura.get(12));
        ListaAnuncio.get(4).getListaCandidatura().add(ListaCandidatura.get(13));
        ListaAnuncio.get(4).getListaCandidatura().add(ListaCandidatura.get(14));
        
        // tarefa 3
        ListaAnuncio.get(5).getListaCandidatura().add(ListaCandidatura.get(15));
        ListaAnuncio.get(5).getListaCandidatura().add(ListaCandidatura.get(16));
        ListaAnuncio.get(5).getListaCandidatura().add(ListaCandidatura.get(17));
        
        // COLABORADOR 3 ANUNCIOS
        
        // os Anuncios já existentes, recebem as suas candidaturas
        
        // tarefa 1
        ListaAnuncio.get(6).getListaCandidatura().add(ListaCandidatura.get(18));
        ListaAnuncio.get(6).getListaCandidatura().add(ListaCandidatura.get(19));
        ListaAnuncio.get(6).getListaCandidatura().add(ListaCandidatura.get(20));

        // tarefa 2
        ListaAnuncio.get(7).getListaCandidatura().add(ListaCandidatura.get(21));
        ListaAnuncio.get(7).getListaCandidatura().add(ListaCandidatura.get(22));
        ListaAnuncio.get(7).getListaCandidatura().add(ListaCandidatura.get(23));
        
        // tarefa 3
        ListaAnuncio.get(8).getListaCandidatura().add(ListaCandidatura.get(24));
        ListaAnuncio.get(8).getListaCandidatura().add(ListaCandidatura.get(25));
        ListaAnuncio.get(8).getListaCandidatura().add(ListaCandidatura.get(26));
        
        // COLABORADOR 4 ANUNCIOS
        
        // os Anuncios já existentes, recebem as suas candidaturas
        
        // tarefa 1
        ListaAnuncio.get(9).getListaCandidatura().add(ListaCandidatura.get(30));
        ListaAnuncio.get(9).getListaCandidatura().add(ListaCandidatura.get(27));
        ListaAnuncio.get(9).getListaCandidatura().add(ListaCandidatura.get(29));
        ListaAnuncio.get(9).getListaCandidatura().add(ListaCandidatura.get(28));

        // tarefa 2
        ListaAnuncio.get(10).getListaCandidatura().add(ListaCandidatura.get(32));
        ListaAnuncio.get(10).getListaCandidatura().add(ListaCandidatura.get(33));
        ListaAnuncio.get(10).getListaCandidatura().add(ListaCandidatura.get(34));
        ListaAnuncio.get(10).getListaCandidatura().add(ListaCandidatura.get(31));
        ListaAnuncio.get(10).getListaCandidatura().add(ListaCandidatura.get(35));
        
        
        
        
    }

    public static void criarTarefa() {

        // COLABORADOR 1 TAREFAS
        
        // as tarefas recebem o seu respetivo anuncio e o CT com grau prof minimo
        
        // tarefa 1
        ListaTarefa.get(0).setAnuncio(ListaAnuncio.get(0));
        ListaTarefa.get(0).getListaCompt().add(ListaCT.get(0));

        // tarefa 2
        ListaTarefa.get(1).setAnuncio(ListaAnuncio.get(1));
        ListaTarefa.get(1).getListaCompt().add(ListaCT.get(3));
        
        // tarefa 3
        ListaTarefa.get(2).setAnuncio(ListaAnuncio.get(2));
        ListaTarefa.get(2).getListaCompt().add(ListaCT.get(6));
        
        // COLABORADOR 2 TAREFAS
        
        // as tarefas recebem o seu respetivo anuncio e o CT com grau prof minimo
        
        // tarefa 1
        ListaTarefa.get(3).setAnuncio(ListaAnuncio.get(3));
        ListaTarefa.get(3).getListaCompt().add(ListaCT.get(9));

        // tarefa 2
        ListaTarefa.get(4).setAnuncio(ListaAnuncio.get(4));
        ListaTarefa.get(4).getListaCompt().add(ListaCT.get(12));
        
        // tarefa 3
        ListaTarefa.get(5).setAnuncio(ListaAnuncio.get(5));
        ListaTarefa.get(5).getListaCompt().add(ListaCT.get(15));
        
        // COLABORADOR 3 TAREFAS
        
        // as tarefas recebem o seu respetivo anuncio e o CT com grau prof minimo
        
        // tarefa 1
        ListaTarefa.get(6).setAnuncio(ListaAnuncio.get(6));
        ListaTarefa.get(6).getListaCompt().add(ListaCT.get(18));

        // tarefa 2
        ListaTarefa.get(7).setAnuncio(ListaAnuncio.get(7));
        ListaTarefa.get(7).getListaCompt().add(ListaCT.get(21));
        
        // tarefa 3
        ListaTarefa.get(8).setAnuncio(ListaAnuncio.get(8));
        ListaTarefa.get(8).getListaCompt().add(ListaCT.get(24));
        
        // COLABORADOR 4 TAREFAS
        
        // as tarefas recebem o seu respetivo anuncio e o CT com grau prof minimo
        
        // tarefa 1
        ListaTarefa.get(9).setAnuncio(ListaAnuncio.get(9));
        ListaTarefa.get(9).getListaCompt().add(ListaCT.get(28));
        ListaTarefa.get(9).getListaCompt().add(ListaCT.get(34));

        // tarefa 2
        ListaTarefa.get(10).setAnuncio(ListaAnuncio.get(10));
        ListaTarefa.get(10).getListaCompt().add(ListaCT.get(37));
        ListaTarefa.get(9).getListaCompt().add(ListaCT.get(41));
        
        
        

    }

    public static void criarColaborador() {
        // COLABORADOR 1

        // colaborador recebe as suas tarefas
        ListaColaborador.get(0).getListaTarefas().add(ListaTarefa.get(0));
        ListaColaborador.get(0).getListaTarefas().add(ListaTarefa.get(1));
        ListaColaborador.get(0).getListaTarefas().add(ListaTarefa.get(2));
        
        // COLABORADOR 2

        // colaborador recebe as suas tarefas
        ListaColaborador.get(1).getListaTarefas().add(ListaTarefa.get(3));
        ListaColaborador.get(1).getListaTarefas().add(ListaTarefa.get(4));
        ListaColaborador.get(1).getListaTarefas().add(ListaTarefa.get(5));
        
        // COLABORADOR 3

        // colaborador recebe as suas tarefas
        ListaColaborador.get(2).getListaTarefas().add(ListaTarefa.get(6));
        ListaColaborador.get(2).getListaTarefas().add(ListaTarefa.get(7));
        ListaColaborador.get(2).getListaTarefas().add(ListaTarefa.get(8));
        
        // COLABORADOR 4

        // colaborador recebe as suas tarefas
        ListaColaborador.get(3).getListaTarefas().add(ListaTarefa.get(9));
        ListaColaborador.get(3).getListaTarefas().add(ListaTarefa.get(10));
     
    }

    public static List<Colaborador> getListaColaborador() {
        return ListaColaborador;
    }

    public static List<Tarefa> getListaTarefa() {
        return ListaTarefa;
    }

    public static List<Anuncio> getListaAnuncio() {
        return ListaAnuncio;
    }

    public static List<Candidatura> getListaCandidatura() {
        return ListaCandidatura;
    }

    public static List<Freelancer> getListaFreelancer() {
        return ListaFreelancer;
    }
    
 
}
