/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.interfaces;

import java.util.ArrayList;
import modelos.classes.Livro;

/**
 *
 * @author jsfr
 */
public interface ICRUDLivro {
    void incluir(Livro objeto)throws Exception;
    public ArrayList<Livro> recuperar() throws Exception;
    void editar(Livro objeto) throws Exception;
    void excluir(int id) throws Exception;
    }
