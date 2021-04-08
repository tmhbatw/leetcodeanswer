package leetcode.leetcode8;

import java.util.*;

public class Leetcode734 {
    /*Description
    *给定两个句子 words1, words2 （每个用字符串数组表示），和一个相似单词对的列表 pairs ，判断是否两个句子是相似的。
    * 例如，当相似单词对是 pairs = [["great", "fine"], ["acting","drama"], ["skills","talent"]]的时候，
    * "great acting skills" 和 "fine drama talent" 是相似的。
    * 注意相似关系是不具有传递性的。例如，如果 "great" 和 "fine" 是相似的，"fine" 和 "good" 是相似的，
    * 但是 "great" 和 "good" 未必是相似的。
    * 但是，相似关系是具有对称性的。例如，"great" 和 "fine" 是相似的相当于 "fine" 和 "great" 是相似的。
    * 而且，一个单词总是与其自身相似。例如，句子 words1 = ["great"], words2 = ["great"], pairs = [] 是相似的，尽管没有输入特定的相似单词对。
    * 最后，句子只会在具有相同单词个数的前提下才会相似。所以一个句子 words1 = ["great"] 永远不可能和句子 words2 = ["doubleplus","good"] 相似。
    * */

    public boolean areSentencesSimilar(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        if(sentence1.length!=sentence2.length){
            return false;
        }
        Map<String, Set<String>> map=new HashMap<>();
        for(List<String> list:similarPairs){
            Set<String> set=map.getOrDefault(list.get(0),new HashSet<>());
            set.add(list.get(1));
            map.put(list.get(0),set);
        }
        for(int i=0;i<sentence1.length;i++){
            if(sentence1[i].equals(sentence2[i])||map.getOrDefault(sentence1[i],new HashSet<>()).contains(sentence2[i])
                ||map.getOrDefault(sentence2[i],new HashSet<>()).contains(sentence1[i]))
                continue;
            return false;
        }
        return true;
    }
}
