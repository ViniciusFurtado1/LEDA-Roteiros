package adt.linkedList;

public class RecursiveDoubleLinkedListImpl<T> extends
        RecursiveSingleLinkedListImpl<T> implements DoubleLinkedList<T> {

    protected RecursiveDoubleLinkedListImpl<T> previous;

    public RecursiveDoubleLinkedListImpl() {

    }

    @Override
    public void insert(T element) {
        if (isEmpty()) {
            setData(element);
            setNext(new RecursiveDoubleLinkedListImpl<>());
            ((RecursiveDoubleLinkedListImpl<T>) getNext()).setPrevious(this);
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
                if (next == null) {
                    setNext(new RecursiveDoubleLinkedListImpl<>());
                }
            } else {
                getNext().remove(element);
            }
        }
    }

    @Override
    public void insertFirst(T element) {
        if (isEmpty()) {
            insert(element);
        } else {
            RecursiveDoubleLinkedListImpl<T> newNode = new RecursiveDoubleLinkedListImpl<>();
            newNode.setData(getData());
            newNode.setNext(getNext());
            setData(element);
            setPrevious(new RecursiveDoubleLinkedListImpl<>());
            setNext(newNode);
            ((RecursiveDoubleLinkedListImpl<T>) getNext()).setPrevious(this);
            ;
        }
    }

    @Override
    public void removeFirst() {
        if (!isEmpty()) {
            setData(getNext().getData());
            setNext(getNext().getNext());
            setPrevious(new RecursiveDoubleLinkedListImpl<>());
        }
    }

    @Override
    public void removeLast() {
        if (!isEmpty()) {
            if (getNext().isEmpty()) {
                setData(null);
                setNext(null);
            } else {
                ((RecursiveDoubleLinkedListImpl<T>) getNext()).removeLast();
            }
        }
    }

    public RecursiveDoubleLinkedListImpl<T> getPrevious() {
        return previous;
    }

    public void setPrevious(RecursiveDoubleLinkedListImpl<T> previous) {
        this.previous = previous;
    }

}
