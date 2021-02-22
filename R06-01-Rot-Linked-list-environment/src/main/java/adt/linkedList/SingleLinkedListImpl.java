package adt.linkedList;

import java.util.ArrayList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

    protected SingleLinkedListNode<T> head;

    public SingleLinkedListImpl() {
        this.head = new SingleLinkedListNode<T>();
    }

    @Override
    public boolean isEmpty() {
        return head.isNIL();
    }

    @Override
    public int size() {
        SingleLinkedListNode<T> atual = head;
        int size = 0;
        while (!atual.isNIL()) {
            size++;
            atual = atual.getNext();
        }
        return size;
    }

    @Override
    public T search(T element) {
        SingleLinkedListNode<T> atual = head;
        T aux = null;
        while (!atual.isNIL() && aux == null) {
            if (atual.getData().equals(element)) {
                aux = atual.getData();
            }
            atual = atual.getNext();
        }
        return aux;
    }

    @Override
    public void insert(T element) {
        SingleLinkedListNode<T> atual = head;
        while (!atual.isNIL()) {
            atual = atual.getNext();
        }
        atual.setData(element);
        atual.setNext(new SingleLinkedListNode<T>(null, new SingleLinkedListNode<T>()));
    }

    @Override
    public void remove(T element) {
        SingleLinkedListNode<T> prev = null;
        SingleLinkedListNode<T> atual = head;
        boolean bool = true;
        while (!atual.isNIL() && bool) {
            if (atual.getData().equals(element)) {
                if (prev != null) {
                    prev.setNext(atual.getNext());
                } else {
                    setHead(atual.getNext());
                }
                bool = false;
            } else {
                prev = atual;
                atual = atual.getNext();
            }
        }
    }

    @Override
    public T[] toArray() {
        ArrayList<T> list = new ArrayList<>();
        SingleLinkedListNode<T> atual = head;
        while (!atual.isNIL()) {
            list.add(atual.getData());
            atual = atual.getNext();
        }
        return (T[]) list.toArray();
    }

    public SingleLinkedListNode<T> getHead() {
        return head;
    }

    public void setHead(SingleLinkedListNode<T> head) {
        this.head = head;
    }

}
