public class Endereco {
    
    // nome da rua do Endereco
    private String nomeRua;
    
    //codigo postal do Endereco
    private String codPostal; 
    
    //localidade do Endereco
    private String localidade;

    // nomeRua por Omissão
    private final String NOME_RUA_OMISSAO = "sem nome rua";
    
    // codPostal por Omissão
    private final String COD_POSTAL_OMISSAO = "sem código postal";
    
    // localidade por omissao
    private final String LOC_OMISSAO = "sem localidade";
    
    /**
     * construtor completo do Endereco
     * @param nomeRua
     * @param codPostal
     * @param localidade 
     */
    public Endereco(String nomeRua, String codPostal, String localidade){
        this.nomeRua = nomeRua;
        this.codPostal = codPostal;
        this.localidade = localidade;
    }
    
    /**
     * construtor vazio do Endereco
     */
    public Endereco(){
        nomeRua = NOME_RUA_OMISSAO;
        codPostal = COD_POSTAL_OMISSAO;
        localidade = LOC_OMISSAO;
    }
    
    /**
     * contrutor de outro objeto
     * @param outroEndereco 
     */
     public Endereco (Endereco outroEndereco){
        nomeRua= outroEndereco.getNomeRua();
        codPostal= outroEndereco.getCodPostal();
        localidade = outroEndereco.getLocalidade();
    }
    
    /**
     * 
     * @return o nome da rua do Endereco
     */
    public String getNomeRua() {
        return nomeRua;
    }
    
    /**
     * 
     * @return o codigo postal do Endereco
     */
    public String getCodPostal() {
        return codPostal;
    }
    
    /**
     * 
     * @return a localidade do Endereco
     */
    public String getLocalidade() {
        return localidade;
    }
    
    /**
     * permite a alteração do nome da rua do Endereco
     * @param nomeRua 
     */
    public void setNomeRua(String nomeRua) {
        this.nomeRua = nomeRua;
    }
    
    /**
     * permite a alteração do codPostal do Endereco
     * @param codPostal 
     */
    public void setCodPostal(String codPostal) {
        this.codPostal = codPostal;
    }

    /**
     * permite a alteração da localidade do Endereco
     * @param localidade 
     */
    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }
    
    /**
     * 
     * @return o Endereço com os seus atributos de forma legível.
     */
    @Override
    public String toString(){
        return String.format("Endereço : | Nome rua: %s | Código Postal: %s | Localidade: %s |", nomeRua, codPostal, localidade);
    }
    
    /**
     * compara um objeto Endereco com outroEndereco para verificar se são iguais ou diferentes
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
        Endereco outroEndereco = (Endereco) outroObjeto;
        return this.nomeRua.equalsIgnoreCase(outroEndereco.nomeRua)&&this.codPostal.equalsIgnoreCase(outroEndereco.codPostal)
                && this.localidade.equalsIgnoreCase(outroEndereco.localidade);
    }
    
    
}
