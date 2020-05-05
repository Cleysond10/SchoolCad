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
class NodeLDE<T> {
    private T info;
    private NodeLDE next;
    private NodeLDE prev;

    public NodeLDE(T info) {
        this.info = info;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public NodeLDE getNext() {
        return next;
    }

    public void setNext(NodeLDE next) {
        this.next = next;
    }

    public NodeLDE getPrev() {
        return prev;
    }

    public void setPrev(NodeLDE prev) {
        this.prev = prev;
    }
    
}
