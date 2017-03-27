package leetcode;
public class ArrayUtils {

    public static void printArray(int[] array) {
        System.out.print("{");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }  
        System.out.println("}");
    }

    public static void exchangeElements(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static void print2Array(int[][] a){
        for (int i = 0; i < a.length; i++) {
            for(int j=0;j<a.length;j++){
                System.out.print(a[i][j]+"  ");
            }
            System.out.println();
        }
    }
}
