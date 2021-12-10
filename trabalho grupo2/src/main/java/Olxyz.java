

public class Olxyz {

    /**
     * Este método avalia se o Alugavel foi adicionado ou não há lista de Alugaveis
     * Caso não tenha sido adicionado, retorna uma mensagem com o seu nome.
     * @param add
     * @param e 
     */
    public static void confirmarAddAlugavel(boolean add, Anunciante e){
        if(add==false){
            System.out.println("Erro na adição de um Alugável do Anunciante: "+e.getNome()+" , LISTA CHEIA\n");    
        }
    }
    
    /**
     * Este método avalia se o Vendavel foi adicionado ou não há lista de Vendáveis
     * Caso não tenha sido adicionado, retorna uma mensagem com o seu nome. 
     * @param add
     * @param e 
     */
    public static void confirmarAddVendavel(boolean add, Anunciante e){
        if(add==false){
            System.out.println("Erro na adição de um Vendavel do Anunciante: "+e.getNome()+" , LISTA CHEIA\n");    
        }
    }
    
    
    
    public static void main(String[] args) {

        //b.1)  Criar a classe (principal) Olxyz com um contentor do tipo array capaz de conter 5 Anunciantes
        Anunciante[] anunciantes = new Anunciante[5];

        //b.2) Adicionar um Anunciante (a1) que pretende vender 1 telemovel e alugar 1 apartamento + 1 carro 
        Endereco e1 = new Endereco("Rua Trás do Monte", "4455-333", "Matosinhos");
        Anunciante a1 = new Anunciante("Paulo Gomes", e1);

        Telemovel t1 = new Telemovel("IPhoneX", 1200);

        Endereco apEndereco1 = new Endereco("Rua Gonçalves Zarco", "4450-222", "Leça");
        Apartamento ap1 = new Apartamento(apEndereco1, 120, 300);

        Automovel au1 = new Automovel("Ferrari", "X", 0, 300);

       
        confirmarAddVendavel(a1.addVendavel(t1),a1);
        confirmarAddAlugavel(a1.addAlugavel(ap1),a1);
        confirmarAddAlugavel(a1.addAlugavel(au1),a1);
        anunciantes[0] = (a1);


        //b.3) Adicionar um Anunciante (a2) que pretende vender 1 carro + 1 telemovel e alugar 1 apartamento
        Endereco e2 = new Endereco("Rua Marues", "4430-111", "Esposade");
        Anunciante a2 = new Anunciante("Sergio Folha", e2);

        Telemovel t2 = new Telemovel("Samsung galaxy 9", 600);

        Endereco apEndereco2 = new Endereco("Rua Boris", "4500-333", "Foz");
        Apartamento ap2 = new Apartamento(apEndereco2, 200, 3200);

        Automovel au2 = new Automovel("Seat Ibiza", "1", 1000, 0);

        confirmarAddVendavel(a2.addVendavel(au2),a2);
        confirmarAddVendavel(a2.addVendavel(t2),a2);
        confirmarAddAlugavel(a2.addAlugavel(ap2),a2);
       
        anunciantes[1] = (a2);

        //b.4) Adicionar um Anunciante (a3) que pretende alugar 2 apartamentos
        Endereco e3 = new Endereco("Rua Bilbau", "2500-333", "Caldas da Rainha");
        Anunciante a3 = new Anunciante("Mariana Rebelo", e3);


        Endereco apEndereco3 = new Endereco("Rua Baleal", "2400-111", "Peniche");
        Apartamento ap3 = new Apartamento(apEndereco3, 100, 300);

        Endereco apEndereco4 = new Endereco("Rua Nelson Custódio", "1000-039", "Lisboa");
        Apartamento ap4 = new Apartamento(apEndereco4, 200, 520);

        confirmarAddAlugavel(a3.addAlugavel(ap3),a3);
        confirmarAddAlugavel(a3.addAlugavel(ap4),a3);
        anunciantes[2] = (a3);


        
        System.out.println("\nAlínea b.5");
        int alugaveis = 0;
        for (int i = 0; i < anunciantes.length; i++) {
            if (anunciantes[i] != null) {
                alugaveis = alugaveis + anunciantes[i].getQuantidadeAlugaveis();
            }
        }
        System.out.println("Quantidade de artigos disponíveis para aluguer na Plataforma Olxyz = " + alugaveis + "\n");


      
        System.out.println("Alínea b.6");
        for (int i = 0; i < anunciantes.length; i++) {
            if (anunciantes[i] != null) {
                double vendasTotaisAnunciante = anunciantes[i].getTotalVendasPossiveis();
                System.out.printf("Nome: %s%n%s%nSomatorio vendas possiveis: %.2f%n",
                        anunciantes[i].getNome(), anunciantes[i].getEndereco(), anunciantes[i].getTotalVendasPossiveis());
                System.out.println("______________________________________________________________________________________________________");
            }
        }


      
        System.out.println("");
        System.out.println("Alínea b.7");
        System.out.printf("Tabela artigos mais lucrativos por anunciante%n");
        System.out.printf("______________________________________________________________________________________________________%n");
        for (int i = 0; i < anunciantes.length; i++) {
            if (anunciantes[i] != null) {
                String nome = anunciantes[i].getNome();
                Alugavel alugavelMaisCaro = anunciantes[i].getAlugavelMaisCaro();
                if (alugavelMaisCaro == null) {
                    continue;
                } else {
                    String artigo = alugavelMaisCaro.toString();
                    double valorLucro = alugavelMaisCaro.calcularValorAluguer() - alugavelMaisCaro.getValorAluguer();
                    System.out.printf("Anunciante: %s%nArtigo: %s%nValor Lucro Olxyz: %.2f euros%n", nome, artigo, valorLucro);
                    System.out.println("____________________________");
                }             
            }
   
        }
    }
}