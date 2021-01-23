package leetcode3;

import java.util.Stack;

public class Leetcode227 {
    /*Description
    *实现一个基本的计算器来计算一个简单的字符串表达式的值。
    * 字符串表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。
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
                    while(!symbolStack.empty()&&getLevel(symbolStack.peek())<=getLevel(cur)){
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
            System.out.println(numberStack);
            System.out.println(symbolStack);
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

    public static void main(String[] args){
        String test="1*2-3/4+5*6-7*8+9/10";
        System.out.println(new Leetcode227().calculate(test));
    }
}
