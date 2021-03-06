package interview;

import java.util.HashMap;
import java.util.Map;

public class Problem16_2 {
    /*Description
    * 设计一个方法，找出任意指定单词在一本书中的出现频率。
    * 你的实现应该支持如下操作：
    * WordsFrequency(book)构造函数，参数为字符串数组构成的一本书
    * get(word)查询指定单词在书中出现的频率
    * */

    class WordsFrequency {
        Map<String,Integer> map=new HashMap<>();

        public WordsFrequency(String[] book) {
            for(String cur:book)
                map.put(cur,map.getOrDefault(cur,0)+1);
        }

        public int get(String word) {
            return map.getOrDefault(word,0);
        }
    }
}
