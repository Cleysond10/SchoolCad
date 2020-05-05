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
public class Professor extends Usuario implements Comparable<Professor>{
    
    public Professor(String cpf) {
        super(cpf);
    }

    @Override
    public int compareTo(Professor p) {
        return super.getCpf().compareTo(p.getCpf());
    }
    
}
