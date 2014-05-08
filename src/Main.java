//import blah.Stack.ArrayStack;
//import blah.Stack.LLStack;
//import blah.Stack.Stack;

import StackGenerics.ArrayStack;
import StackGenerics.LLStack;
import StackGenerics.Stack;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created with IntelliJ IDEA.
 * User: Graf
 * Date: 02.02.14
 * Time: 15:40
 * To change this template use File | Settings | File Templates.
 */
public class Main {

    public static void main(String[] args) {
        //int[] arr = {7,1,2,4,3,5, -1, 23, 12, 87, -87};
        int[] arr = {8, 6,9, 3,2,4,1, 5,0,7,11};
        System.out.println(findMax(0, arr));
        System.out.println(findMin(0, arr));
        System.out.println("Merge sort:");
        printArray(sortMerge(arr, 0, arr.length - 1));


        int[] unsorted = {8, 6,9, 3,2,4,1, 5,0,7,11};
        int[] sorted = new Main().heapSort(unsorted);
        System.out.println("Heap sort:");
        printArray(sortMerge(unsorted, 0, unsorted.length - 1));




//        Map map = new TreeMap();
//        checkDijkstra("(1+2)*5-2");
//        StringBuffer
//        checkStack(new LLStack<Integer>());
//        checkStack(new ArrayStack<Integer>());


    }

    private static void printArray(int[] ints) {
        for (int i = 0; i < ints.length; i++){
            System.out.print(ints[i]+ " ");
        }
    }


    public int[] heapSort(int[] arr){

        buildHeap(arr);

        //actual sorting
        for (int i = 0; i < arr.length-1; i++){
            //swap
            swap(arr, 0, arr.length-i-1);
            fixHeap(arr, 0, arr.length-i-1-1);
        }

        return arr;
    }

    private void buildHeap(int[] arr){
        //from bottom up
        for (int i = (arr.length-1-1)/2; i >= 0; i--){
            fixHeap(arr, i, arr.length-1);
        }
    }

// {11, 8,9, 5,7,4,1, 3,0,6,2};

    private void fixHeap(int[] arr, int i, int maxIndex){

        if ((i*2+1) > maxIndex){
            return;
        }

        int maxChildIndex = i*2+1;
        if ((i*2+2) <= maxIndex){
            maxChildIndex = arr[i*2+1] > arr[i*2+2] ? i*2+1 : i*2+2;
        }

        if (arr[i] < arr[maxChildIndex]){
            swap(arr, i, maxChildIndex);
            fixHeap(arr, maxChildIndex, maxIndex);
        }
    }

    private void swap(int[] arr, int i, int j){
        int tmp = arr[j];
        arr[j] = arr[i];
        arr[i] = tmp;
    }
//--end HEAP

    private static int[] sortMerge(int[] arr, int begin, int end) {
        if (end - begin <= 0){
            int[] res = new int[1];
            res[0] = arr[end];
            return  res; //sorted
        }
        int[] sorted1 =  sortMerge(arr, begin, begin+(end-begin)/2);
        int[] sorted2 =  sortMerge(arr, begin+(end-begin)/2+1, end);
        return merge(sorted1, sorted2); //sorted
    }

    private static int[] merge(int[] arr1, int[] arr2){
        int i = 0; int j =0;
        int[] result = new int[arr1.length+arr2.length];
        while (i < arr1.length && j < arr2.length){
            if (arr1[i] < arr2[j]){
                result[i+j] = arr1[i];
                i++;
            } else {
                result[i+j] = arr2[j];
                j++;
            }
        }
        //copy the rest
        if (i == arr1.length){
            copyTheRest(result, arr2, i+j, j);
        }else{
            copyTheRest(result, arr1, i+j, i);
        }

        return result;
    }

    private static void copyTheRest(int[] res, int[] arr, int k, int j){
        for (; j < arr.length; j++){
            res[k++] = arr[j];
        }
    }

    private static int findMax(int i, int[] arr) {
        if (i == arr.length-1){
            return arr[i];
        }
        int nextMax = findMax(++i,arr);
        return arr[i-1] > nextMax ? arr[i-1] : nextMax;
    }

    private static int findMin(int i, int[] arr) {
        if (i == arr.length-1){
            return arr[i];
        }
        int nextMin = findMin(++i, arr);
        return arr[i-1] < nextMin ? arr[i-1] : nextMin;
    }

    private static void checkDijkstra(String s) {

        Stack<String> ops = new LLStack<String>();
        Stack<String> val = new LLStack<String>();

        StringBuilder currVal = new StringBuilder();
        for (char c : s.toCharArray()){
            if (c =='('){
                continue;
            }
            else if (c == ')') {
                addVal(currVal, val);
                currVal = new StringBuilder();
                performOperation(ops, val) ;
            }
            else if ((c >= '0') && (c <= '9') ) {
                currVal.append(c);
            }
            else if (c == '+' || c == '-' || c == '*' || c == '/') {
                addVal(currVal, val);
                currVal = new StringBuilder();
                ops.push(String.valueOf(c));
            }
            else if (c == 's') {

            }
            else if (c == 'a') {

            }
            else {

            }

        }
        addVal(currVal, val);
        currVal = new StringBuilder();
        while(!ops.isEmpty()){
            performOperation(ops, val);
        }
        System.out.println(val.pop());

    }

    private static void addVal(StringBuilder currVal, Stack<String> val) {
        if (currVal.length() == 0){
            return;
        }
        val.push(currVal.toString());
//        currVal.delete(0, currVal.length());

    }


    private static void performOperation(Stack<String> ops, Stack<String> val) {
        int a = Integer.parseInt(val.pop());
        int b = Integer.parseInt(val.pop());
        String op = ops.pop();
        int res = 0;
        if (op.equals("+")){
            res = a + b;
        }
        else if(op.equals("+")){
            res = a - b;

        }
        else if(op.equals("*")){
            res = a * b;

        }
        else if(op.equals("/")){
            res = a / b;

        }
        val.push(String.valueOf(res));
    }

    private static void checkStack(Stack<Integer> stack) {
        for (int i = 0; i < 10; i++){
            stack.push(i);
        }
//        while (!stack.isEmpty()){
//            System.out.println(stack.pop());
//        }
        for (Integer i : stack){
            System.out.println(i);
        }
    }

}
