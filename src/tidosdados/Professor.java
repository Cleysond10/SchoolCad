package tidosdados;

/**
 *
 * @author Neto e Cleyson
 */
public class Professor extends Usuario implements Comparable<Professor>{
    
    private String FormAcad;
    
    public Professor(String cpf) {
        super(cpf);
    }

    public String getFormAcad() {
        return FormAcad;
    }

    public void setFormAcad(String FormAcad) {
        this.FormAcad = FormAcad;
    }
    
    @Override
    public int compareTo(Professor p) {
        return super.getCpf().compareTo(p.getCpf());
    }
    
    public String toString(int x) {        
        switch (x) {
            case 1:
                return super.getCpf();
            case 2:
                return super.getDataN();
            case 3:
                return super.getEmail();
            case 4:
                return super.getEndereço();
            case 5:
                return super.getNome();
            case 6:
                return super.getRg();
            case 7:
                return super.getSexo();
            case 8:
                return super.getTelefone();
            case 9:
                return this.getFormAcad();
            default:
                break;
        }
        return null;        
    }
    
}
