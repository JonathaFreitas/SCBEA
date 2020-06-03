/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.util.ArrayList;
import modelos.classes.AreaDeConhecimento;
import modelos.interfaces.ICRUDAreaDeConhecimento;
import persistencia.AreaDeConhecimentoPersistencia;

/**
 *
 * @author jsfr
 */
public class AreaDeConhecimentoControle implements ICRUDAreaDeConhecimento {
    private ICRUDAreaDeConhecimento objeto = null;
    
    public AreaDeConhecimentoControle(){
        objeto = new AreaDeConhecimentoPersistencia("DDD.txt");
        
    }
    
    @Override
    public void incluir(AreaDeConhecimento objeto)throws Exception {
        System.out.println("Estou na controle verificando e "
                + "mandando incluir os dados");
        //valida nome;
        if(objeto.getClassificacaoDecimalDireito().isEmpty()) throw new Exception("Código inválido! Tente novamente");
        if(objeto.getDescricao().isEmpty()) throw new Exception("Descrição inválida! Tente novamente");
        //verifica se editora já existe;
        ArrayList<AreaDeConhecimento> listaDeEditoras = this.objeto.recuperar();
        for (int pos = 0; pos < listaDeEditoras.size(); pos++) {
                AreaDeConhecimento aux = listaDeEditoras.get(pos);
                if (objeto.getClassificacaoDecimalDireito().equalsIgnoreCase(aux.getClassificacaoDecimalDireito())) throw new Exception ("AreaDeConhecimento ja Existe: ID: "+ aux.getId());
        }
        this.objeto.incluir(objeto);
    }
    
    public ArrayList<AreaDeConhecimento> recuperar() throws Exception{
        return this.objeto.recuperar();
    }
}

