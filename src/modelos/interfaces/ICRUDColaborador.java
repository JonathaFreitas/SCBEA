/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.interfaces;
import java.util.ArrayList;
import modelos.classes.Colaborador;

/**
 *
 * @author jsfr
 */
public interface ICRUDColaborador {
    void incluir(Colaborador objeto)throws Exception;
   public ArrayList<Colaborador> recuperar() throws Exception;
   void editar(Colaborador objeto) throws Exception;
   void excluir(long cpf) throws Exception;
}
