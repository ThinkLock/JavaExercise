package CodingInterview.Chp1;
import java.util.Scanner;

public class Coding1_1{
  //检查 字符串中的字符是不是全都不同
  public static boolean check(String s){
    if(s.length()>256) return false;
    int len = s.length();
     boolean[] flag = new boolean[256];
     for(int i=0;i<len;i++){
        if(flag[s.charAt(i)]){
          return false;
        }else {
          flag[s.charAt(i)]=true;
        }

     }
    return true;
  }

  public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      String s = sc.nextLine();
      System.out.println(check(s));
  }
}
