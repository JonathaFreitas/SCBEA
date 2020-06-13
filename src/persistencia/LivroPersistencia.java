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
import modelos.classes.Livro;
import modelos.interfaces.ICRUDLivro;

/**
 *
 * @author jsfr
 */
public class LivroPersistencia implements ICRUDLivro{
    private String nomeDoArquivoNoDisco="";
    
    public LivroPersistencia(String nomeArquivo) {
        this.nomeDoArquivoNoDisco = nomeArquivo;
    }
    
    @Override
    public void incluir(Livro objeto)throws Exception {
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
    public ArrayList<Livro> recuperar() throws Exception {
        try {
            ArrayList<Livro> listaDeLivro = new ArrayList<>();
            FileReader fr = new FileReader(nomeDoArquivoNoDisco);
            BufferedReader br = new BufferedReader(fr);
            String linha = "";
            while ((linha = br.readLine()) != null) {
                Livro objetoLivro = new Livro(linha);
                listaDeLivro.add(objetoLivro);
            }
            br.close();
            return listaDeLivro;
        } catch (Exception erro) {
            throw erro;
        }
    }
    
    @Override
    public void editar(Livro objeto) throws Exception {
        try {
            ArrayList<Livro> listaDeLivro = recuperar();
            //Cria o arquivo
            FileWriter fw = new FileWriter(nomeDoArquivoNoDisco);
            //Criar o buffer do arquivo
            BufferedWriter bw = new BufferedWriter(fw);
            for (int pos = 0; pos < listaDeLivro.size(); pos++) {
                Livro aux = listaDeLivro.get(pos);
                if (objeto.getId()==(aux.getId())) {
                    bw.write(objeto.toString() + "\n");
                }
                else{
                    bw.write(aux.toString() + "\n");
                }
            }
            bw.close();
        } catch (Exception erro) {
            throw erro;
        }
    }

    @Override
    public void excluir(int id) throws Exception {
        try {
            ArrayList<Livro> listaDeLivro = recuperar();
            //Cria o arquivo
            FileWriter fw = new FileWriter(nomeDoArquivoNoDisco);
            //Criar o buffer do arquivo
            BufferedWriter bw = new BufferedWriter(fw);
            for (int pos = 0; pos < listaDeLivro.size(); pos++) {
                Livro aux = listaDeLivro.get(pos);
                if (id!=(aux.getIsbn())) {
                    bw.write(aux.toString() + "\n");
                }
            }
            bw.close();
        } catch (Exception erro) {
            throw erro;
        }
    }
}
