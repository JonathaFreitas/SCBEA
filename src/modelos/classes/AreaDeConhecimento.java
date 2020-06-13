/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.classes;

/**
 *
 * @author jsfr
 */
public class AreaDeConhecimento {

    //Atributos
    private int id;
    private String classificacaoDecimalDireito;
    private String descricao;

    // Métodos
    public AreaDeConhecimento() {

    }

    public AreaDeConhecimento(int id, String classificacaoDecimalDireito, String descricao) {
        this.id = id;
        this.classificacaoDecimalDireito = classificacaoDecimalDireito;
        this.descricao = descricao;
    }

    public AreaDeConhecimento(String strDados) throws Exception {
        String vetorString[] = strDados.split(";");
        if (vetorString.length < 3) {
            throw new Exception("Faltam dados na String");
        }
        this.id = Integer.parseInt(vetorString[0]);
        this.classificacaoDecimalDireito = vetorString[1];
        this.descricao = vetorString[2];
    }

    public AreaDeConhecimento(AreaDeConhecimento objeto){
        this.id=objeto.getId();
        this.classificacaoDecimalDireito = objeto.getClassificacaoDecimalDireito();
        this.descricao=objeto.getDescricao();
    }
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the classificacaoDecimalDewey
     */
    public String getClassificacaoDecimalDireito() {
        return classificacaoDecimalDireito;
    }

    /**
     * @param classificacaoDecimalDireito the classificacaoDecimalDewey to set
     */
    public void setClassificacaoDecimalDireito(String classificacaoDecimalDireito) {
        this.classificacaoDecimalDireito = classificacaoDecimalDireito;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public String gravar(){
        return id + ";" + classificacaoDecimalDireito + ";" + descricao;
    }
    @Override
    public String toString() {
        return descricao;
    }
}
