package tiposdados;

/**
 *
 * @author Lenovo
 */
public class Turma extends Escola implements Comparable<Turma> {
    private String codTurma;
    private String horario;
    private String profx;
    private String QtdMaxAl;
    private String QtdAl;
    private String pLetivo;
    private String Alunos;

    public Turma(String codTurma, String codDisc) {
        super(codDisc);
        this.codTurma = codTurma;
    }
    
    public String getCodTurma() {
        return codTurma;
    }

    public void setCodTurma(String codTurma) {
        this.codTurma = codTurma;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getProfx() {
        return profx;
    }

    public void setProfx(String profx) {
        this.profx = profx;
    }

    public String getQtdMaxAl() {
        return QtdMaxAl;
    }

    public void setQtdMaxAl(String QtdMaxAl) {
        this.QtdMaxAl = QtdMaxAl;
    }

    public String getQtdAl() {
        return QtdAl;
    }

    public void setQtdAl(String QtdAl) {
        this.QtdAl = QtdAl;
    }

    public String getpLetivo() {
        return pLetivo;
    }

    public void setpLetivo(String pLetivo) {
        this.pLetivo = pLetivo;
    }

    public String getAlunos() {
        return Alunos;
    }

    public void setAlunos(String Alunos) {
        this.Alunos = Alunos;
    }
            
    public int compareTo(Turma t) {
        return this.getCodTurma().compareTo(t.getCodTurma());        
    }

    @Override
    public String toString() {
        return "Turma{" + "Codigo da Turma = " + this.getCodTurma() + "Codigo da Disciplina=" + super.getCodDisc() + '}';
    }
    
}
