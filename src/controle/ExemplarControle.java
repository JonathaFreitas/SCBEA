/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.util.ArrayList;
import modelos.classes.Exemplar;
import modelos.interfaces.ICRUDExemplar;
import persistencia.ExemplarPersistencia;

/**
 *
 * @author jsfr
 */
public class ExemplarControle implements ICRUDExemplar{
    private ICRUDExemplar objeto = null;

    public ExemplarControle() {
        objeto = new ExemplarPersistencia("Exemplars.txt");

    }

    @Override
    public void incluir(Exemplar objeto) throws Exception {
        System.out.println("Estou na controle verificando e "
                + "mandando incluir os dados");
        //valida nome;
        //if(objeto.getClassificacaoDecimalDireito().isEmpty()) throw new Exception("Código inválido! Tente novamente");
        //if(objeto.getDescricao().isEmpty()) throw new Exception("Descrição inválida! Tente novamente");
        //verifica se editora já existe;
        ArrayList<Exemplar> listaDeExemplar = this.objeto.recuperar();
        for (int pos = 0; pos < listaDeExemplar.size(); pos++) {
            Exemplar aux = listaDeExemplar.get(pos);
            if (objeto.getId() == (aux.getId())) {
                throw new Exception("Exemplar ja Cadastrado, ID: " + aux.getId());
            }
        }
        this.objeto.incluir(objeto);
    }

    @Override
    public ArrayList<Exemplar> recuperar() throws Exception {
        return this.objeto.recuperar();
    }

    @Override
    public void editar(Exemplar objeto) throws Exception {
        System.out.println("Estou na controle verificando e "
                + "mandando incluir os dados");
        //valida nome;
        //if(objeto.getClassificacaoDecimalDireito().isEmpty()) throw new Exception("Código inválido! Tente novamente");
        //if(objeto.getDescricao().isEmpty()) throw new Exception("Descrição inválida! Tente novamente");
        //verifica se editora já existe;
        ArrayList<Exemplar> listaDeExemplar = this.objeto.recuperar();
        for (int pos = 0; pos < listaDeExemplar.size(); pos++) {
            Exemplar aux = listaDeExemplar.get(pos);
            if (objeto.getId()==(aux.getId()) && (objeto.getId() != (aux.getId()))) {
                throw new Exception("id: " + aux.getId() + " Não é permitido alterar id");
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
