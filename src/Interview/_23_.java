package Interview;

/**
 * 快速排序
 * Created by Yang on 2017/4/26.
 */
public class _23_ {

    public static void quicksort(int[] a){
        qsort(a,0,a.length-1);
    }

    public static void qsort(int[] a,int low,int high){
        if(low<high){
            int pivot = partition(a,low,high);
            qsort(a,low,pivot-1);
            qsort(a,pivot+1,high);
        }
    }


    public static int partition(int[] a,int low,int high){
        int pivot = a[low];
        while (low<high){
            while (low<high&&a[high]>=pivot)
                high--;
            swap(a,low,high);
            while (low<high&&a[low]<=pivot)
                low++;
            swap(a,low,high);
        }
        a[low] = pivot;
        return low;
    }

    public static void swap(int[] a,int m,int n){
        if(m!=n){
            int temp = a[m];
            a[m] = a[n];
            a[n] = temp;
        }
    }
}
