package leetcode;

/**
 * Created by Yang on 2017/3/30. 两个数相加 位操作实现
 */
public class _371_ {

    public static int addBit(int a,int b){
        if(b==0)
            return a;

        int sum_without_carry = a^b;    //异或相当于 没有进位的 加
        int carry = (a&b)<<1;

        return addBit(sum_without_carry,carry);
    }
}
