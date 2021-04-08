package leetcode.leetcode6;

public class Leetcode567 {
    /*Description
    * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
    * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
    * */

    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length())
            return false;
        int[] num1=new int[26];
        for(int i=0;i<s1.length();i++)
            num1[s1.charAt(i)-'a']++;
        int[] num2=new int[26];
        for(int i=0;i<s1.length()-1;i++)
            num2[s2.charAt(i)-'a']++;
        for(int i=s1.length()-1;i<s2.length();i++){
            num2[s2.charAt(i)-'a']++;
            if(isMatch(num1,num2))
                return true;
            num2[s2.charAt(i-s1.length()+1)-'a']--;
        }
        return false;
    }

    private boolean isMatch(int[] num1,int[] num2){
        for(int i=0;i<26;i++){
            if(num1[i]!=num2[i])
                return false;
        }
        return true;
    }
}
