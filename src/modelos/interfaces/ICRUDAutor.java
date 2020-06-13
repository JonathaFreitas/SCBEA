/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.interfaces;
import java.util.ArrayList;
import modelos.classes.Autor;


/**
 *
 * @author jsfr
 */
public interface ICRUDAutor {
    //Descrever os metodos
   void incluir(Autor objeto)throws Exception;
   public ArrayList<Autor> recuperar() throws Exception;
   public Autor recuperar(int id)throws Exception;
   public Autor recuperar (String nome) throws Exception;
}
