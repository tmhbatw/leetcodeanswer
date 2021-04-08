package leetcode.leetcode2;

import java.util.Stack;

public class Leetcode150 {
    /*Description
    * 根据 逆波兰表示法，求表达式的值。
    * 有效的运算符包括+,-,*,/。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
    * 说明：
    * 整数除法只保留整数部分。
    * 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
    * */

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack=new Stack<>();
        for(String cur:tokens){
            if(cur.equals("*"))
                stack.add(stack.pop()*stack.pop());
            else if(cur.equals("-"))
                stack.add(-stack.pop()+stack.pop());
            else if(cur.equals("+"))
                stack.add(stack.pop()+stack.pop());
            else if(cur.equals("/")){
                int num1=stack.pop(),num2=stack.pop();
                stack.add(num2/num1);
            }
            else
                stack.add(Integer.parseInt(cur));
        }
        return stack.pop();
    }
}
