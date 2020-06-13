/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.interfaces;
import java.util.ArrayList;
import modelos.classes.AreaDeConhecimento;

/**
 *
 * @author jsfr
 */
public interface ICRUDAreaDeConhecimento {
    //Descrever os metodos
   void incluir(AreaDeConhecimento objeto)throws Exception;
   public ArrayList<AreaDeConhecimento> recuperar() throws Exception;
   public AreaDeConhecimento recuperar(int id)throws Exception;
   public AreaDeConhecimento recuperar (String descricao) throws Exception;
}
