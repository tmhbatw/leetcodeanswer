package leetcode5;

import java.util.Locale;

public class Leetcode415 {
    /*Description
    * 给定两个字符串形式的非负整数num1 和num2，计算它们的和。
    * 提示：
    * num1 和num2的长度都小于 5100
    * num1 和num2 都只包含数字0-9
    * num1 和num2 都不包含任何前导零
    * 你不能使用任何內建 BigInteger 库，也不能直接将输入的字符串转换为整数形式
    * */
    public String addStrings(String num1, String num2) {
        if(num1==null)
            return num2;
        if(num2==null)
            return num1;
        if(num1.length()<num2.length()){
            String temp=num1;
            num1=num2;
            num2=temp;
        }
        char[] c1=num1.toCharArray(),c2=num2.toCharArray();
        int count=0;
        int length1=c1.length,length2=c2.length;
        for(int i=0;i<length1;i++){
            int number1=c1[length1-i-1]-'0';
            int number2=i>=length2?0:c2[length2-i-1]-'0';
            int cur=number1+number2+count;
            c1[length1-i-1]=(char)(cur%10+'0');
            count=cur/10;
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<length1;i++)
            sb.append(c1[length1-i-1]);
        if(count==1)
            sb.append(1);
        return sb.reverse().toString();
    }

}
