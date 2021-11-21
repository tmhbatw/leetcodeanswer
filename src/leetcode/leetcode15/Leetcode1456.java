package leetcode.leetcode15;

public class Leetcode1456 {

    public int maxVowels(String s, int k) {
        int max=0;
        int count=0;

        for(int i=0;i<s.length();i++){
            if(isMatchChar(s.charAt(i)))
                count++;
            if(i<k-1)
                continue;

            max=Math.max(count,max);
            if(isMatchChar(s.charAt(i-k+1)))
                count--;
        }
        return max;
    }

    private boolean isMatchChar(char cur){
        return cur=='a'||cur=='e'||cur=='i'||cur=='o'||cur=='u';
    }

}
