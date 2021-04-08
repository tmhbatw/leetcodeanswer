package leetcode.leetcode4;

import java.util.HashSet;
import java.util.Set;

public class Leetcode345 {
    /*Description
    *编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
    * */

    public String reverseVowels(String s) {
        String vowel="aoeiuAOEIU";
        Set<Character> set=new HashSet<>();
        for(int i=0;i<10;i++){
            set.add(vowel.charAt(i));
        }
        char[] sArray=s.toCharArray();
        int left=0,right=s.length()-1;
        while(left<right){
            if(!set.contains(sArray[left])){
                left++;
            }
            else if(!set.contains(sArray[right])){
                right--;
            }else {
               char temp=sArray[left];
               sArray[left++]=sArray[right];
               sArray[right--]=temp;
            }
        }
        return new String(sArray);
    }

}
