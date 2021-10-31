package leetcode.leetcode14;

public class Leetcode1347 {

    public int minSteps(String s, String t) {
        int[] num=new int[26];
        for(int i=0;i<s.length();i++){
            num[s.charAt(i)-'a']++;
        }

        int result=0;
        for(int i=0;i<t.length();i++){
            num[t.charAt(i)-'a']--;
            if(num[t.charAt(i)-'a']<0)
                result++;
        }
        return result;
    }
}
