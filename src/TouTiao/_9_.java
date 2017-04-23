package TouTiao;

/**
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，
 *每一列都按照从上到下递增的顺序排序。请完成一个函数，
 * 输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * Created by Yang on 2017/4/23.
 */
public class _9_ {
    public static boolean Find(int target, int [][] array) {
        int row = array.length;
        int clum = array[0].length;

        int i = row-1;
        int j=0;
        while (i>=0 && j<clum){
            if(target==array[i][j]){
                return true;
            }else if(target>array[i][j]){
                j++;
            }else {
                i--;
            }
        }
        return false;
    }
}
