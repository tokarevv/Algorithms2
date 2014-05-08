package StackGenerics;

import com.sun.org.apache.xalan.internal.xsltc.dom.ArrayNodeListIterator;

import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: Graf
 * Date: 02.02.14
 * Time: 15:47
 * To change this template use File | Settings | File Templates.
 */
public class ArrayStack<T> implements Stack<T> {

    private int size;
    private T[] arr;
    private final int INIT_SIZE = 8;

    public   ArrayStack(){
        arr = (T[]) new Object[INIT_SIZE];
    }

    @Override
    public void push(T i) {
        ensureCapacityForPush();
        arr[size++] = i;
    }

    private void ensureCapacityForPush() {
        if (arr.length == size){
            T[] newArray = (T[]) new Object[arr.length*2];
            for (int i = 0; i<arr.length; i++){
                newArray[i] = arr[i];
            }
            arr = newArray;
        }

    }

    @Override
    public T pop() {
        ensureCapacityForPop();
        return arr[--size];  //To change body of implemented methods use File | Settings | File Templates.
    }

    private void ensureCapacityForPop() {
        if (arr.length == size*4){
            T[] newArray = (T[]) new Object[size*2];
            for (int i = 0; i<size; i++){
                newArray[i] = arr[i];
            }
            arr = newArray;
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayIterator();  //To change body of implemented methods use File | Settings | File Templates.
    }

    private class ArrayIterator implements Iterator<T> {
        @Override
        public boolean hasNext() {
            return false;  //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public T next() {
            return null;  //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public void remove() {
            //To change body of implemented methods use File | Settings | File Templates.
        }
    }
}
