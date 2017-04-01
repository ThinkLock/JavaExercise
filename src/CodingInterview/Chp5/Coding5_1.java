package CodingInterview.Chp5;

/**
 * Created by Yang on 2017/3/30.
 *
 *  N=10000000000
 *  M=10011
 *  j=6
 *  i=2
 *  return 10001001100
 *
 */
public class Coding5_1 {

    //首先 将N的j到i位清0，然后将M左移i位，然后 N清0后的值与 M左移后的值进行 或操作，得到最后结果
    public static int updateBites(int N,int M,int j ,int i){
        int allOnes = ~0;
        int left = allOnes<<(j+1);
        int right = (1<<i)-1;
        int mask = left | right;
        int clearN = N & mask;

        return clearN | (M<<i);
    }
}
