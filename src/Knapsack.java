/**
 * Created with IntelliJ IDEA.
 * User: Graf
 * Date: 06.05.14
 * Time: 19:51
 * To change this template use File | Settings | File Templates.
 */
public class Knapsack {

    static Thing[] things = new Thing[]{new Thing(5,2), new Thing(8,3), new Thing(14, 5)};
    static int sackSize = 49;

    public static void main(String[] args) {
//        int totalVal = getSackFilled(sackSize, 2);
        int totalVal = getSackFilledNonRecurcively();
        System.out.println(totalVal);
    }

    private static int getSackFilledNonRecurcively() {
        int[][] options = new int[things.length][sackSize];
        for (int i = 0; i < options.length; i++){
            for (int j = 0; j < options[i].length; j++){
                options[i][j] = Math.max(getValBasedOnPreviousInThisRow(options, i, j), getFromUpperRow(options, i, j));
//                int value = 0;
//                if ((j+1) % things[i].size == 0){  //j+1 > things[i].size
//                    value = options[i][j-things[i].size]+things[i].value;//getThingValue(i, j);
//                } else {// if ((j+1) == things[i].size){
//                    value = things[i].value;
//                }
////                for (int k = i-1; k >= 0; k--){
//                    int k= i-1;
//                    if (k  >= 0 && value < options[k][j]){
//                        value = options[k][j];
//                    }
////                }
//                options[i][j] = value;
            }
        }
        printArray(options);
        return 1;

    }

    private static int getValBasedOnPreviousInThisRow(int[][] options, int i, int j) {
        int val = getPreviousInThisRow(options, i, j);
//        if ((j+1) % things[i].size == 0){
        if (j+1 >= things[i].size){
            return val + things[i].value;
        }
        return 0;  //To change body of created methods use File | Settings | File Templates.
    }

    private static int getPreviousInThisRow(int[][] options, int i, int j) {
        int i1 = i - 1;
        int j1 = j - things[i].size;
        if (i1 >= 0 && j1 >= 0){
            return options[i1][j1];
        }
        return 0;//Integer.MIN_VALUE;
    }

    private static int getFromUpperRow(int[][] options, int i, int j) {
        int index = i - 1;
        if (index >= 0){
            return options[index][j];
        }
        return 0;  //To change body of created methods use File | Settings | File Templates.
    }


//    private static int getThingValue(int i, int j) {
//        int thingsNumber = (j+1) / things[i].size;
//        if (thingsNumber*things[i].size == j+1){
//            return  thingsNumber * things[i].value;
//        }
//        return 0;
//
//
//    }

    private static void printArray(int[][] options) {
        for (int i = 0; i < options.length; i++){
            for (int j = 0; j < options[i].length; j++){
                System.out.print(options[i][j]);
                System.out.print(" ");
            }
            System.out.println("");
        }

    }

    private static int getSackFilled(int sackSize, int i) {
        if (i < 0 ){
            return 0;
        }else if( sackSize < 0){
            return Integer.MIN_VALUE;
        }

        return Math.max(getSackFilled(sackSize, i-1), getSackFilled(sackSize-things[i].size, i)+things[i].value);  //To change body of created methods use File | Settings | File Templates.
    }

    private static class Thing{
        int value;
        int size;
        public Thing(int value, int size){
            this.value = value;
            this.size = size;
        }
    }
}
