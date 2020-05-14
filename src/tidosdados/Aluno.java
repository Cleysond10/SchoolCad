package tidosdados;



/**
 *
 * @author Neto e Cleyson
 */
public class Aluno extends Usuario implements Comparable<Aluno> {
    
    public Aluno(String cpf) {
        super(cpf);
    }
    
    @Override
    public int compareTo(Aluno a) {
        return super.getCpf().compareTo(a.getCpf());
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
            default:
                break;
        }
        return null;        
    }
    
}
