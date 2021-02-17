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
        return generateAbbreviations(word,0,true);
    }

    private List<String> generateAbbreviations(String word,int start,boolean isNumber){
        List<String> result=new ArrayList<>();
        if(start==word.length()-1){
            result.add("");
            return result;
        }
        char c=word.charAt(start);
        List<String> res=generateAbbreviations(word,start+1,true);
        for(String cur:res){
            result.add(c+cur);
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
