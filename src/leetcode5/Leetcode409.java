package leetcode5;

public class Leetcode409 {
    /*Description
    * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
    * 在构造过程中，请注意区分大小写。比如"Aa"不能当做一个回文字符串。
    * 注意:假设字符串的长度不会超过 1010。
    * */

    public int longestPalindrome(String s) {
        int[] time=new int[128];
        for(int i=0;i<s.length();i++)
            time[s.charAt(i)]++;
        int result=0;
        for(int i=0;i<128;i++)
            result+=time[i]/2*2;
        if(result<s.length())
            result++;
        return result;
    }
}
