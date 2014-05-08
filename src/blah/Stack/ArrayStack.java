package blah.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: Graf
 * Date: 02.02.14
 * Time: 15:47
 * To change this template use File | Settings | File Templates.
 */
public class ArrayStack implements Stack {

    private int size;
    private int[] arr;
    private final int INIT_SIZE = 8;

    public   ArrayStack(){
        arr = new int[INIT_SIZE];
    }


    @Override
    public void push(int i) {
        ensureCapacityForPush();
        arr[size++] = i;
    }

    private void ensureCapacityForPush() {
        if (arr.length == size){
            int[] newArray = new int[arr.length*2];
            for (int i = 0; i<arr.length; i++){
                newArray[i] = arr[i];
            }
            arr = newArray;
        }

    }

    @Override
    public int pop() {
        ensureCapacityForPop();
        return arr[--size];  //To change body of implemented methods use File | Settings | File Templates.
    }

    private void ensureCapacityForPop() {
        if (arr.length == size*4){
            int[] newArray = new int[size*2];
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
}
