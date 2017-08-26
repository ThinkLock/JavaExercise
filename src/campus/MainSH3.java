package campus;

import java.util.Scanner;

/**
 * Created by Yang on 2017/4/16.
 */
public class MainSH3 {

    public static int[] SWAP = {2,1,5,4,3,7,6,10,9,8};

    public static String getNext(String in){

        StringBuffer sb = new StringBuffer();
        char[] inputs = in.toCharArray();
        for(int i=0;i<inputs.length;i++){
            char item = inputs[i];
            char next;
            if(item=='Z'){
                next = 'A';
            }else {
                next = (char)(item+1);
            }
            sb.append(next);
        }
        return sb.toString();
    }

    public static String getSwap(String in){
        char[] input = in.toCharArray();
        for(int i=0;i<input.length;i++){
            int from = i;
            int to = SWAP[i%10];
            swap(input,from,to);
        }
        return input.toString();
    }


    public static void swap(char[] in,int from ,int to){
        char temp = in[from];
        in[from] = in[to];
        in[to] = temp;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String after = sc.nextLine();
        String origin = sc.nextLine();

        if(after.length()!=origin.length() || after.length()<10){
            System.out.print("NO");
        }

        if(after.equals(getSwap(getNext(origin)))){
            System.out.print("YES");
        }else{
            System.out.print("NO");
        }
    }
}
