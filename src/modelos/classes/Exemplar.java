/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.classes;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import modelos.classes.enumerations.MotivoDeDesativacao;
import modelos.classes.enumerations.TipoDeStatus;

/**
 *
 * @author jsfr
 */
public class Exemplar extends Livro{
    //Tratamento de datas
    private SimpleDateFormat SimpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
    
    //Atributos
    private int idExemplar=0;
    private int numeroDoExemplar=0;
    private int anoPublicacao=0;
    private float valorCompra=0;
    private Date dataCompra= null;
    private int edicao=0;
    private TipoDeStatus status=null;
    private MotivoDeDesativacao motivoDesativacao=null;
    
    private ArrayList<Reserva> reservas = new ArrayList<Reserva>();
    private ArrayList<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
    
    //Métodos
    
    public Exemplar() {
        
    }

    public Exemplar(int id, int idEditora, int idAutor, int idAreaConhecimento, String titulo, int isbn) throws Exception {
        super(id, idEditora, idAutor, idAreaConhecimento, titulo, isbn);
        
    }
    
    
    
    //Construtor para Método Recuperar
    public Exemplar(String strDados) throws Exception {
        String vetorString[] = strDados.split(";");
        if (vetorString.length < 9) {
            throw new Exception("Faltam dados na String");
        }
        this.idExemplar= Integer.parseInt(vetorString[0]);
        this.numeroDoExemplar = Integer.parseInt(vetorString[2]);
        this.anoPublicacao = Integer.parseInt(vetorString[3]);
        this.valorCompra = Float.parseFloat(vetorString[4]);
        this.dataCompra = SimpleDateFormat.parse(vetorString[5]);
        this.edicao = Integer.parseInt(vetorString[6]);
        this.status = TipoDeStatus.valueOf(vetorString[7]);
        this.motivoDesativacao = MotivoDeDesativacao.valueOf(vetorString[8]);
    }

    /**
     * @return the id
     */
    public int getIdExemplar() {
        return idExemplar;
    }

    /**
     * @param id the id to set
     */
    public void setIdExemplar(int id) {
        this.idExemplar = id;
    }

    /**
     * @return the numeroDoExemplar
     */
    public int getNumeroDoExemplar() {
        return numeroDoExemplar;
    }

    /**
     * @param numeroDoExemplar the numeroDoExemplar to set
     */
    public void setNumeroDoExemplar(int numeroDoExemplar) {
        this.numeroDoExemplar = numeroDoExemplar;
    }

    /**
     * @return the anoPublicacao
     */
    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    /**
     * @param anoPublicacao the anoPublicacao to set
     */
    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    /**
     * @return the valorCompra
     */
    public float getValorCompra() {
        return valorCompra;
    }

    /**
     * @param valorCompra the valorCompra to set
     */
    public void setValorCompra(float valorCompra) {
        this.valorCompra = valorCompra;
    }

    /**
     * @return the dataCompra
     */
    public Date getDataCompra() {
        return dataCompra;
    }

    /**
     * @param dataCompra the dataCompra to set
     */
    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }

    /**
     * @return the edicao
     */
    public int getEdicao() {
        return edicao;
    }

    /**
     * @param edicao the edicao to set
     */
    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }

    /**
     * @return the status
     */
    public TipoDeStatus getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(TipoDeStatus status) {
        this.status = status;
    }

    /**
     * @return the motivoDesativacao
     */
    public MotivoDeDesativacao getMotivoDesativacao() {
        return motivoDesativacao;
    }

    /**
     * @param motivoDesativacao the motivoDesativacao to set
     */
    public void setMotivoDesativacao(MotivoDeDesativacao motivoDesativacao) {
        this.motivoDesativacao = motivoDesativacao;
    }

    /**
     * @return the reservas
     */
    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

    /**
     * @param reservas the reservas to set
     */
    public void setReservas(ArrayList<Reserva> reservas) {
        this.reservas = reservas;
    }

    /**
     * @return the emprestimos
     */
    public ArrayList<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    /**
     * @param emprestimos the emprestimos to set
     */
    public void setEmprestimos(ArrayList<Emprestimo> emprestimos) {
        this.emprestimos = emprestimos;
    }
    
    @Override
    public String toString(){
        return idExemplar+";"+numeroDoExemplar+";"+anoPublicacao+";"+valorCompra+";"+dataCompra+";"+edicao+";"+status+";"+motivoDesativacao;
    }
}
