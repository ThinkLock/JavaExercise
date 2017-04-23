package TouTiao;

/**
 * 两个有序的数组，找到第k大的数,假设数组递增排列
 * Created by Yang on 2017/4/23.
 */
public class _11_{

    public static int getMaxKValue(int[] a,int[] b,int k){

        int alen = a.length;
        int blen = b.length;

        int i = alen-1;
        int j = blen-1;
        //计数器
        int count = 0;
        //结果
        int res = 0;
        while (i>=0 && j>=0){
            if(count==k){
                return  res;
            }
            if(a[i]>=b[j]){
               res = a[i];
               i--;
            }else {
                res = b[j];
                j--;
            }
            count++;
        }
        return res;
    }

    public static void main(String[] args){
        int[] a = {1,3,7,9};
        int[] b = {2,4,6,11};
        System.out.print(getMaxKValue(a,b,6));
    }
}
