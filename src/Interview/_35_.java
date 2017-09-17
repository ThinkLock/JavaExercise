package Interview;

import java.util.Stack;

public class _35_ {

    public static void reverseTree(_28_.TreeNode node){
        // 非递归

        if(node==null) return;

        Stack<_28_.TreeNode> stack = new Stack<>();
        stack.push(node);
        while (!stack.empty()){
            _28_.TreeNode item = stack.pop();
            if(item.left!=null || item.right!=null){
                _28_.TreeNode temp = item.left;
                item.left = item.right;
                item.right = temp;
            }

            if(item.left !=null){
                stack.push(item.left);
            }
            if(item.right!=null){
                stack.push(item.right);
            }
        }
    }

}
