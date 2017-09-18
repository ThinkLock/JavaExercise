package campus;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class xiaomi2 {

    static long fun(long x) {

        if(x==1){
            return 1;
        }

        long i=2;
        List<Long> current = new ArrayList<>();
        current.add(1L);
        current.add(1L);
        while (!current.contains(x)){
            System.out.println(current.contains(x));
            List<Long> parent = current;
            current = new ArrayList<>();
            current.add(1L);
            for(int j=1;j<=parent.size();j++){

                long left = parent.get(j-1);
                long top = 0;
                if(j<parent.size()){
                    top= parent.get(j);
                }

                current.add(left + top);
            }
            i++;
        }

        return i;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        long res;

        long _x;
        _x = Long.parseLong(in.nextLine().trim());

        res = fun(_x);
        System.out.println(String.valueOf(res));
    }
}
