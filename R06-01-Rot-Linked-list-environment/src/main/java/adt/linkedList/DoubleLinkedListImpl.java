package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
        DoubleLinkedList<T> {

    protected DoubleLinkedListNode<T> last;

    public DoubleLinkedListImpl() {
        this.setHead(new DoubleLinkedListNode<>());
        this.setLast((DoubleLinkedListNode<T>) head);
    }

    @Override
    public void insert(T element) {
        DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode<T>(element, new DoubleLinkedListNode<T>(), new DoubleLinkedListNode<T>());
        if (head.isNIL()) {
            newNode.setNext(last);
            setHead(newNode);
            last.setNext(new SingleLinkedListNode<T>());
        } else {
            newNode.setPrevious(last);
            getLast().setNext(newNode);
        }
        setLast(newNode);
    }

    @Override
    public void remove(T element) {
        if (head.getData().equals(element)) {
            removeFirst();
        } else {
            DoubleLinkedListNode<T> atual = (DoubleLinkedListNode<T>) head;
            while (!atual.isNIL() && !atual.getData().equals(element)) {
                atual = (DoubleLinkedListNode<T>) atual.getNext();
            }
            if (!atual.isNIL()) {
                atual.getPrevious().setNext(atual.getNext());
                ((DoubleLinkedListNode<T>) atual.getNext()).setPrevious(atual.getPrevious());
            }
        }
    }

    @Override
    public void insertFirst(T element) {
        DoubleLinkedListNode<T> newHead = new DoubleLinkedListNode<T>(element, (DoubleLinkedListNode<T>) head, new DoubleLinkedListNode<T>());
        ((DoubleLinkedListNode<T>) head).setPrevious(newHead);
        if (isEmpty()) {
            setLast(newHead);
        }
        setHead(newHead);
    }

    @Override
    public void removeFirst() {
        if (!head.isNIL()) {
            head = head.getNext();
            if (head.isNIL()) {
                last = (DoubleLinkedListNode<T>) head;
            }
            ((DoubleLinkedListNode<T>) head).setPrevious(new DoubleLinkedListNode<>());
        }
    }

    @Override
    public void removeLast() {
        if (!isEmpty()) {
            last = last.getPrevious();
            if (last.isNIL()) {
                head = last;
            }
            last.setNext(new DoubleLinkedListNode<T>());
        }
    }

    public DoubleLinkedListNode<T> getLast() {
        return last;
    }

    public void setLast(DoubleLinkedListNode<T> last) {
        this.last = last;
    }

}
