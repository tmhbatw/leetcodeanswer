package leetcode.leetcode22;

public class Leetcode2108 {

    public String firstPalindrome(String[] words) {
        for(String cur:words){
            if(isPalindrome(cur))
                return cur;
        }
        return "";
    }

    private boolean isPalindrome(String cur){
        for(int i=0;i<cur.length()/2;i++){
            if(cur.charAt(i)!=cur.charAt(cur.length()-1-i))
                return false;
        }
        return true;
    }
}
