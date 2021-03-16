package interview;

import java.util.Stack;

public class Problem16_26 {
    /*Description
    * 给定一个包含正整数、加(+)、减(-)、乘(*)、除(/)的算数表达式(括号除外)，计算其结果。
    * 表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格。 整数除法仅保留整数部分。
    * */

    public int calculate(String s) {
        Stack<Integer> numberS=new Stack<>();
        Stack<Character> symbolS=new Stack<>();
        int sLength=s.length();
        for(int i=0;i<sLength;i++){
            char cur=s.charAt(i);
            if(isNumber(cur)){
                int number=cur-'0';
                while(i<sLength-1&&isNumber(s.charAt(i+1))){
                    number=number*10+s.charAt(i+1)-'0';
                    i++;
                }
                numberS.add(number);
            }
            else if(cur==' ')
                continue;
            else{
                int level=getSymbolLevel(cur);
                while(!symbolS.isEmpty()&&getSymbolLevel(symbolS.peek())>=level){
                    numberS.add(getCal(symbolS,numberS));
                }
                symbolS.add(cur);
            }
        }
        while(!symbolS.isEmpty()){
            numberS.add(getCal(symbolS,numberS));
        }
        return numberS.peek();
    }

    private int getCal(Stack<Character> symbolS,Stack<Integer> numberS){
        char symbol=symbolS.pop();
        int num2=numberS.pop();
        int num1=numberS.pop();
        switch (symbol){
            case '+':
                return num1+num2;
            case '-':
                return num1-num2;
            case '*':
                return num1*num2;
            default:
                return num1/num2;
        }
    }

    private int getSymbolLevel(char cur){
        switch (cur){
            case '*':
            case '/':
                return 2;
            default:
                return 1;
        }
    }

    private boolean isNumber(char cur){
        return cur<='9'&&cur>='0';
    }
}
