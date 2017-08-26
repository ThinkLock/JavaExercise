package leetcode;


//Container With Most Water
public class _11_ {


//    Time Limit Exceeded  0(n2)
    public static int maxArea(int[] height) {

        int res = 0;
        for(int i = 0;i<height.length-1;i++){
            for(int j = i+1;j<height.length ;j++){
                int h = height[j] >= height[i]?height[i]:height[j];
                int w = Math.abs(j-i);
                int area = w * h;
                if(area > res){
                    res = area;
                }
            }
        }
        return res;
    }

    public static int maxAreaN(int[] height){

        int max = 0;
        int l  = 0;
        int r = height.length -1;

        while (l < r){
            max  = Math.max(max, Math.min(height[l],height[r]) * (r-l));

            if(height[l] < height[r]){
                l++;
            }else {
                r--;
            }
        }
        return max;
    }

    public static void main(String args[]){

    }
}
