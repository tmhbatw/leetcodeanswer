package leetcode2;

import java.util.HashMap;
import java.util.Map;

public class Leetcode166 {
    /*Description
    * 给定两个整数，分别表示分数的分子numerator 和分母 denominator，以 字符串形式返回小数 。
    * 如果小数部分为循环小数，则将循环的部分括在括号内。
    * 如果存在多个答案，只需返回 任意一个 。
    * 对于所有给定的输入，保证 答案字符串的长度小于 104 。
    * */

    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator==0)
            return "0";
        long numerator1=numerator,denominator1=denominator;
        boolean positive=true;
        if(numerator<0) {
            positive = false;
            numerator1=-numerator1;
        }
        if(denominator<0){
            denominator1=-denominator1;
            positive=!positive;
        }
        long left=numerator1/denominator1;
        long right=numerator1%denominator1;
        if(right==0)
            return (positive?"":"-")+left+"";
        return (positive?"":"-")+left+"."+getScore(right*10,denominator1);
    }


    private String getScore(long right,long denominator){
        StringBuilder sb=new StringBuilder();
        Map<Long,Integer> map=new HashMap<>();
        int index=1;
        map.put(right,0);
        while(right!=0){
            Long cur=right/denominator;
            sb.append(cur);
            right%=denominator;
            right*=10;
            if(map.containsKey(right)){
                sb.insert(map.get(right),"(");
                sb.append(")");
                return sb.toString();
            }
            map.put(right,index++);
        }
        return sb.toString();
    }

    public static void main(String[] args){
        int num1=Integer.MIN_VALUE;
        int num2=1;
        System.out.println(new Leetcode166().fractionToDecimal(num1,num2));
    }
}
