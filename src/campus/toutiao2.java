package campus;

import java.util.Scanner;

public class toutiao2 {


    public static int judge(int[] user, int l,int r,int k){
        int res = 0;
        if(r>=user.length){
            r = user.length-1;
        }

        for(int i=l;i<r;i++){
            if(user[i] == k){
                res ++;
            }
        }

        return res;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
        int[] user = new int[n];
        for(int i=0;i<n;i++){
            user[i] = sc.nextInt();
        }
        int q = sc.nextInt();
        sc.nextLine();
        String[] query = new String[q];
        for (int i=0;i<q;i++){
            query[i] = sc.nextLine();
        }

        int[] res = new int[q];
        for(int i=0;i<q;i++){
            // judge num
            String[] item = query[i].split(" ");

            int l = Integer.valueOf(item[0]) - 1;
            int r = Integer.valueOf(item[1]) - 1;
            int k = Integer.valueOf(item[2]);

            int num = judge(user,l,r,k);
            res[i] = num;
        }

        for(Integer i : res){
            System.out.println(i);
        }

    }
}
