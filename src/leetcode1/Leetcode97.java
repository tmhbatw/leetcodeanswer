package leetcode1;

public class Leetcode97 {
    /*Description
    * 给定三个字符串s1、s2、s3，请你帮忙验证s3是否是由s1和s2 交错 组成的。
    * 两个字符串 s 和 t 交错 的定义与过程如下，其中每个字符串都会被分割成若干 非空 子字符串：
    * s = s1 + s2 + ... + sn
    * t = t1 + t2 + ... + tm
    * 其中|n - m| <= 1
    * 交错 是 s1 + t1 + s2 + t2 + s3 + t3 + ... 或者 t1 + s1 + t2 + s2 + t3 + s3 + ...
    * 提示：a + b 意味着字符串 a 和 b 连接。
    * */

    //尝试一下贪心算法
    public boolean isInterleave(String s1, String s2, String s3) {
        int length1=s1.length(),length2=s2.length(),length3=s3.length();
        if(!isMatch(s1,s2,s3))
            return false;
        if(recursion(s1.toCharArray(),0,s2.toCharArray(),0,s3.toCharArray(),0)||
            recursion(s2.toCharArray(),0,s1.toCharArray(),0,s3.toCharArray(),0))
            return true;
        return false;
    }

    private boolean recursion(char[] s1,int index1,char[] s2,int index2,char[] s3,int index){
        if(index==s3.length)
            return true;
        if(index1==s1.length||s1[index1]!=s3[index])
            return false;
        //如果s2已经全部用完了，那么直接对s1与s3进行匹配
        if(index2==s2.length){
            while(index1<s1.length){
                if(s1[index1++]!=s3[index++])
                    return false;
            }
            return true;
        }
        char cur2=s2[index2];
        while(index1<s1.length&&index<s3.length&&s1[index1]==s3[index]){
            if(s3[index+1]==cur2&&recursion(s2,index2,s1,index1+1,s3,index+1))
                return true;
            index1++;
            index++;
        }
        return false;
    }

    private boolean isMatch(String s1, String s2, String s3){
        int[] num=new int[26];
        for(int i=0;i<s3.length();i++)
            num[s3.charAt(i)-'a']++;
        for(int i=0;i<s1.length();i++)
            num[s1.charAt(i)-'a']--;
        for(int i=0;i<s2.length();i++)
            num[s2.charAt(i)-'a']--;
        for(int i=0;i<26;i++){
            if(num[i]!=0)
                return false;
        }
        return true;
    }
}
