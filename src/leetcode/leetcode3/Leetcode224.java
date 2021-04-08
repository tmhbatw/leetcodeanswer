package leetcode.leetcode3;

import java.util.Stack;

public class Leetcode224 {
    /*Description
    * 实现一个基本的计算器来计算一个简单的字符串表达式 s 的值。
     * */

    /*PS
    * 按照题目测试用例的编写情况，可能不考虑数字之间的空格情况
    * */
    public int calculate(String s) {
        int length=s.length();
        Stack<Character> symbolStack=new Stack<>();
        Stack<Integer> numberStack=new Stack<>();
        numberStack.add(0);
        for(int i=0;i<s.length();i++){
            char cur=s.charAt(i);
            switch (cur){
                case ' ':
                    continue;
                case '(':
                    symbolStack.add('(');
                    break;
                case '+':
                case '-':
                case '*':
                case '/':
                    if(!symbolStack.empty()&&getLevel(symbolStack.peek())<=getLevel(cur)){
                        calculate(symbolStack.pop(),numberStack);
                    }
                    symbolStack.add(cur);
                    break;
                case ')':
                    while(symbolStack.peek()!='(')
                        calculate(symbolStack.pop(),numberStack);
                    symbolStack.pop();
                    break;
                default:
                    int number=cur-'0';
                    while(i<length-1&&isNumber(s.charAt(i+1))){
                        number=number*10+s.charAt(++i)-'0';
                    }
                    numberStack.add(number);
            }
        }
        while(!symbolStack.empty())
            calculate(symbolStack.pop(),numberStack);
        return numberStack.peek();
    }

    private void calculate(char symbol,Stack<Integer> numberStack){
        int number2=numberStack.pop();
        int number1=numberStack.pop();
        switch (symbol){
            case '+':
                numberStack.add(number1+number2);
                break;
            case '-':
                numberStack.add(number1-number2);
                break;
            case '*':
                numberStack.add(number1*number2);
                break;
            case '/':
                numberStack.add(number1/number2);
        }
    }

    private int getLevel(char cur){
        switch(cur){
            case '+':
            case '-':
                return 3;
            case '*':
            case '/':
                return 2;
            default:
                return 4;
        }
    }

    private boolean isNumber(char cur){
        return cur<='9'&&cur>='0';
    }
}
