package StackGenerics;

/**
 * Created with IntelliJ IDEA.
 * User: Graf
 * Date: 02.02.14
 * Time: 15:27
 * To change this template use File | Settings | File Templates.
 */
public interface Stack<T> extends Iterable<T> {

    void push(T i);

    T pop();

    //int size();

    boolean isEmpty();

}
