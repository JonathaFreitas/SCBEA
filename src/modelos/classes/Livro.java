/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.classes;

import java.util.ArrayList;

/**
 *
 * @author jsfr
 */
public class Livro {
    //Atributos
    private int id=0;
    private int idEditora=0;
    private int idAutor=0;
    private int idAreaDeConhecimento=0;
    private String tituloDoLivro="";
    private int isbn=0;
    
    private ArrayList<Exemplar> Exemplar = new ArrayList<>();
    
    //Métodos
    
    //Contrutor Padrao
    public Livro() {
    }
    
    //Construtor com parametros
    public Livro(int id, int idEditora,int idAutor, int idAreaConhecimento,String titulo,int isbn) throws Exception {
        this.id=id;
        this.idEditora=idEditora;
        this.idAutor=idAutor;
        this.idAreaDeConhecimento=idAreaConhecimento;
        this.tituloDoLivro=titulo;
        this.isbn=isbn;
    }
    
    //Construtor para Método Recuperar
    public Livro(String strDados) throws Exception {
        String vetorString[] = strDados.split(";");
        if (vetorString.length < 6) {
            throw new Exception("Faltam dados na String");
        }
        this.id = Integer.parseInt(vetorString[0]);
        this.idEditora = Integer.parseInt(vetorString[1]);
        this.idAutor = Integer.parseInt(vetorString[2]);
        this.idAreaDeConhecimento = Integer.parseInt(vetorString[3]);
        this.tituloDoLivro = vetorString[4];
        this.isbn = Integer.parseInt(vetorString[5]);
    }
    
    // Getters e Setters
    
    
    @Override
    public String toString(){
        return getId()+";"+getIdEditora()+";"+getIdAutor()+";"+getIdAreaDeConhecimento()+";"+getTituloDoLivro()+";"+getIsbn();
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
     * @return the idEditora
     */
    public int getIdEditora() {
        return idEditora;
    }

    /**
     * @param idEditora the idEditora to set
     */
    public void setIdEditora(int idEditora) {
        this.idEditora = idEditora;
    }

    /**
     * @return the idAutor
     */
    public int getIdAutor() {
        return idAutor;
    }

    /**
     * @param idAutor the idAutor to set
     */
    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }

    /**
     * @return the idAreaDeConhecimento
     */
    public int getIdAreaDeConhecimento() {
        return idAreaDeConhecimento;
    }

    /**
     * @param idAreaDeConhecimento the idAreaDeConhecimento to set
     */
    public void setIdAreaDeConhecimento(int idAreaDeConhecimento) {
        this.idAreaDeConhecimento = idAreaDeConhecimento;
    }

    /**
     * @return the tituloDoLivro
     */
    public String getTituloDoLivro() {
        return tituloDoLivro;
    }

    /**
     * @param tituloDoLivro the tituloDoLivro to set
     */
    public void setTituloDoLivro(String tituloDoLivro) {
        this.tituloDoLivro = tituloDoLivro;
    }

    /**
     * @return the isbn
     */
    public int getIsbn() {
        return isbn;
    }

    /**
     * @param isbn the isbn to set
     */
    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    /**
     * @return the Exemplar
     */
    public ArrayList<Exemplar> getExemplar() {
        return Exemplar;
    }

    /**
     * @param Exemplar the Exemplar to set
     */
    public void setExemplar(ArrayList<Exemplar> Exemplar) {
        this.Exemplar = Exemplar;
    }
    
}
