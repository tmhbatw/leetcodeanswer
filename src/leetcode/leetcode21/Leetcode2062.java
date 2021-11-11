package leetcode.leetcode21;

import java.util.HashMap;
import java.util.Map;

public class Leetcode2062 {

    public int countVowelSubstrings(String word) {
        int count=0;
        for(int i=0;i<word.length();i++){
            Map<Character,Integer> map=new HashMap<>();
            for(int j=i;j<word.length();j++){
                if(!isChar(word.charAt(j)))
                    break;
                map.put(word.charAt(j),map.getOrDefault(word.charAt(j),0)+1);
                if(map.size()==5)
                    count++;
            }
        }
        return count;
    }

    private boolean isChar(char cur){
        return cur=='a'||cur=='e'||cur=='i'||cur=='o'||cur=='u';
    }
}
