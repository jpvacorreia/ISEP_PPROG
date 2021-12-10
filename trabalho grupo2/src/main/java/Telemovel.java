public class Telemovel implements Vendavel {
    
    //designacao do Telemovel
    private String designacao;
    
    //valor de venda do Telemovel
    private double valorVenda;
    
    // designacao por Omissão
    private final String designacaoDefault = "sem designacao";
    
    // valorVenda por Omissão
    private final double valorVendaDefault = 0;
    
    /**
     * construtor completo Telemovel
     * @param designacao
     * @param valorVenda 
     */
    public Telemovel(String designacao, double valorVenda){
        this.designacao = designacao;
        this.valorVenda = valorVenda;
    }
    
    /**
     * construtor vazio Telemovel
     */
    public Telemovel(){
        designacao = designacaoDefault;
        valorVenda = valorVendaDefault;
    }
    
    /**
     * construtor de outro Objeto telemovel 
     * @param outroTelemovel 
     */
    public Telemovel (Telemovel outroTelemovel){
        designacao = outroTelemovel.getDesignacao();
        valorVenda = outroTelemovel.getValorVenda();
    }
    
    /**
     * 
     * @return designacao do Telemovel
     */
    public String getDesignacao() {
        return designacao;
    }
    
    /**
     * 
     * @return valor da venda do telemovel
     */
    public double getValorVenda() {
        return valorVenda;
    }
    
    /**
     * permite alteração da designacao do Telemovel
     * @param designacao 
     */
    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }
    
    /**
     * permite alteração do valorVenda do Telemovel
     * @param valorVenda 
     */
    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }
    
    /**
     * 
     * @return o Telemovel com os seus atributos de forma legível.
     */
    public String toString(){
        return String.format("Telemóvel \nDesignacao: %s \nValor: &d euros", designacao , valorVenda);
    }
    
    /**
     * compara um objeto Telemovel com outroTelemovel para verificar se são iguais ou diferentes
     * @param outroObjeto
     * @return 
     */
     @Override
    public boolean equals(Object outroObjeto) {
        if (this == outroObjeto) {
            return true;
        }
        if (outroObjeto == null || this.getClass() != outroObjeto.getClass()) {
            return false;
        }
        Telemovel outroTelemovel = (Telemovel) outroObjeto;
        return this.designacao.equalsIgnoreCase(outroTelemovel.designacao)&& 
                this.valorVenda==(outroTelemovel.valorVenda);
    }
    
    /**
     * Metodo compareTo para comparar dois Telemoveis quanto ao seu valor de venda.
     * 
     * @param obj
     * @return -1,0 ou 1 se o primeiro Telemovel tiver um valor de venda mais baixo, igual ou
     * superior ao valor do venda do Telemovel passado por parametro, respetivamente.
     */
    public int compareTo(Telemovel obj) {
        if (valorVenda < obj.valorVenda) {
            return -1;
        } else if (valorVenda > obj.valorVenda) {
            return 1;
        }
        return 0;
    }

    /**
     * 
     * @return valor de Venda do Telemovel
     */
    public double calcularValorVenda() {
        return this.valorVenda * taxaVenda;
    }

}
