package Interview;

import java.util.ArrayList;

/**
 * 一个数组没有重复的数，求子集
 * http://blog.csdn.net/u012118523/article/details/24884803
 * Created by Yang on 2017/4/24.
 */
public class _21_ {

    //第一个方法，用一个二叉树来表示，一边表示选择，一边表示不选择，
    //设置一个缓存temp，用来保存没向下一层的选择的数，没有选择
    //当遍历到叶子节点时，将缓存加入res
    public static ArrayList<ArrayList<Integer>> getAllSubSets(int[] a){
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        subSets(a,temp,0,res);
        return res;
    }
    public static void subSets(int[] a,ArrayList<Integer> temp,int level,ArrayList<ArrayList<Integer>> res){
        if(level==a.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        //不选择一边的递归
        subSets(a,temp,level+1,res);
        //选择的一边
        temp.add(a[level]);
        subSets(a,temp,level+1,res);
        temp.remove(temp.size()-1);
    }

    public static void main(String[] args){
        int[] a = {1,2};
        ArrayList<ArrayList<Integer>> res = getAllSubSets(a);
        for(ArrayList alist : res){
            System.out.println(alist.toString());
        }
    }
}
