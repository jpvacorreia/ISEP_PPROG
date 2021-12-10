public interface Vendavel {
    
    /**
     * 
     * @return o valor de venda com a percentagem da plataforma
     */
    double calcularValorVenda();

    /**
     *
     * @return  o valor de venda indicado pelo anunciante
     */
    double getValorVenda();

    /**
     * Valor da taxa de venda cobrada pela plataforma Olxyz
     */
    double taxaVenda = 1.03;
}
