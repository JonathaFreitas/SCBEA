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
public class Autor {
    //Atributos
    private int id;
    private String nome;
    
    //Metodos

    public Autor(){
        
    }
    
    public Autor(int id,String nome){
        this.id=id;
        this.nome = nome;
    }
    
    public Autor(String strDados) throws Exception {
        String vetorString[] = strDados.split(";");
        if (vetorString.length < 2) {
            throw new Exception("Faltam dados na String");
        }
        this.id= Integer.parseInt(vetorString[0]);
        this.nome= vetorString[1];
    }
    
    public Autor(Autor objeto) {
        this.id=objeto.getId();
        this.nome=objeto.getNome();
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
    
    public String gravar(){
        return id+";"+nome;
    }
    @Override
     public String toString(){
        return nome;
    }
}
