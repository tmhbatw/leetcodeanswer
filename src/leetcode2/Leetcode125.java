package leetcode2;

import java.util.Locale;

public class Leetcode125 {
    /*Description
    * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
    * 说明：本题中，我们将空字符串定义为有效的回文串。
    * */

    public boolean isPalindrome(String s) {
        s=s.toLowerCase();
        int left=0,right=s.length()-1;
        while(left<right){
            if(!isValid(s.charAt(left)))
                left++;
            else if(!isValid(s.charAt(right)))
                right--;
            else{
                if(s.charAt(left)!=s.charAt(right))
                    return false;
                left++;
                right--;
            }
        }
        return true;
    }

    private boolean isValid(char cur){
        return cur<='9'&&cur>='0'||cur<='z'&&cur>='a';
    }
}
