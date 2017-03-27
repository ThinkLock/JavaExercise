package CodingInterview.Chp1;
public class Coding1_5{

  public static String compressStr(String str){
      if(str==null || str.isEmpty()) return "";
      int size = countCompress(str);
      if(size>=str.length()) return str;

      char last = str.charAt(0);
      int count = 1;
      StringBuffer sb = new StringBuffer();
      for(int i=1;i<str.length();i++){
          if(str.charAt(i) == last){
            count++;
          }else{
            sb.append(last);
            sb.append(count);
            last = str.charAt(i);
            count = 1;
          }
      }

      sb.append(last);
      sb.append(count);
      return sb.toString();
  }


  public static int countCompress(String str){
      if(str==null || str.isEmpty()) return 0;
      char last = str.charAt(0);
      int size = 0;
      int count = 1;
      for(int i=1;i<str.length();i++){
          if(str.charAt(i)==last){
            count++;
          }else{
            size = size + 1 + String.valueOf(count).length();
            count=1;
            last = str.charAt(i);
          }

      }
      size = size + 1 + String.valueOf(count).length();
      return size;
  }

  public static void main(String[] args) {
    String s = "aabccccddaa";
    System.out.println(compressStr(s));
  }
}
