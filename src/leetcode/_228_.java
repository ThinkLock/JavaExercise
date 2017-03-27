package leetcode;
import java.util.ArrayList;
import java.util.List;

public class _228_{

    public static List<String> summaryRanges(int[] nums){
        List<String> list = new ArrayList<>();
        if(nums==null || nums.length==0){
            return list;
        }

    
        int start = nums[0];
        for(int i=1;i<nums.length;i++){
            StringBuffer sb = new StringBuffer();
            if(nums[i]-nums[i-1]>1){
                if(start!=nums[i-1]){
                    sb.append(String.valueOf(start));
                    sb.append("->");
                    sb.append(String.valueOf(nums[i-1]));
                    list.add(sb.toString());
                }else{
                    list.add(String.valueOf(start));
                }
                start = nums[i];
            }
        }

        if(start==nums[nums.length-1]){
            list.add(String.valueOf(start));
        }else{
            StringBuffer sb = new StringBuffer();
            sb.append(String.valueOf(start));
            sb.append("->");
            sb.append(String.valueOf(nums[nums.length-1]));
            list.add(sb.toString());                    
        }

        return list;
    }

    public static void main(String[] args) {
        int[] a = {1,3};
        List<String> b = summaryRanges(a);
        for(String s : b){
            System.out.println(s);
        }
    }
}