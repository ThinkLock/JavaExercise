package CodingInterview.Chp1;
import java.util.Scanner;

public class Coding1_2{

//反转字符串
  public static String reverse(String s){
    char[] a = s.toCharArray();
    int end = s.length()-1;
    int start  = 0;

    while(start<end){
        char temp  = a[start];
        a[start] = a[end];
        a[end] = temp;
        start++;
        end--;
    }


    return String.valueOf(a);
  }


  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String s = sc.nextLine();
    System.out.println(reverse(s));
  }
}
