package TouTiao;

/**
 * 实现c++的lowerr_bound,原理部分请看 http://blog.csdn.net/niushuai666/article/details/6734403
 * Created by Yang on 2017/4/22.
 */
public class _5_ {

    //使用二分法查找位置，如果mid与n相等的返回mid，如果mid>n，则让high = mid；
    //如果mid<n,则让low=mid+1；
    public static int lowerBound(int[] array,int start,int end,int n){

        if(n>array[array.length-1])
            return array.length;

        while (start!=end){
            int mid = (start+end)/2;
            if(array[mid]==n)
                return mid;
            else if(array[mid]>n){
                end=mid;
            }else {
                start = mid+1;
            }
        }

        return end;
    }

    public static void main(String[] args){
        int[] a = {4,10,11,30,69,70,96,100};
        System.out.print(lowerBound(a,0,a.length-1,9));
    }
}
