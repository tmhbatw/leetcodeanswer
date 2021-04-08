package leetcode.leetcode3;

import java.util.ArrayList;
import java.util.List;

public class Leetcode241 {
    /*Description
    * 给定一个含有数字和运算符的字符串，为表达式添加括号，
    * 改变其运算优先级以求出不同的结果。你需要给出所有可能的组合的结果。
    * 有效的运算符号包含 +,-以及*。
    * */
    List<Integer> number;
    List<Character> symbol;
    public List<Integer> diffWaysToCompute(String input) {
        number=new ArrayList<>();
        symbol=new ArrayList<>();
        int length=input.length();
        for(int i=0;i<length;i++) {
            char cur = input.charAt(i);
            switch (cur) {
                case '+':
                case '-':
                case '*':
                    symbol.add(cur);
                    break;
                default:
                    int num = cur - '0';
                    while (i < length - 1 && isNumber(input.charAt(i + 1))) {
                        num = num * 10 + input.charAt(++i) - '0';
                    }
                    number.add(num);
            }
        }
        List<Integer> result=getList(0,number.size()-1);
        return result;
    }

    private List<Integer> getList(int start,int end){
        List<Integer> result=new ArrayList<>();
        if(start==end)
            result.add(number.get(start));
        else if(end-start==1){
            result.add(getRes(number.get(start),number.get(end),symbol.get(start)));
        }
        else{
            for(int i=start+1;i<=end;i++){
                List<Integer> list1=getList(start,i-1);
                List<Integer> list2=getList(i,end);
                char sym=symbol.get(i-1);
                for(int num1:list1){
                    for(int num2:list2){
                        result.add(getRes(num1,num2,sym));
                    }
                }
            }
        }
        return result;
    }

    private int getRes(int num1,int num2,char sym){
        switch (sym){
            case '+':
                return num1+num2;
            case '-':
                return num1-num2;
            default:
                return num1*num2;
        }
    }


    private boolean isNumber(char cur){
        return cur<='9'&&cur>='0';
    }
}
