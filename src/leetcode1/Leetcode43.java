package leetcode1;

import java.util.Arrays;

public class Leetcode43 {
    /*Description
    *给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
    * */

    public String multiply(String num1, String num2) {
        if(num1.length()<num2.length()){
            String temp=num1;
            num1=num2;
            num2=temp;
        }
        int length1=num1.length(),length2=num2.length();
        int[][] num=new int[length2][length1*2+1];
        char[] n1=num1.toCharArray(),n2=num2.toCharArray();
        for(int i=0;i<length2;i++){
            int count=0;
            int cur=n2[length2-i-1]-'0';
            for(int j=i;j<i+length1;j++){
                int curr=n1[length1-j+i-1]-'0';
                curr*=cur;
                curr+=count;
                num[i][j]=curr%10;
                count=curr/10;
            }
            num[i][length1+i]=count;
        }
        for(int[] cur:num){
            System.out.println(Arrays.toString(cur));
        }
        int count=0;
        for(int j=0;j<length1*2;j++){
            for(int i=1;i<length2;i++){
                num[0][j]+=num[i][j];

            }
            num[0][j]+=count;
            count=num[0][j]/10;
            num[0][j]%=10;
        }
        num[0][length1*2]=count;
        int index=length1*2-1;
        while(index>0&&num[0][index]==0){
            index--;
        }
        for(int[] cur:num){
            System.out.println(Arrays.toString(cur));
        }
        StringBuilder res=new StringBuilder();
        for(int i=index;i>=0;i--){
            res.append(num[0][i]);
        }
        return res.toString();
    }

    public static void main(String[] args){
        System.out.println(new Leetcode43().multiply("9","9"));
    }

}
