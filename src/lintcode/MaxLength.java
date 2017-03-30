package lintcode;
import java.util.Scanner;

/**
 * Created by Yang on 2017/3/30.
 */
public class MaxLength {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int [] nums = new int [num];
        for (int i = 0; i < num; i++)
            nums[i] = in.nextInt();
        cal(nums);
        in.close();
    }
    public static void cal(int[] in) {
        if (in == null || in.length <= 2) {
            System.out.println(-1 + " " + -1);
            return;
        }
        int ans_max = -1;
        int ans_left = -1;
        int ans_right = -1;
        for (int i = 0; i < in.length; i++) {
            int tmp = i + 1;
            while (tmp < in.length && in[tmp] > in[tmp - 1])
                tmp += 1;
            if (tmp >= in.length)
                break;
            int tmp2 = tmp-1;
            while (tmp+1 < in.length && in[tmp+1] < in[tmp])
                tmp += 1;
            if ((tmp - i+1) >= 3 && tmp2!=i&& (tmp - i) >= ans_max) {
                ans_max = tmp - i + 1;
                ans_left = i;
                ans_right = tmp;
            }
            i = tmp-1;
        }
        System.out.println(ans_left + " " + ans_right);
    }
}
