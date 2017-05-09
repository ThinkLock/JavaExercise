package leetcode;

import java.util.Stack;

/**
 * Created by fengzhaoyang_i on 2017/5/9.
 */
public class _155_ {

    public static class MinStack{

        long min;
        Stack<Long> stack;

        public MinStack(){
            stack = new Stack<>();
        }

        public void push(int val){
            if(stack.isEmpty()){
                stack.push(0L);
                min = val;
            }else {
                stack.push(val-min);
                if(val<min)
                    min = val;
            }
        }

        public int top(){
            long top = stack.peek();
            if(top>0)
                return (int)(min+top);
            else
                return (int)min;
        }

        public void pop(){
            if(stack.isEmpty())
                return;
            long pop = stack.pop();
            if(pop<0)
                min = min-pop;

        }

        public int getMin(){
            return (int)min;
        }
    }

    public static void main(String[] args){
        MinStack minStack = new MinStack();
        minStack.push(-1);
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.push(5);

        System.out.println(minStack.getMin());
        minStack.pop();
        minStack.pop();
        System.out.println(minStack.getMin());
    }

}
