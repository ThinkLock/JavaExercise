package TouTiao;

/**
 * Created by Yang on 2017/5/14.
 */
public class _26_ {

    /**
     * 二分查找
     * @param a 输入数组
     * @param key 查询关键字
     * @return
     */
    public static int binSearch(int[] a,int key){
        if(a==null)
            return -1;
        int low = 0;
        int high = a.length-1;
        while (low<=high){
            int mid = (low+high)/2;

            if(a[mid]==key){
                return mid;
            }else if(a[mid]>key){
                high = mid-1;
            }else {
                low = mid +1;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        int[] a = {1,2,3,4,5,6,7,8};
        System.out.println(binSearch(a,5));
    }
}
