/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.classes;

/**
 *
 * @author eugeniojulio
 */
public class Editora {
    private int id;
    private String nome;
    //Metodos

    public Editora(){
        
    }
    
    public Editora(int id, String nome){
        this.id=id;
        this.nome=nome;
    }
    public Editora(String strDados) throws Exception {
        String vetorString[] = strDados.split(";");
        if (vetorString.length < 2) {
            throw new Exception("Faltam dados na String");
        }
        this.id= Integer.parseInt(vetorString[0]);
        this.nome= vetorString[1];
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
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    @Override
    public String toString(){
        return id+";"+nome;
    }
}
