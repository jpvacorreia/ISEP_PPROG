public class Apartamento implements Alugavel {
    
    // Endereço do apartamento
    private Endereco endereco;
    
    // Área do apartamento
    private double area;
    
    // Valor de aluguer 
    private double valorAluguer;

    // area por Omissão
    private final double AREA_OMISSAO = 0;

    // valorAluguer por omissão
    private final double ALUGUER_OMISSAO = 0.0;

    /**
     * construtor completo do Apartamento
     *
     * @param endereco
     * @param area
     * @param valorAluguer
     */
    public Apartamento(Endereco endereco, double area, double valorAluguer) {
        this.endereco = new Endereco(endereco);
        this.area = area;
        this.valorAluguer = valorAluguer;
    }

    /**
     * construtor vazio do Apartamento
     */
    public Apartamento() {
        endereco = new Endereco();
        area = AREA_OMISSAO;
        valorAluguer = ALUGUER_OMISSAO;
    }

    /**
     * construtor de outro Objeto de apartamento
     *
     * @param outroApartamento
     */
    public Apartamento(Apartamento outroApartamento) {
        endereco = new Endereco(outroApartamento.endereco);
        area = outroApartamento.getArea();
        valorAluguer = outroApartamento.getValorAluguer();
    }

    /**
     * @return o endereco do Apartamento
     */
    public Endereco getEndereco() {
        return new Endereco(endereco);
    }

    /**
     * @return a area do Apartamento
     */
    public double getArea() {
        return area;
    }

    /**
     * @return o valor do aluger do Apartamento
     */
    public double getValorAluguer() {
        return valorAluguer;
    }

    /**
     * permite a alteracao do endereco do apartamento
     *
     * @param endereco
     */
    public void setEndereco(Endereco endereco) {
        this.endereco = new Endereco(endereco);
    }

    /**
     * permite a alteracao da area do apartamento
     *
     * @param area
     */
    public void setArea(double area) {
        this.area = area;
    }

    /**
     * permite a alteracao do valorAluguer do apartamento
     *
     * @param valorAluguer
     */
    public void setValorAluguer(double valorAluguer) {
        this.valorAluguer = valorAluguer;
    }

    /**
     * @return o Apartamento com os seus atributos de forma legível.
     */
    public String toString() {
        return String.format("Apartamento \n%s \nArea: %.2f metros quadrados \nValor do aluguer: %.2f euros", endereco.toString(), area, valorAluguer);
    }

    /**
     * compara um objeto Apartamento com outroApartamento para verificar se são iguais ou diferentes
     *
     * @param outroObjeto
     * @return true ou false, consoante o objetos sao iguais ou nao, respetivamente.
     */

    @Override
    public boolean equals(Object outroObjeto) {
        if (this == outroObjeto) {
            return true;
        }
        if (outroObjeto == null || this.getClass() != outroObjeto.getClass()) {
            return false;
        }
        Apartamento outroApartamento = (Apartamento) outroObjeto;
        return this.endereco == (outroApartamento.endereco) && this.area == (outroApartamento.area)
                && this.valorAluguer == (outroApartamento.valorAluguer);
    }

    /**
     * Metodo compareTo para comparar dois Apartamentos quanto ao seu valor de aluguer.
     *
     * @return -1,0 ou 1 se o primeiro Apartamento tiver um valor de aluguer mais baixo, igual ou
     * superior ao valor do aluguer do Apartamento passado por parametro, respetivamente.
     */
    public int compareTo(Apartamento obj) {
        if (valorAluguer < obj.valorAluguer) {
            return -1;
        } else if (valorAluguer > obj.valorAluguer) {
            return 1;
        }
        return 0;
    }

    /**
     * @return valor de Aluguer
     */
    public double calcularValorAluguer() {
        return this.valorAluguer * taxaAluguer;
    }


}
