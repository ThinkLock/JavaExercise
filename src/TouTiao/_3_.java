package TouTiao;

import java.util.Stack;

/**
 * 表达式括号的匹配
 * Created by Yang on 2017/4/22.
 */
public class _3_ {

    public static boolean isVaild(String inputs){

        char[] ins = inputs.toCharArray();
        Stack<Character> stack = new Stack<>();
        //如果是左括号则将他对应的右括号压入栈中，如果是右括号，则判断当前栈顶元素是不是等于当前，
        //如果相等则弹出，如果不等则直接返回false
        for(int i=0;i<ins.length;i++){
            switch (ins[i]){
                case '(':
                    stack.push(')');
                    break;
                case '{':
                    stack.push('}');
                    break;
                case '[':
                    stack.push(']');
                    break;
                case ']':
                    //如果当前栈为空，则不合法，如果不空且栈顶元素不同则不合法
                    if(stack.empty() || (!stack.empty()&&stack.peek()!=']')){
                        return false;
                    }else {
                        stack.pop();
                    }
                    break;
                case '}':
                    if(stack.empty() || (!stack.empty()&&stack.peek()!='}')){
                        return false;
                    }else {
                        stack.pop();
                    }
                    break;
                case ')':
                    if(stack.empty() || (!stack.empty()&&stack.peek()!=')')){
                        return false;
                    }else {
                        stack.pop();
                    }
                    break;
            }
        }
        if(stack.empty()){
            return true;
        }else {
            return false;
        }
    }
    public static void main(String[] args){
        String a = "({[]})[]]";
        System.out.print(isVaild(a));
    }

}
