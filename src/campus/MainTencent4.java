package campus;


import java.util.Scanner;

/**
 * Created by Yang on 2017/4/3.
 */
public class MainTencent4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int len = input.length();
        int last = input.charAt(0);
        int offset = 0;
        for(int i=0;i<len;i=i+16){
            String item = input.substring(i,i+16);
            StringBuffer sb = new StringBuffer();
            for(int j=0;j<16;j++){
                String my = letterToH(""+item.charAt(j));
                if(j==7||j==15){
                    sb.append(my+"  ");
                }else {
                    sb.append(my+" ");
                }
            }
            System.out.println(String.format("%08d",offset)+"  "+sb.toString()+item);
            offset += 10;
        }
    }
    public static String letterToH(String letter) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < letter.length(); i++) {
            char c = letter.charAt(i);
            sb.append(Integer.toHexString(c));
            sb.append(", ");
        }
        sb.deleteCharAt(sb.length() - 2);
        return sb.toString();
    }
}
