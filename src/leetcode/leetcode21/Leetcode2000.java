package leetcode.leetcode21;

public class Leetcode2000 {

    public String reversePrefix(String word, char ch) {
        int index=0;
        for(;index<word.length();index++){
            if(word.charAt(index)==ch)
                break;
        }
        if(index==word.length())
            return word;
        return new StringBuilder(word.substring(0,index+1)).reverse()+word.substring(index+1);
    }
}
