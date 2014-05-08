/**
 * Created by IntelliJ IDEA.
 * User: vito
 * Date: 5/7/14
 * Time: 4:29 PM
 * To change this template use File | Settings | File Templates.
 */
public class QuickSort {

    static int[] input = {7,3,5,2,4,1,8,6};
    static int compares;

    public static void main(String[] args) {
        compares = 0;
        quickSort(input, 0, input.length-1);
        print();
        System.out.println("compares: "+compares);
    }

    private static void print() {
        for (int i = 0; i<input.length; i++){
            System.out.println(input[i]);
        }
    }

    private static void quickSort(int[] input, int from, int to) {
        if (to - from < 1){  //sorted
            return;
        }

        int pivit = input[from];

        int i = from + 1;
        int j = to;

        int middle = 0;
        while (true){
            i = getNextIndexForSmaller(i, j, pivit);
            if (i == -1){
                compares++;
                if (pivit > input[j]){
                    middle = j;
                }else {
                    middle = j-1;
                }
                break;
            }else{
                j = getNextIndexForBigger(i,  j, pivit);
            }

            if(i != -1 && j!= -1){
                switchThem(i, j);
            }else{
                // i =! -1 (and j == -1)
                middle = i-1;
                break;
            }

        }

        switchThem(from, middle);
        quickSort(input, from, middle - 1);//left
        quickSort(input, middle+1, to);//right

    }

    private static void switchThem(int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }

    private static int getNextIndexForBigger(int i, int j, int pivit) {
        while (j > i){
            compares++;
            if (input[j] < pivit){
                return j;
            }
            j--;
        }
        return -1;
    }

    private static int getNextIndexForSmaller(int i, int j, int pivit) {
        while (i < j){
            compares++;
            if (input[i] > pivit){
                return i;
            }
            i++;
        }
        return -1;
    }

}
