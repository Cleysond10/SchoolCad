/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tidosdados;

/**
 *
 * @author Neto e Cleyson
 */
public class Aluno extends Usuario implements Comparable<Aluno>{
    
    public Aluno(String cpf) {
        super(cpf);
    }

    @Override
    public int compareTo(Aluno a) {
        return super.getCpf().compareTo(a.getCpf());
    }
    
}
