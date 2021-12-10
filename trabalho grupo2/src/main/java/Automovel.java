public class Automovel implements Alugavel, Vendavel {


    /**
     * A marca do automovel.
     */
    private String marca;

    /**
     * O modelo do automovel.
     */
    private String modelo;

    /**
     * O valor de venda do automovel.
     */
    private double valorVenda;

    /**
     * O valor de aluguer do automovel.
     */
    private double valorAluguer;

    /**
     * A marca por defeito do automovel.
     */
    private final String marcaDefault = "sem marca";

    /**
     * O modelo por defeito do automovel.
     */
    private String modeloDefault = "sem modelo";

    /**
     * O valor de venda por defeito do automovel.
     */
    private double valorVendaDefault = 0;

    /**
     * O valor de aluguer por defeito do automovel.
     */
    private double valorAluguerDefault = 0;

    // Contructors

    /**
     * Inicializa a marca, modelo, valor de venda e de aluguer do automovel com os
     * parametros de entrada da marca, modelo, valorVenda, valorAluguer.
     *
     * @param marca        a marca do automovel.
     * @param modelo       o modelo do automovel.
     * @param valorVenda   o valor de venda do automovel.
     * @param valorAluguer o valor de aluguer do automovel.
     */
    public Automovel(String marca, String modelo, double valorVenda, double valorAluguer) {
        this.marca = marca;
        this.modelo = modelo;
        this.valorVenda = valorVenda;
        this.valorAluguer = valorAluguer;
    }
    // Afinal pode ser assim! "Um Automóvel é caracterizado pela marca, modelo, valor de
    // venda pretendido e valor de aluguer pretendido." Ou seja, pode ser alugavel ou
    // vendavel daí ter de ter os dois valores

    /**
     * Inicializa a marca e modelo com os parametros de entrada da marca e modelo e
     * inicializa por defeito o valor de venda e de aluguer do automovel.
     *
     * @param marca  a marca do automovel.
     * @param modelo o modelo do automovel.
     */
    public Automovel(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
        this.valorVenda = valorVendaDefault;
        this.valorAluguer = valorAluguerDefault;
    }

    /**
     * Construtor copia de outro objeto de Automovel.
     *
     * @param outroAutomovel
     */
    public Automovel(Automovel outroAutomovel) {
        this.marca = outroAutomovel.getMarca();
        this.modelo = outroAutomovel.getModelo();
        this.valorVenda = outroAutomovel.getValorVenda();
        this.valorAluguer = outroAutomovel.getValorAluguer();
    }

    /**
     * Inicializa por defeito a marca, modelo e valor de venda e de aluguer do automovel.
     */
    public Automovel() {
        this.marca = marcaDefault;
        this.modelo = modeloDefault;
        this.valorVenda = valorVendaDefault;
        this.valorAluguer = valorAluguerDefault;
    }

    /**
     * @return a marca do Automovel
     */
    public String getMarca() {
        return marca;
    }

    /**
     * @return o modelo do Automovel
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * @return o valor de venda do Automovel
     */
    public double getValorVenda() {
        return valorVenda;
    }

    /**
     * @return o valor de aluguer do Automovel
     */
    public double getValorAluguer() {
        return valorAluguer;
    }

    /**
     * Permite a alteracao da marca do Automovel
     *
     * @param marca a marca do Automovel
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Permite a alteracao do modelo do Automovel
     *
     * @param modelo o modelo do Automovel
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Permite a alteracao do valor de venda do Automovel
     *
     * @param valorVenda o valor de venda do Automovel
     */
    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }

    /**
     * Permite a alteracao do valor de aluguer do Automovel
     *
     * @param valorAluguer o valor de aluguer do Automovel
     */
    public void setValorAluguer(double valorAluguer) {
        this.valorAluguer = valorAluguer;
    }

    /**
     * @return o Automovel com os seus atributos de forma legível.
     */
    @Override
    public String toString() {
        return String.format("Automovel\nmarca: %s \nmodelo: %s \nvalorVenda: %.2f \nvalorAluger: %.2f ", marca, modelo, valorVenda, valorAluguer);
    }

    /**
     * compara um objeto Automovel com o objeto passado por parametro de entrada
     * para verificar se sao iguais ou diferentes.
     *
     * @param obj       o objeto a comparar
     * @return boolean  o resultado da comparacao
     */

    public boolean equals(Automovel obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null && this.getClass() != obj.getClass()) {
            return false;
        }
        Automovel outroAuto = (Automovel) obj;
        if (this.marca == outroAuto.marca && this.modelo == outroAuto.modelo &&
                this.valorVenda == outroAuto.valorVenda && this.valorAluguer == outroAuto.valorAluguer) {
            return true;
        }
        return false;
    }

    /**
     * Metodo compareTo para comparar dois Automoveis quanto ao seu valor de aluguer.
     *
     * @return -1,0 ou 1 se o primeiro Automovel tiver um valor de aluguer mais baixo, igual ou
     * superior ao valor do aluguer do Automovel passado por parametro, respetivamente.
     */
    public int compareTo(Automovel obj) {
        if (valorAluguer < obj.valorAluguer) {
            return -1;
        } else if (valorAluguer > obj.valorAluguer) {
            return 1;
        }
        return 0;
    }

    /**
     * 
     * @return o valor do aluguer apresentado ao comprador
     */
    public double calcularValorAluguer() {
        return this.valorAluguer * taxaAluguer;
    }
    
    /**
     * 
     * @return o valor da venda apresentado ao comprador
     */
    public double calcularValorVenda() {
        return this.valorVenda * taxaVenda;
    }
}
