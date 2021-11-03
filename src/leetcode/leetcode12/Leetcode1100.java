package leetcode.leetcode12;

public class Leetcode1100 {

    public int numKLenSubstrNoRepeats(String s, int k) {
        int[] num=new int[26];
        int result=0;
        for(int i=0;i<s.length();i++){
            num[s.charAt(i)-'a']++;
            if(i<k-1)
                continue;
            if(isMatch(num))
                result++;
            num[s.charAt(i-k+1)-'a']--;
        }
        return result;
    }

    private boolean isMatch(int[] num){
        for (int j : num) {
            if (j > 1)
                return false;
        }
        return true;
    }
}
