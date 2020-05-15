/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiposdados;

import java.io.Serializable;

/**
 *
 * @author Neto
 */
public abstract class Escola implements Serializable {
    private String codDisc;

    public Escola(String codDisc) {
        this.codDisc = codDisc;
    }

    public String getCodDisc() {
        return codDisc;
    }

    public void setCodDisc(String codDisc) {
        this.codDisc = codDisc;
    }

    @Override
    public String toString() {
        return "Escola{" + "codDisc=" + codDisc + '}';
    }
    
}
