package leetcode3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Leetcode288 {
    /*Description
    * 单词的 缩写 需要遵循 <起始字母><中间字母数><结尾字母> 这样的格式。如果单词只有两个字符，那么它就是它自身的 缩写 。
    * 以下是一些单词缩写的范例：
    * dog --> d1g 因为第一个字母 'd' 和最后一个字母 'g' 之间有 1 个字母
    * internationalization --> i18n 因为第一个字母 'i' 和最后一个字母 'n' 之间有 18 个字母
    * it --> it 单词只有两个字符，它就是它自身的 缩写
    * 实现 ValidWordAbbr 类：
    * ValidWordAbbr(String[] dictionary) 使用单词字典 dictionary 初始化对象
    * boolean isUnique(string word) 如果满足下述任意一个条件，返回 true ；否则，返回 false ：
    * 字典 dictionary 中没有任何其他单词的 缩写 与该单词 word 的 缩写 相同。
    * 字典 dictionary 中的所有 缩写 与该单词 word 的 缩写 相同的单词都与 word 相同 。
    * */

    class ValidWordAbbr {
        Map<String, Set<String>> map;
        public ValidWordAbbr(String[] dictionary) {
            map=new HashMap<>();
            for(String cur:dictionary){
                String val=getVal(cur);
                Set<String> set=map.getOrDefault(val,new HashSet<>());
                set.add(cur);
                map.put(val,set);
            }
        }

        private String getVal(String cur){
            String val;
            if(cur.length()<=2)
                val=cur;
            else
                val=cur.charAt(0)+""+(cur.length()-2)+cur.charAt(cur.length()-1);
            return val;
        }

        public boolean isUnique(String word) {
            String val=getVal(word);
            if(!map.containsKey(val))
                return true;
            Set<String> set=map.get(val);
            return set.size()==1&&set.iterator().next().equals(word);
        }
    }
}
