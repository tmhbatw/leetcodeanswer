package leetcode3;

public class Leetcode242 {
    /*Description
    * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
    * */

    public boolean isAnagram(String s, String t) {
        if(s==null&&t==null)
            return true;
        if(s==null||t==null)
            return false;
        if(s.length()!=t.length())
            return false;
        int[] num=new int[26];
        for(int i=0;i<s.length();i++){
            num[s.charAt(i)-'a']++;
            num[t.charAt(i)-'a']--;
        }
        for(int i=0;i<26;i++){
            if(num[i]!=0)
                return false;
        }
        return true;
    }
}
