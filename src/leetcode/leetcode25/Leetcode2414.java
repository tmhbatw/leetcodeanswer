package leetcode.leetcode25;

public class Leetcode2414 {

    public int longestContinuousSubstring(String s) {
        int result=1;
        int cur = 1;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)-s.charAt(i-1)==1)
                cur++;
            else{
                result=Math.max(result,cur);
                cur=1;
            }
            // System.out.println(cur);
        }
        return Math.max(result,cur);
    }

}
