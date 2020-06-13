/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.util.ArrayList;
import modelos.classes.Autor;
import modelos.interfaces.ICRUDAutor;
import persistencia.AutorPersistencia;

/**
 *
 * @author jsfr
 */
public class AutorControle implements ICRUDAutor {

    private ICRUDAutor objeto = null;

    public AutorControle() {
        objeto = new AutorPersistencia("Autores.txt");
    }

    @Override
    public void incluir(Autor objeto) throws Exception {
        System.out.println("Estou na controle verificando e "
                + "mandando incluir os dados");
        //valida nome;
        if (objeto.getNome().isEmpty()) {
            throw new Exception("Nome inválido! Tente novamente");
        }
        //verifica se editora já existe;
        ArrayList<Autor> listaDeEditoras = this.objeto.recuperar();
        for (int pos = 0; pos < listaDeEditoras.size(); pos++) {
            Autor aux = listaDeEditoras.get(pos);
            if (objeto.getNome().equalsIgnoreCase(aux.getNome())) {
                throw new Exception("Autor ja Existe: ID: " + aux.getId());
            }
        }
        this.objeto.incluir(objeto);
    }

    @Override
    public ArrayList<Autor> recuperar() throws Exception {
        return this.objeto.recuperar();
    }

    @Override
    public Autor recuperar(int id) throws Exception {
        return this.objeto.recuperar(id);
    }

    @Override
    public Autor recuperar(String nome) throws Exception {
        return this.objeto.recuperar(nome);
    }
}
