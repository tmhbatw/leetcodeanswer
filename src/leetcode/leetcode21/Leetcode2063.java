package leetcode.leetcode21;

public class Leetcode2063 {

    public long countVowels(String word) {
        long result=0;
        for(int i=0;i<word.length();i++){
            char c=word.charAt(i);
            if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u'){
                result += (long)(i+1)*(word.length()-i);
            }
        }

        return result;
    }
}
