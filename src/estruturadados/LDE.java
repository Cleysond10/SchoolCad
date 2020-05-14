package estruturadados;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import tidosdados.Aluno;


/**
 *
 * @author Neto e Cleyson
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
    
    public T consulta(T info) {
        NodeLDE<T> aux = this.first;

        if (vazio()) {
            return null;
        } else {
            do {
                if (aux.getInfo().compareTo(info) == 0) {
                    return aux.getInfo();
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
    
    public void remover(T info) {
        NodeLDE<T> aux = this.first.getNext();
		
        if(vazio()) {
            System.out.println("LISTA VAZIA");
        }		
        else if(qtd == 1) {
            if(busca(info) != null) {
                this.first = null;
                this.last = null;
                this.qtd--;
            }
            else {
                System.out.println("NÃO EXISTE O CONTATO");
            }
        }
        else {
            if(this.first.getInfo().compareTo(info)>0) {
                System.out.println("NÃO EXISTE O CONTATO");
            }
            else if(this.first.getInfo().compareTo(info) == 0) {
                this.first = this.first.getNext();
                this.qtd--;
                this.first.setPrev(this.last);
                this.last.setNext(this.first);
            }
            else if(this.last.getInfo().compareTo(info) < 0) {
                System.out.println("NÃO EXISTE O CONTATO");
            }
            else if(this.last.getInfo().compareTo(info) == 0) {
                this.last = this.last.getPrev();
                this.qtd--;
                this.first.setPrev(this.last);
                this.last.setNext(this.first);
            }
            else if(busca(info) != null){
                aux = busca(info);
                aux.getPrev().setNext(aux.getNext());
                aux.getNext().setPrev(aux.getPrev());
                this.qtd--;
            }
            else {
                System.out.println("NÃO EXISTE O CONTATO");
            }
        }
    }
    
    public void Inicializar(String nome) {
		
        FileInputStream fis;
        ObjectInputStream ois;
        try {
            fis = new FileInputStream (nome);
            ois = new ObjectInputStream(fis);
            try {
                do {                    
                    T dados = (T) ois.readObject();
                    add(dados);										
                }while(true);

            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (EOFException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            ois.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }		
				
    }
    
    public void Finalizar(String nome) {
        NodeLDE aux = this.first;
        try {
            FileOutputStream fos = new FileOutputStream(nome);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            do {
                oos.writeObject(aux.getInfo());
                oos.flush();					
                aux=aux.getNext();								
            }while(aux!=this.first);
            oos.close();

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }		
						
    }
    
    /*public int getQtd() {
        return this.qtd;
    }

    public NodeLDE<T> getFirst() {
        return first;
    }*/
    
    public Aluno[] listaAluno() {		
        Aluno[] x = new Aluno[this.qtd];		
        NodeLDE aux = this.first;
        for(int i = 0; i<this.qtd;i++) {
            x[i] = (Aluno) aux.getInfo();
            aux = aux.getNext();
        }
        return x;		
    }
    
    
    public void exibir() {
        NodeLDE<T> aux = this.first;
        if(vazio()) {
            System.out.println("VAZIO");
        }
        else {
            System.out.println(aux.getInfo());
            aux = aux.getNext();
            while(aux != this.first) {
                System.out.println(aux.getInfo());
                aux = aux.getNext();
            }
        }
        System.out.println(this.qtd);
    }
    
    
    
}
