package interview;

import java.util.HashMap;
import java.util.Map;

public class Problem16_18 {

    /*Description
    * 你有两个字符串，即pattern和value。 pattern字符串由字母"a"和"b"组成，用于描述字符串中的模式。
    * 例如，字符串"catcatgocatgo"匹配模式"aabab"（其中"cat"是"a"，"go"是"b"），
    * 该字符串也匹配像"a"、"ab"和"b"这样的模式。但需注意"a"和"b"不能同时表示相同的字符串。编写一个方法判断value字符串是否匹配pattern字符串。
    * */

    Map<String,Character> map1;
    Map<Character,String> map2;
    boolean result=false;
    int patternLength;
    int valueLength;
    public boolean patternMatching(String pattern, String value) {
        map1=new HashMap<>();
        map2=new HashMap<>();
        patternLength=pattern.length();
        valueLength=value.length();
        dfs(pattern,0,value,0);
        return result;
    }

    private void dfs(String pattern,int index1,String value ,int index2){
        if(result)
            return;
        if(index1==patternLength&&index2==valueLength){
            result=true;
            return;
        }
        if(index1==patternLength||index2==valueLength)
            return;
        char curPattern=pattern.charAt(index1);
        if(map2.containsKey(curPattern)){
            String val=map2.get(curPattern);
            if(value.indexOf(val,index2)==index2){
                dfs(pattern,index1+1,value,index2+val.length());
            }
            return;
        }
        if(!map1.containsKey("")){
            map1.put("",curPattern);
            map2.put(curPattern,"");
            dfs(pattern,index1+1,value,index2+1);
            map1.remove("");
            map2.remove(curPattern);
        }
        if(map1.containsKey("")){
            if(map1.get("")==curPattern)
                dfs(pattern,index1+1,value,index2+1);
        }
        for(int j=index2+1;j<=valueLength;j++){
            String cur=value.substring(index2,j);
            if(map1.containsKey(cur))
                continue;
            map2.put(curPattern,cur);
            map1.put(cur,curPattern);
            dfs(pattern,index1+1,value,j);
            map1.remove(cur);
            map2.remove(curPattern);
        }
    }
}
