package leetcode.leetcode14;

public class Leetcode1332 {
    public int removePalindromeSub(String s) {
        return isPalindrome(s)?1:2;
    }

    boolean isPalindrome(String s){
        for(int i=0;i<s.length()/2;i++){
            if(s.charAt(i)!=s.charAt(s.length()-1-i))
                return false;
        }
        return true;
    }
}
