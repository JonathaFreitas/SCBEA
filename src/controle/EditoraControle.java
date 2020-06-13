/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;
import java.util.ArrayList;
import modelos.classes.Editora;
import modelos.interfaces.ICRUDEditora;
import persistencia.EditoraPersistencia;
/**
 *
 * @author eugeniojulio
 */
public class EditoraControle implements ICRUDEditora{
    private ICRUDEditora objeto = null;
    
    public EditoraControle(){
        objeto = new EditoraPersistencia("Editoras.txt");
    }
    
    @Override
    public void incluir(Editora objeto)throws Exception {
        System.out.println("Estou na controle verificando e "
                + "mandando incluir os dados");
        //valida nome;
        if(objeto.getNome().isEmpty()) throw new Exception("Nome inválido! Tente novamente");
        //verifica se editora já existe;
        ArrayList<Editora> listaDeEditoras = this.objeto.recuperar();
        for (int pos = 0; pos < listaDeEditoras.size(); pos++) {
                Editora aux = listaDeEditoras.get(pos);
                if (objeto.getNome().equalsIgnoreCase(aux.getNome())) throw new Exception ("Editora ja Existe: ID: "+ aux.getId());
        }
        this.objeto.incluir(objeto);
    }
        

    @Override
    public ArrayList<Editora> recuperar() throws Exception {
        return this.objeto.recuperar();
    }
    @Override
    public Editora recuperar(int id)throws Exception {
        return this.objeto.recuperar(id);
    }
    
    @Override
    public Editora recuperar(String nome)throws Exception {
        return this.objeto.recuperar(nome);
    }
}
