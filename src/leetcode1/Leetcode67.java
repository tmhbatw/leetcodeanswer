package leetcode1;

public class Leetcode67 {
    /*Description
    *给你两个二进制字符串，返回它们的和（用二进制表示）。
    * 输入为 非空 字符串且只包含数字 1 和 0
    * */

    public String addBinary(String a, String b) {
        if(a.length()<b.length()){
            String temp=a;
            a=b;
            b=temp;
        }
        int i=a.length()-1,j=b.length()-1;
        int count=0;
        StringBuilder sb=new StringBuilder();
        while(j>=0){
            int cur=a.charAt(i--)-'0'+b.charAt(j--)-'0'+count;
            count=cur/2;
            sb.append(cur%2);
        }
        while(i>=0){
            int cur=a.charAt(i--)+count-'0';
            count=cur/2;
            sb.append(cur%2);
        }
        if(count!=0)
            sb.append(count);
        return sb.reverse().toString();
    }
}
