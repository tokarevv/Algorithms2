package blah.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: Graf
 * Date: 02.02.14
 * Time: 15:30
 * To change this template use File | Settings | File Templates.
 */
public class LLStack implements Stack {

    private Node first;


    @Override
    public void push(int i) {
        Node newFirst = new Node(i, null) ;
        newFirst.next = first;
        first = newFirst;
    }

    @Override
    public int pop() {
        int res = first.value;
        first = first.next;
        return res;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isEmpty() {
        return first == null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    private class Node{

        private int value;
        private Node next;

        public Node(int value, Node next){
            this.value = value;
            this.next = next;
        }

    }
}
