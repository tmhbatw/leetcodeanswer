package forOffer;

public class forOffer50 {
    /*Description
    * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
    * */

    public char firstUniqChar(String s) {
        int[] time=new int[26];
        for(int i=0;i<s.length();i++)
            time[s.charAt(i)-'a']++;
        for(int i=0;i<s.length();i++){
            if(time[s.charAt(i)-'a']==1)
                return s.charAt(i);
        }
        return ' ';
    }
}
