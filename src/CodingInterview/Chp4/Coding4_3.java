package CodingInterview.Chp4;

/**
 * Created by Yang on 2017/3/28. 程序员面试金典 第四章
 */
public class Coding4_3 {

    /**
     *
     * @param a 输入数组，升序且各不相同
     * @param start 起始位置
     * @param end   终止位置
     * @return
     */
    public static TreeNode createMinialBST(int[] a,int start,int end){
        if(start>end)
            return null;
        int mid = (start+end)/2;
        TreeNode node = new TreeNode(a[mid]);
        node.left = createMinialBST(a,start,mid-1);
        node.right = createMinialBST(a,mid+1,end);
        return node;
    }

    public static TreeNode createMinialBST(int[] a){
        return createMinialBST(a,0,a.length-1);
    }
}
