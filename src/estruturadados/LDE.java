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
    
    public void Inicializar(String nome) {
		
        FileInputStream fis;
        ObjectInputStream ois;
        try {
            fis = new FileInputStream (nome + ".jv");
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
            FileOutputStream fos = new FileOutputStream(nome + ".jv");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            while(aux!=null) {
                oos.writeObject(aux.getInfo());
                oos.flush();					
                aux=aux.getNext();								
            }
            oos.close();

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }		
						
    }
    
    public int getQtd() {
        return this.qtd;
    }

    public NodeLDE<T> getFirst() {
        return first;
    }
    
    public Aluno[] listaAluno() {		
		Aluno[] x = new Aluno[this.qtd];		
		NodeLDE aux = this.first;
		for(int i = 0; i<this.qtd;i++) {
			x[i] = (Aluno) aux.getInfo();
			aux = aux.getNext();
		}
		return x;		
	}
    
    
    
}
