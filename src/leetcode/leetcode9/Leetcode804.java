package leetcode.leetcode9;

import java.util.HashSet;
import java.util.Set;

public class Leetcode804 {
    /*
    *
    * */

    public int uniqueMorseRepresentations(String[] words) {
        String[] s=new String[]{".-","-...","-.-.","-..",".","..-.","--.",
                "....","..",".---","-.-",".-..","--","-.","---",".--."
                ,"--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> set=new HashSet<>();
        for(String word:words){
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<word.length();i++){
                sb.append(s[word.charAt(i)-'a']);
            }
            set.add(sb.toString());
        }
        return set.size();
    }
}
