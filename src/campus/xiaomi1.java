package campus;

import java.util.Scanner;

public class xiaomi1 {

    static boolean fun(String table, int n) {

        int zero_num = 0;
        int[] table_int = new int[table.length()];
        int len = table.length();
        for(int i=0;i<len;i++){
            int temp = Integer.valueOf(""+table.charAt(i));
            if(temp==0)zero_num++;
            table_int[i] = temp;
        }

        // 判断0的个数
        if(zero_num<(2*n+1))
            return false;

        int can_insert = 0;
        int i=1;
        while (i<len-1){
            if(table_int[i-1]==0 && table_int[i]==0 && table_int[i+1]==0){
                can_insert += 1;
                i = i+2;
            }else {
                i++;
            }
            if(can_insert>=n){
                return true;
            }
        }

        return false;

    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        boolean res;

        String _table;
        try {
            _table = in.nextLine();
        } catch (Exception e) {
            _table = null;
        }

        int _n;
        _n = Integer.parseInt(in.nextLine().trim());

        res = fun(_table, _n);
        System.out.println(String.valueOf(res ? 1 : 0));
    }
}
