package tiposdados;

import java.io.Serializable;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

/**
 *
 * @author Neto e Cleyson
 */
public abstract class Usuario implements Serializable {
    private String cpf;
    private String rg;
    private String nome;
    private String dataN;
    private String Sexo;
    private String Telefone;
    private String email;
    private String endereço;
    
    private Turma[] turmas = new Turma[50];
    private int qtdVTurmas;
    
    public Usuario(String cpf) {
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataN() {
        return dataN;
    }

    public void setDataN(String dataN) {
        this.dataN = dataN;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String Telefone) {
        this.Telefone = Telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereço() {
        return endereço;
    }

    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }

    public Turma[] getTurmas() {
        return turmas;
    }

    public void setTurmas(Turma[] turmas) {
        this.turmas = turmas;
    }

    public int getQtdVTurmas() {
        return qtdVTurmas;
    }

    public void setQtdVTurmas(int qtdVTurmas) {
        this.qtdVTurmas = qtdVTurmas;
    }
    
    @Override
    public String toString() {
        return "Usuario{" + "cpf=" + cpf + ", nome=" + nome + ", email=" + email + ", rg=" + rg + '}';
    }
    
    
    
}
