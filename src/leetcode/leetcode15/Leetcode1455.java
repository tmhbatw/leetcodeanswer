package leetcode.leetcode15;

public class Leetcode1455 {

    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] s=sentence.split(" ");
        for(int i=0;i<s.length;i++){
            if(s[i].indexOf(searchWord)==0)
                return i+1;
        }
        return -1;
    }
}
