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
import modelos.classes.Colaborador;
import modelos.interfaces.ICRUDColaborador;

/**
 *
 * @author jsfr
 */
public class ColaboradorPersistencia implements ICRUDColaborador{
    private String nomeDoArquivoNoDisco;
    
    public ColaboradorPersistencia(String nomeArquivo) {
        this.nomeDoArquivoNoDisco = nomeArquivo;
    }

    @Override
    public void incluir(Colaborador objeto)throws Exception {
        //Colocar os comandos para gravar no arquivo texto
        try {
            System.out.println("Estou Gravando no Arquivo" + nomeDoArquivoNoDisco);
            FileWriter fw = new FileWriter(nomeDoArquivoNoDisco, true);
            //Criar o buffer do arquivo
            BufferedWriter bw = new BufferedWriter(fw);
            //Escreve no arquivo
            bw.write(objeto.toString() + "\n");
            //Fechar o arquivo
            bw.close();
        } catch (Exception erro) {
            throw erro;
        }
    }
    
    @Override
    public ArrayList<Colaborador> recuperar() throws Exception {
        try {
            ArrayList<Colaborador> listaDeColaborador = new ArrayList<>();
            FileReader fr = new FileReader(nomeDoArquivoNoDisco);
            BufferedReader br = new BufferedReader(fr);
            String linha = "";
            while ((linha = br.readLine()) != null) {
                Colaborador objetoColaborador = new Colaborador(linha);
                listaDeColaborador.add(objetoColaborador);
            }
            br.close();
            return listaDeColaborador;
        } catch (Exception erro) {
            throw erro;
        }
    }
}