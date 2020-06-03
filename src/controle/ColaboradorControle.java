/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.util.ArrayList;
import modelos.classes.Colaborador;
import modelos.interfaces.ICRUDColaborador;
import persistencia.ColaboradorPersistencia;

/**
 *
 * @author jsfr
 */
public class ColaboradorControle implements ICRUDColaborador {

    private ICRUDColaborador objeto = null;

    public ColaboradorControle() {
        objeto = new ColaboradorPersistencia("Colaboradores.txt");

    }

    @Override
    public void incluir(Colaborador objeto) throws Exception {
        System.out.println("Estou na controle verificando e "
                + "mandando incluir os dados");
        //valida nome;
        //if(objeto.getClassificacaoDecimalDireito().isEmpty()) throw new Exception("Código inválido! Tente novamente");
        //if(objeto.getDescricao().isEmpty()) throw new Exception("Descrição inválida! Tente novamente");
        //verifica se editora já existe;
        ArrayList<Colaborador> listaDeColaborador = this.objeto.recuperar();
        for (int pos = 0; pos < listaDeColaborador.size(); pos++) {
            Colaborador aux = listaDeColaborador.get(pos);
            if (objeto.getNome().equalsIgnoreCase(aux.getNome())) {
                throw new Exception("Colaborador ja Existe: ID: " + aux.getId());
            }
        }
        this.objeto.incluir(objeto);
    }

    public ArrayList<Colaborador> recuperar() throws Exception {
        return this.objeto.recuperar();
    }
}
