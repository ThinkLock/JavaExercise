package CodingInterview.Chp1;
import java.util.Arrays;

public class Coding1_3{

  public static boolean permutation(String s,String t){
      if(s.length()!=t.length()) return false;

      char[] sc = s.toCharArray();
      char[] tc = t.toCharArray();

      Arrays.sort(sc);
      Arrays.sort(tc);

      String ss = new String(sc);
      String tt = new String(tc);

      return ss.equals(tt);
  }


public static boolean permutation2(String s,String t){
    if(s.length()!=t.length()) return false;
    int[] char_num = new int[256];
    char[] sc = s.toCharArray();
    for(char c : sc){
        char_num[c]++;
    }

    for(int i=0;i<t.length();i++){
        char tc = t.charAt(i);
        if(--char_num[tc]<0){
            return false;
        }
    }
    return true;
}


  public static void main(String[] args) {

      String s = "adcb";
      String t = "abcd";

      System.out.println(permutation2(s,t));
  }
}
