package campus;

import java.util.Scanner;

public class _3603_ {




    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] b = new int[m];
        for(int i=0;i<m;i++){
            b[i] = sc.nextInt();
        }

        int suma,sumb,sub;
        boolean isMore;
        int swap_a= 0,swap_b = 0;
        float min = 0;
        boolean haveSolution;


        while (true){
            suma = 0;
            sumb = 0;
            for (int i=0;i<n;i++){
                suma += a[i];
            }
            for(int i=0;i<m;i++){
                sumb += b[i];
            }

            sub = Math.abs(suma - sumb);
            if(sub == 0){
                System.out.print(0);
                break;
            }

            isMore = (suma-sumb) > 0;
            haveSolution = false;

            for(int i = 0;i<n;i++){
                for(int j=0;j<m;j++){
                    int temp = a[i] - b[j];
                    if((isMore && temp > 0 && temp < sub) || (!isMore && temp < 0 && temp > sub)){
                        if(haveSolution && Math.abs(temp - sub/2.0) < min){
                            min = (float) Math.abs(temp - sub/2.0);
                            swap_a = i;
                            swap_b = j;
                        }else {
                            haveSolution = true;
                            min = (float)Math.abs(temp - sub/2.0);
                            swap_a = i;
                            swap_b = j;
                        }
                    }
                }
            }

            if(!haveSolution){
                System.out.print(Math.abs(sub));
                break;
            }

            int swap_temp = a[swap_a];
            a[swap_a] = b[swap_b];
            b[swap_b] = swap_temp;

        }

    }
}
