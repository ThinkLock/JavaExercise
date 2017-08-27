package Interview;

/**
 * 斐波那契数列
 * Created by Yang on 2017/4/26.
 */
public class _24_ {

    //递归方式实现
    public static int fibonacci(int n){
        if(n<=2){
            return 1;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }

    public static int fibonacci2(int n){
        if(n<=2){
            return 1;
        }
        int num1 = 1;
        int num2 = 1;
        int temp;
        for(int i=2;i<n;i++){
            temp = num2;
            num2 = num1+num2;
            num1 = temp;
        }
        return num2;
    }

    public static void main(String[] args){
        System.out.println(fibonacci(10)+" " + fibonacci2(10));
    }
}
