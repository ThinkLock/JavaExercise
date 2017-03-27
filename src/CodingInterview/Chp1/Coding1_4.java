package CodingInterview.Chp1;
public class Coding1_4{

  public static String replaceSpace(char[] a){
    if(a==null || a.length==0) return "";

    int space_num = 0;
    for(char c : a){
      if(c==' '){
        space_num++;
      }
    }

    char[] result = new char[a.length+(space_num*2)];

    int id = 0;
    for(int i=0;i<a.length;i++){
        if(a[i]!=' '){
            result[id++] = a[i];
        }else {
            result[id++] = '%';
            result[id++] = '2';
            result[id++] = '0';
        }
    }

    return new String(result);
  }

  public static void main(String[] args) {
    String s = "Mr John Smith hhh";
    char[] a = s.toCharArray();
    System.out.println(replaceSpace(a));

  }
}
