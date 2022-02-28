package leetcode.leetcode22;

public class Leetcode2186 {
    public int minSteps(String s, String t) {
        int[] num=new int[26];
        for(char c:s.toCharArray()){
           num[c-'a']++;
        }

        for(char c:t.toCharArray()){
            num[c-'a']--;
        }

        int result=0;
        for(int time:num){
            result+=Math.abs(time);
        }

        return result;
    }

}
