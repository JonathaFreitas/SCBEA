/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.util.ArrayList;
import modelos.classes.Livro;
import modelos.interfaces.ICRUDLivro;
import persistencia.LivroPersistencia;

/**
 *
 * @author jsfr
 */
public class LivroControle implements ICRUDLivro{
    private ICRUDLivro objeto = null;

    public LivroControle() {
        objeto = new LivroPersistencia("Livros.txt");

    }

    @Override
    public void incluir(Livro objeto) throws Exception {
        System.out.println("Estou na controle verificando e "
                + "mandando incluir os dados");
        //valida nome;
        //if(objeto.getClassificacaoDecimalDireito().isEmpty()) throw new Exception("Código inválido! Tente novamente");
        //if(objeto.getDescricao().isEmpty()) throw new Exception("Descrição inválida! Tente novamente");
        //verifica se editora já existe;
        ArrayList<Livro> listaDeLivro = this.objeto.recuperar();
        for (int pos = 0; pos < listaDeLivro.size(); pos++) {
            Livro aux = listaDeLivro.get(pos);
            if (objeto.getIsbn() == (aux.getIsbn())) {
                throw new Exception("Livro ja Cadastrado, ID: " + aux.getId());
            }
        }
        this.objeto.incluir(objeto);
    }

    @Override
    public ArrayList<Livro> recuperar() throws Exception {
        return this.objeto.recuperar();
    }

    @Override
    public void editar(Livro objeto) throws Exception {
        System.out.println("Estou na controle verificando e "
                + "mandando incluir os dados");
        //valida nome;
        //if(objeto.getClassificacaoDecimalDireito().isEmpty()) throw new Exception("Código inválido! Tente novamente");
        //if(objeto.getDescricao().isEmpty()) throw new Exception("Descrição inválida! Tente novamente");
        //verifica se editora já existe;
        ArrayList<Livro> listaDeLivro = this.objeto.recuperar();
        for (int pos = 0; pos < listaDeLivro.size(); pos++) {
            Livro aux = listaDeLivro.get(pos);
            if (objeto.getIsbn()==(aux.getIsbn()) && (objeto.getId() != (aux.getId()))) {
                throw new Exception("id: " + aux.getId() + " Não é permitido alterar ISBN");
            } else {
                this.objeto.editar(objeto);
            }
        }
    }

    @Override
    public void excluir(int id) throws Exception {
        this.objeto.excluir(id);
    }
}
