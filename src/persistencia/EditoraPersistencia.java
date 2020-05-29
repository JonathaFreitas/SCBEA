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
import modelos.classes.Editora;
import modelos.interfaces.ICRUDEditora;
/**
 *
 * @author eugeniojulio
 */
public class EditoraPersistencia implements ICRUDEditora{
    private String nomeDoArquivoNoDisco;
    
    public EditoraPersistencia(String nomeArquivo){
        this.nomeDoArquivoNoDisco = nomeArquivo;
    }

    @Override
    public void incluir(Editora objeto)throws Exception {
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
    public ArrayList<Editora> recuperar() throws Exception {
        try {
            ArrayList<Editora> listaDeEditora = new ArrayList<Editora>();
            FileReader fr = new FileReader(nomeDoArquivoNoDisco);
            BufferedReader br = new BufferedReader(fr);
            String linha = "";
            while ((linha = br.readLine()) != null) {
                Editora objetoEditora = new Editora(linha);
                listaDeEditora.add(objetoEditora);
            }
            br.close();
            return listaDeEditora;
        } catch (Exception erro) {
            throw erro;
        }
    }
    
}
