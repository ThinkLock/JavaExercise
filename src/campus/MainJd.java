package campus;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Yang on 2017/4/7.
 */
public class MainJd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        char[] input = s.toCharArray();
        HashMap<Integer,Boolean> hashMap = new HashMap<>();
        for(int i=0;i<n;i++){
            if(input[i]=='X'){
                hashMap.put(i,false);
            }
        }

        for(int i=0;i<n;i++){
            if(input[i]>='1'&&input[i]<='9'){
                int item = Integer.parseInt(""+input[i]);
                int start = i-item;
                int end = i+item;
                for(int j=start;j<=end;j++){
                    if(hashMap.containsKey(j)){
                        hashMap.put(j,true);
                    }
                }
            }
        }
        int result = 0;
        for(Map.Entry<Integer,Boolean> entry : hashMap.entrySet()){
            if(entry.getValue()){
                result++;
            }
        }

        System.out.println(result);
    }
}
