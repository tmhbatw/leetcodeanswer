package leetcode4;

public class Leetcode389 {
    /*Description
    * 给定两个字符串 s 和 t，它们只包含小写字母。
    * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
    * 请找出在 t 中被添加的字母。
    * */

    public char findTheDifference(String s, String t) {
        int[] number=new int[26];
        for(int i=0;i<t.length();i++){
            number[t.charAt(i)-'a']++;
        }
        for(int i=0;i<s.length();i++){
            number[s.charAt(i)-'a']--;
        }
        for(int i=0;i<26;i++)
            if(number[i]==1)
                return (char)(i+'a');
            return 'a';
    }
}
