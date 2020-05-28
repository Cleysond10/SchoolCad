package tiposdados;

/**
 *
 * @author Lenovo
 */
public class Turma extends Escola implements Comparable<Turma> {
    private String codTurma;
    private String horario;
    private Professor profx;
    private Integer QtdMaxAl;
    private int QtdAl;
    private String pLetivo;
    private Aluno[] Alunos;

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

    public Professor getProfx() {
        return profx;
    }

    public void setProfx(Professor profx) {
        this.profx = profx;
    }

    public Integer getQtdMaxAl() {
        return QtdMaxAl;
    }

    public void setQtdMaxAl(Integer QtdMaxAl) {
        this.QtdMaxAl = QtdMaxAl;
        Alunos = new Aluno[QtdMaxAl];
    }

    public int getQtdAl() {
        return QtdAl;
    }

    public void setQtdAl(int QtdAl) {
        this.QtdAl = QtdAl;
    }

    public String getpLetivo() {
        return pLetivo;
    }

    public void setpLetivo(String pLetivo) {
        this.pLetivo = pLetivo;
    }

    public Aluno[] getAlunos() {
        return Alunos;
    }

    public void setAlunos(Aluno[] Alunos) {
        this.Alunos = Alunos;
    }
            
    public int compareTo(Turma t) {
        return this.getCodTurma().compareTo(t.getCodTurma());        
    }

    @Override
    public String toString() {
        return  this.getCodTurma();
    }
    
}
