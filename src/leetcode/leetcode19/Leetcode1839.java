package leetcode.leetcode19;

public class Leetcode1839 {

    //aeiou
    public int longestBeautifulSubstring(String word) {
        int result=0;
        int length=word.length();

        for(int i=0;i<length;i++){
            if(word.charAt(i)=='a'){
                int start=i;
                char pre='a';
                while(i<length-1&&isTrue(word.charAt(i+1),pre))
                    pre=word.charAt(++i);
                if(pre=='u'){
                    result=Math.max(result,i-start+1);
                }
            }
        }
        return result;
    }

    private boolean isTrue(char next, char cur){
        switch (next){
            case 'a':
                return cur=='a';
            case 'e':
                return cur=='a'||cur=='e';
            case 'i':
                return cur=='e'||cur=='i';
            case 'o':
                return cur=='i'||cur=='o';
            case 'u':
                return cur=='o'||cur=='u';
        }
        return false;
    }
}
