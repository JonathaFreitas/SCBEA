/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import modelos.classes.AreaDeConhecimento;
import modelos.interfaces.ICRUDAreaDeConhecimento;

/**
 *
 * @author jsfr
 */
public class AreaDeConhecimentoPersistencia implements ICRUDAreaDeConhecimento{
    private String nomeDoArquivoNoDisco;
    
    public AreaDeConhecimentoPersistencia(String nomeArquivo) {
        this.nomeDoArquivoNoDisco = nomeArquivo;
    }

    @Override
    public void incluir(AreaDeConhecimento objeto)throws Exception {
        //Colocar os comandos para gravar no arquivo texto
        try {
            System.out.println("Estou Gravando no Arquivo" + nomeDoArquivoNoDisco);
            FileWriter fw = new FileWriter(nomeDoArquivoNoDisco, true);
            //Criar o buffer do arquivo
            BufferedWriter bw = new BufferedWriter(fw);
            //Escreve no arquivo
            bw.write(objeto.gravar() + "\n");
            //Fechar o arquivo
            bw.close();
        } catch (Exception erro) {
            throw erro;
        }
    }
    
    @Override
    public ArrayList<AreaDeConhecimento> recuperar() throws Exception {
        try {
            ArrayList<AreaDeConhecimento> listaDeAreaDeConhecimento = new ArrayList<>();
            FileReader fr = new FileReader(nomeDoArquivoNoDisco);
            BufferedReader br = new BufferedReader(fr);
            String linha = "";
            while ((linha = br.readLine()) != null) {
                AreaDeConhecimento objetoAreaDeConhecimento = new AreaDeConhecimento(linha);
                listaDeAreaDeConhecimento.add(objetoAreaDeConhecimento);
            }
            br.close();
            return listaDeAreaDeConhecimento;
        } catch (Exception erro) {
            throw erro;
        }
    }
    
    @Override
        public AreaDeConhecimento recuperar(int id)throws Exception {
        AreaDeConhecimento objetoAreaDeConhecimento = new AreaDeConhecimento();
        try {
            FileReader fr = new FileReader(nomeDoArquivoNoDisco);
            BufferedReader br = new BufferedReader(fr);
            String linha = "";
            while ((linha = br.readLine()) != null) {
                AreaDeConhecimento aux = new AreaDeConhecimento(linha);
                if (id==aux.getId()) objetoAreaDeConhecimento=aux;
            }
            br.close();
        } catch (Exception erro) {
            throw erro;
        }
        return objetoAreaDeConhecimento;
    }
        
    @Override
        public AreaDeConhecimento recuperar(String descricao)throws Exception {
        AreaDeConhecimento objetoAreaDeConhecimento = new AreaDeConhecimento();
        try {
            FileReader fr = new FileReader(nomeDoArquivoNoDisco);
            BufferedReader br = new BufferedReader(fr);
            String linha = "";
            while ((linha = br.readLine()) != null) {
                AreaDeConhecimento aux = new AreaDeConhecimento(linha);
                if (descricao.equals(aux.toString())) objetoAreaDeConhecimento=aux;
            }
            br.close();
        } catch (Exception erro) {
            throw erro;
        }
        return objetoAreaDeConhecimento;
    }
    }
