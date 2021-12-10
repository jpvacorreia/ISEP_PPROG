public interface Alugavel {

    
    /**
     * 
     * @return o valor de aluguer com a percentagem da plataforma
     */
    double calcularValorAluguer();
    
    
    /**
     * 
     * @return  o valor de aluguer indicado pelo anunciante
     */
    double getValorAluguer();

    /**
     * Valor da taxa de aluguer cobrada pela plataforma Olxyz
     */
    double taxaAluguer = 1.05;
}
