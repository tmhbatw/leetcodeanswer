package leetcode.leetcode3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode244 {
    /*Description
    * 请设计一个类，使该类的构造函数能够接收一个单词列表。然后再实现一个方法，该方法能够分别接收两个单词 word1和word2，
    * 并返回列表中这两个单词之间的最短距离。您的方法将被以不同的参数调用多次。
    * */

    class WordDistance {
        Map<String, List<Integer>> map;

        public WordDistance(String[] words) {
            map=new HashMap<>();
            for(int i=0;i<words.length;i++){
                List<Integer> list=map.getOrDefault(words[i],new ArrayList<>());
                list.add(i);
                map.put(words[i],list);
            }
        }

        public int shortest(String word1, String word2) {
            List<Integer> list1=map.get(word1);
            List<Integer> list2=map.get(word2);
            int index1=0,index2=0;
            int result=Integer.MAX_VALUE;
            while(index1<list1.size()&&index2<list2.size()){
                if(list1.get(index1)<list2.get(index2)){
                    result=Math.min(result,list2.get(index2)-list1.get(index1++));
                }else{
                    result=Math.min(result,list1.get(index1)-list2.get(index2++));
                }
            }
            return result;
        }
    }
}
