package leetcode.leetcode7;

public class Leetcode680 {
    /*Description
    * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
    * */

    public boolean validPalindrome(String s) {
        int length=s.length();
        for(int i=0;i<length/2;i++){
            if(s.charAt(i)!=s.charAt(length-i-1)){
                return validPalindrome(s,i,length-i-2)
                        ||validPalindrome(s,i+1,length-i-1);
            }
        }
        return true;
    }

    private boolean validPalindrome(String s,int start,int end){
        while(start<end){
            if(s.charAt(start++)!=s.charAt(end--))
                return false;
        }
        return true;
    }
}
