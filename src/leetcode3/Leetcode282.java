package leetcode3;

import java.util.*;

public class Leetcode282 {
    /*Description
    * 给定一个仅包含数字 0-9 的字符串和一个目标值，在数字之间添加二元运算符（不是一元）+、- 或 * ，
    * 返回所有能够得到目标值的表达式。
    * */

    public List<String> addOperators(String num, int target) {
        if(num==null||num.length()==0)
            return Collections.emptyList();
        List<String> result=recursion(num,0);
        List<String> res=new ArrayList<>();
        for(String cur:result){
            if(calculate(cur)==target)
                res.add(cur);
        }
        return res;
    }

    private long calculate(String cur){
        System.out.println(cur);
        int length=cur.length();
        Stack<Long> number=new Stack<>();
        Stack<Character> symbol=new Stack<>();
        for(int i=0;i<cur.length();i++){
            char curr=cur.charAt(i);
            if(isInteger(curr)){
                long num=curr-'0';
                while(i<length-1&&isInteger(cur.charAt(i+1))){
                    i++;
                    num*=10;
                    num+=cur.charAt(i)-'0';
                }
                number.add(num);
            }else if(curr=='+'||curr=='-'){
                while(!symbol.empty()){
                    number.add(calculate(number,symbol));
                }
                symbol.add(curr);
            }else{
                while(!symbol.empty()&&symbol.peek()=='*'){
                    number.add(calculate(number,symbol));
                }
                symbol.add(curr);
            }
        }
        while(!symbol.empty())
           number.add(calculate(number,symbol));
        return number.pop();
    }

    private long calculate(Stack<Long> number,Stack<Character> symbol){
        long num2=number.pop();
        long num1=number.pop();
        char cur=symbol.pop();
        switch (cur){
            case '+':
                return num1+num2;
            case '-':
                return num1-num2;
            default:
                return num1*num2;
        }
    }

    private boolean isInteger(char cur){
        return cur<='9'&&cur>='0';
    }

    private List<String> recursion(String num,int start){
        List<String> result=new ArrayList<>();
        if(start==num.length()-1) {
            result.add(num.charAt(start) + "");
            return result;
        }
        if(num.charAt(start)=='0'){
            List<String> list=recursion(num,start+1);
            for(String cur:list){
                result.add("0+"+cur);
                result.add("0*"+cur);
                result.add("0-"+cur);
            }
            return result;
        }
        String n="";
        for(int i=start;i<num.length()-1;i++){
            n+=num.charAt(i);
            for(String cur:recursion(num,i+1)){
                result.add(n+"*"+cur);
                result.add(n+"+"+cur);
                result.add(n+"-"+cur);
            }
        }
        n+=num.charAt(num.length()-1);
        result.add(n+"");
        return result;
    }

    public static void main(String[] args){
        List<String> result=new Leetcode282().addOperators("3456237490",9191);
        System.out.println(result);
    }
}
