package leetcode4;

import java.math.BigInteger;

public class Leetcode306 {
    /*Description
    * 累加数是一个字符串，组成它的数字可以形成累加序列。
    * 一个有效的累加序列必须至少包含 3 个数。除了最开始的两个数以外，字符串中的其他数都等于它之前两个数相加的和。
    * 给定一个只包含数字'0'-'9'的字符串，编写一个算法来判断给定输入是否是累加数。
    * */

    public boolean isAdditiveNumber(String num) {
        int length=num.length();
        for(int i=1;i<=length/2;i++){
            BigInteger cur=new BigInteger(num.substring(0,i));
            for(int j=i+1;j<=(length-i)/2+i;j++){
                BigInteger first=cur;
                BigInteger second=new BigInteger(num.substring(i,j));
                if(isAdditiveNumber(first,second,j,num))
                    return true;
                if(num.charAt(i)=='0')
                    break;
            }
            if(num.charAt(0)=='0')
                break;
        }
        return false;
    }

    private boolean isAdditiveNumber(BigInteger first,BigInteger second,int start,String num){
        int length=num.length();
        while(start<length){
            System.out.println(first+" "+second);
            BigInteger temp=new BigInteger(second.toString());
            second=second.add(first);
            System.out.println(second);
            if(num.indexOf(second.toString(),start)!=start){
                return false;
            }
            start+=second.toString().length();
            first=temp;
        }
        return true;
    }





    public static void main(String[] args){
        String test="123";
        System.out.println(test);
        System.out.println(new Leetcode306().isAdditiveNumber(test));
    }
}
