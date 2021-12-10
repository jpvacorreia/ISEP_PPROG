import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Anunciante {

    /**
     * O nome do anunciante.
     */
    private String nome;

    /**
     * A morada do anunciante.
     */
    private Endereco endereco;

    /**
     * A lista de produtos vendaveis do anunciante.
     */
    private List<Vendavel> listaVendaveis;

    /**
     * A lista de produtos alugaveis do anunciante.
     */
    private List<Alugavel> listaAlugaveis;

    /**
     * O nome do anunciante por defeito.
     */
    private final String nomeDefault = "sem nome";

    /**
     * A morada do anunciante por defeito.
     */
    private final Endereco enderecoDefault = new Endereco();

    /**
     * Numero maximo de artigos na lista de vendaveis.
     */
    private final int LIMITELISTAVENDAVEIS = 2;

    /**
     * Numero maximo de artigos na lista de alugaveis.
     */
    private final int LIMITELISTALUGAVEIS = 3;

    /**
     * A lista por defeito de produtos vendaveis do anunciante.
     */
    private final List<Vendavel> listaVendaveisDefault = new ArrayList<Vendavel>();

    /**
     * A lista por defeito de produtos alugaveis do anunciante.
     */
    private final List<Alugavel> listaAlugaveisDefault = new ArrayList<Alugavel>();


    // Constructors

    /**
     * Inicializa o nome, morada, lista de produtos vendaveis e alugaveis do anunciante
     * com os parametros de entrada nome, endereco, listaVendaveis, listaAlugaveis.
     *
     * @param nome           o nome do anunciante.
     * @param endereco       a morada do anunciante.
     * @param listaVendaveis a lista de produtos vendaveis do anunciante.
     * @param listaAlugaveis a lista de produtos alugaveis do anunciante.
     */
    public Anunciante(String nome, Endereco endereco, List<Vendavel> listaVendaveis, List<Alugavel> listaAlugaveis) {
        this.nome = nome;
        this.endereco = new Endereco(endereco);
        this.listaVendaveis = new ArrayList<Vendavel>(listaVendaveis);
        this.listaAlugaveis = new ArrayList<Alugavel>(listaAlugaveis);
    }

    /**
     * Inicializa o nome e morada do anunciante com os parametros de entrada nome e endereco
     * e inicializa por defeito a lista de produtos vendaveis e alugaveis do anunciante.
     *
     * @param nome     o nome do anunciante.
     * @param endereco a morada do anunciante.
     */
    public Anunciante(String nome, Endereco endereco) {
        this.nome = nome;
        this.endereco = new Endereco(endereco);
        this.listaVendaveis = listaVendaveisDefault;
        this.listaAlugaveis = listaAlugaveisDefault;
    }

    /**
     * Inicializa o nome do anunciante com os parametros de entrada nome com o parametro de
     * entrada nome e inicializa por defeito a morada, a lista de produtos vendaveis e
     * alugaveis do anunciante.
     *
     * @param nome o nome do anunciante.
     */
    public Anunciante(String nome) {
        this.nome = nome;
        this.endereco = enderecoDefault;
        this.listaVendaveis = listaVendaveisDefault;
        this.listaAlugaveis = listaAlugaveisDefault;
    }

    /**
     * Construtor copia de outro Objeto de Anunciante
     *
     * @param outroAnunciante o objeto anunciante a copiar.
     */
    public Anunciante(Anunciante outroAnunciante) {
        nome = outroAnunciante.getNome();
        endereco = new Endereco(outroAnunciante.endereco);
        listaVendaveis = new ArrayList<Vendavel>(outroAnunciante.listaVendaveis);
        listaAlugaveis = new ArrayList<Alugavel>(outroAnunciante.listaAlugaveis);
    }

    /**
     * Inicializa o nome, morada, lista de produtos vendaveis e alugaveis do anunciante
     * com os atributos por defeito do anunciante.
     */
    public Anunciante() {
        this.nome = nomeDefault;
        this.endereco = enderecoDefault;
        this.listaVendaveis = listaVendaveisDefault;
        this.listaAlugaveis = listaAlugaveisDefault;
    }

    /**
     * @return o nome do Anunciante
     */
    public String getNome() {
        return nome;
    }

    /**
     * @return o endereco do Anunciante
     */
    public Endereco getEndereco() {
        return new Endereco(endereco);
    }

    /**
     * @return a lista de produtos vendaveis do Anunciante
     */
    public List<Vendavel> getListaVendaveis() {
        return new ArrayList<Vendavel>(listaVendaveis);
    }

    /**
     * @return a lista de produtos alugaveis do Anunciante
     */
    public List<Alugavel> getListaAlugaveis() {
        return new ArrayList<Alugavel>(listaAlugaveis);
    }

    /**
     * Permite a alteracao do nome do Anunciante
     *
     * @param nome o nome do Anunciante
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Permite a alteracao do endereco do Anunciante
     *
     * @param endereco o endereco do Anunciante
     */
    public void setEndereco(Endereco endereco) {
        this.endereco = new Endereco(endereco);
    }

    /**
     * Permite a alteracao da lista de vendaveis do Anunciante
     *
     * @param listaVendaveis a lista de vendaveis do Anunciante
     */
    public void setListaVendaveis(List<Vendavel> listaVendaveis) {
        this.listaVendaveis = new ArrayList<Vendavel>(listaVendaveis);
    }

    /**
     * Permite a alteracao da lista de alugaveis do Anunciante
     *
     * @param listaAlugaveis a lista de alugaveis do Anunciante
     */
    public void setListaAlugaveis(List<Alugavel> listaAlugaveis) {
        this.listaAlugaveis = new ArrayList<Alugavel>(listaAlugaveis);
    }

    /**
     * Permite a adicao de um artigo Vendavel na lista de vendaveis do Anunciante
     *
     * @param vendavel o novo artigo vendavel a adicionar
     */
    public boolean addVendavel(Vendavel vendavel) {
        if (listaVendaveis.size() < LIMITELISTAVENDAVEIS) {
            listaVendaveis.add(vendavel);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Permite a adicao de um artigo Alugavel na lista de alugaveis do Anunciante
     *
     * @param alugavel o novo artigo alugavel a adicionar
     */
    public boolean addAlugavel(Alugavel alugavel) {
        if (listaAlugaveis.size() < LIMITELISTALUGAVEIS) {
            listaAlugaveis.add(alugavel);
            return true;
        } else {
            return false;
        }
    }

    /**
     * @return o Anunciante com os seus atributos de forma legível.
     */
    @Override
    public String toString() {
        return "Anunciante{" +
                "nome='" + nome + '\'' +
                ", endereco=" + endereco +
                ", listaVendaveis=" + listaVendaveis +
                ", listaAlugaveis=" + listaAlugaveis +
                '}';
    }

    /**
     * @return String com os objetos alugaveis na lista do Anunciante.
     */
    public String alugaveisToString() {
        List<Alugavel> lista = new ArrayList<Alugavel>(listaAlugaveis);
        StringBuilder stringAlugaveis = new StringBuilder();

        for (Alugavel alug : lista) {
            stringAlugaveis.append(alug);
            stringAlugaveis.append("\n");
        }
        return stringAlugaveis.toString();
    }

    /**
     * @return quantidade de artigos alugaveis do Anunciante.
     */
    public int getQuantidadeAlugaveis() {
        return listaAlugaveis.size();
    }

    public Alugavel getAlugavelMaisCaro() {
        Alugavel alugavelCaro = null;
        double valorAlugavelMaisCaro = 0;
        for (Alugavel alug : listaAlugaveis) {
            if (alug.calcularValorAluguer() > valorAlugavelMaisCaro) ;
            valorAlugavelMaisCaro = alug.calcularValorAluguer();
            alugavelCaro = alug;
        }
        return alugavelCaro;
    }

    public double getTotalVendasPossiveis() {
        double valorVendas = 0;
        for (Vendavel vend : listaVendaveis) {
            if (vend.calcularValorVenda() > valorVendas) ;
            valorVendas += vend.calcularValorVenda();
        }
        return valorVendas;
    }

}
