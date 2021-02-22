package adt.queue;

import adt.stack.Stack;
import adt.stack.StackImpl;
import adt.stack.StackOverflowException;
import adt.stack.StackUnderflowException;

public class QueueUsingStack<T> implements Queue<T> {

    private Stack<T> stack1;
    private Stack<T> stack2;

    public QueueUsingStack(int size) {
        stack1 = new StackImpl<T>(size);
        stack2 = new StackImpl<T>(size);
    }

    @Override
    public void enqueue(T element) throws QueueOverflowException {
        try {
            if (element != null) {
                stack1.push(element);
            }
        } catch (StackOverflowException e) {
            throw new QueueOverflowException();
        }
    }

    @Override
    public T dequeue() throws QueueUnderflowException {
        T aux = null;
        try {
            do {
                aux = stack1.pop();
                this.stack2.push(aux);
            } while (!stack1.isEmpty());

            this.stack2.pop();

            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
        } catch (StackUnderflowException | StackOverflowException e) {
            throw new QueueUnderflowException();
        }
        return aux;
    }

    @Override
    public T head() {
        T aux = null;
        try {
            do {
                aux = stack1.pop();
                stack2.push(aux);
            } while (!stack1.isEmpty());

            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
        } catch (StackOverflowException | StackUnderflowException e) {

        }
        return aux;
    }

    @Override
    public boolean isEmpty() {
        return stack1.isEmpty();
    }

    @Override
    public boolean isFull() {
        return stack1.isFull();
    }

}
