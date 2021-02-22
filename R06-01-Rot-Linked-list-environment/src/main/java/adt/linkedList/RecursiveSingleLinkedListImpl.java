package adt.linkedList;

import java.util.ArrayList;

public class RecursiveSingleLinkedListImpl<T> implements LinkedList<T> {

    protected T data;
    protected RecursiveSingleLinkedListImpl<T> next;

    public RecursiveSingleLinkedListImpl() {

    }

    @Override
    public boolean isEmpty() {
        return data == null;
    }

    @Override
    public int size() {
        int aux;
        if (isEmpty()) {
            aux = 0;
        } else {
            aux = 1 + getNext().size();
        }
        return aux;
    }

    @Override
    public T search(T element) {
        if (isEmpty() || getData().equals(element)) {
            return getData();
        } else {
            return getNext().search(element);
        }
    }

    @Override
    public void insert(T element) {
        if (isEmpty()) {
            setData(element);
            setNext(new RecursiveSingleLinkedListImpl<>());
        } else {
            getNext().insert(element);
        }
    }

    @Override
    public void remove(T element) {
        if (!isEmpty()) {
            if (getData().equals(element)) {
                setData(getNext().getData());
                setNext(getNext().getNext());
                if (getNext() == null) {
                    setNext(new RecursiveSingleLinkedListImpl<>());
                }
            } else {
                getNext().remove(element);
            }
        }
    }

    @Override
    public T[] toArray() {
        ArrayList<T> list = new ArrayList<>();
        auxToArray(list);
        return (T[]) list.toArray();
    }

    public void auxToArray(ArrayList<T> list) {
        if (!isEmpty()) {
            list.add(getData());
            getNext().auxToArray(list);
        }
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public RecursiveSingleLinkedListImpl<T> getNext() {
        return next;
    }

    public void setNext(RecursiveSingleLinkedListImpl<T> next) {
        this.next = next;
    }

}
