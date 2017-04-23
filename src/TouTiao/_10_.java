package TouTiao;

/**
 * 找到数组前k大的数
 * Created by Yang on 2017/4/23.
 */
public class _10_ {

    public static void swap(int[] a,int m,int n){
        if(m!=n){
            int temp = a[m];
            a[m] = a[n];
            a[n] = temp;
        }
    }

    //如果是找第k大的数,运用快排的思想
    public static int getMaxKVaule(int[] a,int low,int high,int k){
        if(low<high){
            int pivot = partation(a,low,high);
            //求基准值距离最右边的长度
            int len = high-pivot+1;
            if(len==k){
                return a[pivot];
            }else if(len > k){
                //如果长度大于k，证明第k大的数在右边
                return getMaxKVaule(a,pivot+1,high,k);
            }else {
                return getMaxKVaule(a,low,pivot-1,k-len);
            }
        }else {
            return -1;
        }
    }

    public static int partation(int[] a,int low,int high){

        int pivot = a[low];
        while (low<high){

            while (low<high&&a[high]>=pivot)high--;
            swap(a,low,high);
            while (low<high&&a[low]<=pivot)low++;
            swap(a,low,high);
        }
        a[low] = pivot;
        return low;
    }

    public static void main(String[] args){
        int[] a = {8,9,3,5,4,12,6,1};
        int k = 6;
        System.out.print(getMaxKVaule(a,0,a.length-1,k));
    }
}
