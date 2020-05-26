package tiposdados;

/**
 *
 * @author Neto e Cleyson
 */
public class Disciplina extends Escola implements Comparable<Disciplina> {
    private String nome;
    private String cargaH;
    private String credito;
    private String periodo;
    
    private Turma[] turmas = new Turma[100];

    public Disciplina(String codDisc) {
        super(codDisc);        
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargaH() {
        return cargaH;
    }

    public void setCargaH(String cargaH) {
        this.cargaH = cargaH;
    }

    public String getCredito() {
        return credito;
    }

    public void setCredito(String credito) {
        this.credito = credito;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public Turma[] getTurmas() {
        return turmas;
    }

    public void setTurmas(Turma[] turmas) {
        this.turmas = turmas;
    }

    @Override
    public int compareTo(Disciplina d) {
        return super.getCodDisc().compareTo(d.getCodDisc());        
    }

    @Override
    public String toString() {
        return super.getCodDisc() + " - " + getNome();
    }
    
    
}
