/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.interfaces;
import java.util.ArrayList;
import modelos.classes.Editora;
/**
 *
 * @author eugeniojulio
 */
public interface ICRUDEditora {
    //Descrever os metodos
   void incluir(Editora objeto)throws Exception;
   public ArrayList<Editora> recuperar() throws Exception;
    
}
