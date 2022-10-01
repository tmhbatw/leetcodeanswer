package leetcode.leetcode10;

import java.util.HashMap;
import java.util.Map;

public class Leetcode966 {

    public String[] spellchecker(String[] wordlist, String[] queries) {
        Map<String,String> map1=new HashMap<>();
        Map<String,String> map2=new HashMap<>();
        Map<String,String> map3=new HashMap<>();

        for(String word:wordlist){
            map1.put(word,word);
            String lowerCase=word.toLowerCase();
            String vowel="";
            for(char c:lowerCase.toCharArray()){
                if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u')
                    vowel+="*";
                else
                    vowel+=c;
            }
            map2.putIfAbsent(lowerCase,word);
            map3.putIfAbsent(vowel,word);
        }

        String[] result=new String[queries.length];
        for(int i=0;i<result.length;i++){
            if(map1.containsKey(queries[i]))
                result[i]=queries[i];
            else{
                String lower=queries[i].toLowerCase();
                if(map2.containsKey(lower))
                    result[i]=map2.get(lower);
                else{
                    String vowel="";
                    for(char c:lower.toCharArray()){
                        if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u')
                            vowel+="*";
                        else
                            vowel+=c;
                    }
                    result[i]=map3.getOrDefault(vowel,"");
                }
            }
        }
        return result;
    }

}
