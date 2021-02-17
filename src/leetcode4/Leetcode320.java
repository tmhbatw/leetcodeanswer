package leetcode4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leetcode320 {
    /*Description
    * 请你写出一个能够举单词全部缩写的函数。
    * */

    public List<String> generateAbbreviations(String word) {
        if(word==null||word.length()==0)
            return Collections.emptyList();
        List<String> result=generateAbbreviations(word,0,true);
        result.addAll(generateAbbreviations(word,0,false));
        return result;
    }

    private List<String> generateAbbreviations(String word,int start,boolean isNumber){
        List<String> result=new ArrayList<>();
        if(start==word.length()){
            result.add("");
            return result;
        }
        if(!isNumber) {
            for (int i = start; i < word.length(); i++) {
                String cur = word.substring(start, i + 1);
                List<String> list = generateAbbreviations(word, i + 1, true);
                for (String s : list)
                    result.add(cur + s);
            }
        }
        if(isNumber){
            for(int i=start;i<word.length();i++){
                List<String> list=generateAbbreviations(word,i+1,false);
                for(String cur:list)
                    result.add((i-start+1)+cur);
            }
        }
        return result;
    }
}
