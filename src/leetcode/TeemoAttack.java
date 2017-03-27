package leetcode;
public class TeemoAttack{


    public static int findPoisonedDuration(int[] timeSeries, int duration) {
        
        int len = timeSeries.length;
        boolean[] flags = new boolean[timeSeries[timeSeries.length-1]+1];
        for(int i=0;i<len;i++){
            flags[timeSeries[i]]=true;
        }

        int result = 0;
        for(int i=0;i<len;i++){
            boolean hasan = false;
            int has_index = 0;
            for(int j=timeSeries[i]+1;j<=timeSeries[i]+duration && j<flags.length;j++){
                if(flags[j]){
                    hasan = true;
                    has_index = j-timeSeries[i];
                    break;
                }
            }

            if(hasan){
                result = result + has_index;
            }else{
                result += duration;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] a ={1,2,3,6};
        
        System.out.println(findPoisonedDuration(a,5));
    }
}