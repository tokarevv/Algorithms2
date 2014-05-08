package StackGenerics;

import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: Graf
 * Date: 02.02.14
 * Time: 15:30
 * To change this template use File | Settings | File Templates.
 */
public class LLStack<T> implements Stack<T> {

    private Node<T> first;

    @Override
    public void push(T i) {
        Node newFirst = new Node(i, null) ;
        newFirst.next = first;
        first = newFirst;
    }

    @Override
    public T pop() {
        T res = first.value;
        first = first.next;
        return res;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isEmpty() {
        return first == null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Iterator<T> iterator() {
        return new LLIterator();  //To change body of implemented methods use File | Settings | File Templates.
    }

    private class Node<T>{

        private T value;
        private Node<T> next;

        public Node(T value, Node<T> next){
            this.value = value;
            this.next = next;
        }

    }

    private class LLIterator implements Iterator<T> {

        private Node<T> current = first;

        @Override
        public boolean hasNext() {
            return current != null;  //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public T next() {
            T res = current.value;
            current = current.next;
            return res;  //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
            //To change body of implemented methods use File | Settings | File Templates.
        }
    }
}
