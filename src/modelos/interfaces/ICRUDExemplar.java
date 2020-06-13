/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.interfaces;

import java.util.ArrayList;
import modelos.classes.Exemplar;

/**
 *
 * @author jsfr
 */
public interface ICRUDExemplar {
    void incluir(Exemplar objeto)throws Exception;
    public ArrayList<Exemplar> recuperar() throws Exception;
    void editar(Exemplar objeto) throws Exception;
    void excluir(int id) throws Exception;
    }
