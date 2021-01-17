package leetcode3;

import java.util.HashMap;
import java.util.Map;

public class Leetcode290 {
    /*Description
    * 给定一种规律 pattern和一个字符串str，判断 str 是否遵循相同的规律。
    * 这里的遵循指完全匹配，例如，pattern里的每个字母和字符串str中的每个非空单词之间存在着双向连接的对应规律。
    * */

    public boolean wordPattern(String pattern, String s) {
        String[] word=s.split(" ");
        if(pattern.length()!=word.length)
            return false;
        Map<Character,String> map1=new HashMap<>();
        Map<String,Character> map2=new HashMap<>();
        for(int i=0;i<pattern.length();i++){
            char cur=pattern.charAt(i);
            if(map1.containsKey(cur)&&map2.containsKey(word[i])){
                if(!map1.get(cur).equals(word[i])||map2.get(word[i])!=cur)
                    return false;
            }
            else if(map1.containsKey(cur)||map2.containsKey(word[i]))
                return false;
            map1.put(cur,word[i]);
            map2.put(word[i],cur);
        }
        return true;
    }
}
