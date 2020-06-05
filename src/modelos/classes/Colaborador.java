/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.classes;
import java.util.ArrayList;
import java.util.List;
import modelos.classes.TipoDeColaboradores;
import modelos.classes.TipoDeStatus;
/**
 *
 * @author jsfr
 */
public class Colaborador {

    private int id = 0;
    private int matricula = 0;
    private String nome = "";
    private int numeroOAB = 0;
    private long cpf=0;
    private String email = "";
    private long telefone = 0;
    private TipoDeColaboradores tipo;
    private TipoDeStatus status;
    
    private List<Emprestimo>  emprestimos = new ArrayList<>();
    private List<Reserva> reservas = new ArrayList<>();

    public Colaborador() {

    }

    public Colaborador(int id, int matricula, String nome, int numeroOAB,long cpf, String email, long telefone, String tipo, String status) {
        this.id=id;
        this.matricula=matricula;
        this.nome=nome;
        this.numeroOAB=numeroOAB;
        this.cpf=cpf;
        this.email=email;
        this.telefone=telefone;
        this.tipo=TipoDeColaboradores.valueOf(tipo);
        this.status=TipoDeStatus.valueOf(status);
    }
    
    public Colaborador(String strDados) throws Exception {
        String vetorString[] = strDados.split(";");
        if (vetorString.length < 9) {
            throw new Exception("Faltam dados na String");
        }
        this.id = Integer.parseInt(vetorString[0]);
        this.matricula = Integer.parseInt(vetorString[1]);
        this.nome=vetorString[2];
        this.numeroOAB=Integer.parseInt(vetorString[3]);
        this.cpf=Long.parseLong(vetorString[4]);
        this.email = vetorString[5];
        this.telefone=Long.parseLong(vetorString[6]);
        this.tipo=TipoDeColaboradores.valueOf(vetorString[7]);
        this.status=TipoDeStatus.valueOf(vetorString[8]);
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the matricula
     */
    public int getMatricula() {
        return matricula;
    }

    /**
     * @param matricula the matricula to set
     */
    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the numeroOAB
     */
    public int getNumeroOAB() {
        return numeroOAB;
    }

    /**
     * @param numeroOAB the numeroOAB to set
     */
    public void setNumeroOAB(int numeroOAB) {
        this.numeroOAB = numeroOAB;
    }
    
    /**
     * @return the cpf
     */
    public long getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(long cpf) {
        this.cpf = cpf;
    }
    
    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the telefone
     */
    public long getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(long telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the tipo
     */
    public TipoDeColaboradores getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(TipoDeColaboradores tipo) {
        this.tipo = tipo;
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
    
    
    @Override
    public String toString(){
        return id+";"+matricula+";"+nome+";"+numeroOAB+";"+cpf+";"+email+";"+telefone+";"+tipo+";"+status;
    }
}
