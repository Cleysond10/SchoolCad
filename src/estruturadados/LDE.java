/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estruturadados;

/**
 *
 * @author Neto
 */
public class LDE <T extends Comparable<T>> {
    private NodeLDE<T> first;
    private NodeLDE<T> last;
    private int qtd;
    
    public boolean vazio() {
        if (qtd == 0) {
            return true;
        } else {
            return false;
        }
    }
	
    public NodeLDE<T> busca(T info) {
        NodeLDE<T> aux = this.first;

        if (vazio()) {
            return null;
        } else {
            do {
                if (aux.getInfo().compareTo(info) == 0) {
                    return aux;
                } else if (aux.getInfo().compareTo(info) > 0) {
                    return null;
                } else {
                    aux = aux.getNext();
                }
            } while (aux != this.first);
        }

        return null;
    }
    
    public void add(T info) {
        NodeLDE<T> novo = new NodeLDE<T>(info);
		
        if(vazio()) {
            this.first = novo;
            this.last = novo;
            this.qtd++;
            this.first.setPrev(this.last);
            this.last.setNext(this.first);
        }
        else {
            if(novo.getInfo().compareTo(this.first.getInfo()) == 0) {
                    System.out.println("É REPETIDO");
            }
            else if(novo.getInfo().compareTo(this.first.getInfo()) < 0) {
                    novo.setNext(this.first);
                    this.first.setPrev(novo);
                    this.first = novo;
                    this.qtd++;
                    this.first.setPrev(this.last);
                    this.last.setNext(this.first);
            }
            else if(novo.getInfo().compareTo(this.last.getInfo()) == 0) {
                    System.out.println("É REPETIDO");
            }
            else if(novo.getInfo().compareTo(this.last.getInfo()) > 0) {
                    novo.setPrev(this.last);
                    this.last.setNext(novo);
                    this.last = novo;
                    this.qtd++;
                    this.first.setPrev(this.last);
                    this.last.setNext(this.first);
            }
            else {
                NodeLDE<T> aux = this.first.getNext();

                do {
                    if(aux.getInfo().compareTo(novo.getInfo()) == 0) {
                            System.out.println("É REPETIDO");						
                    }
                    else if(aux.getInfo().compareTo(novo.getInfo()) > 0) {
                            novo.setNext(aux);
                            novo.setPrev(aux.getPrev());
                            novo.getPrev().setNext(novo);
                            aux.setPrev(novo);
                            this.qtd++;
                    }
                    else {
                            aux = aux.getNext();
                    }
                }while(aux != this.first);
            }

        }
		
    }
    
}
