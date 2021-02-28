package leetcode8;

import java.util.HashSet;
import java.util.Set;

public class Leetcode720 {
    /*Description
    * 给出一个字符串数组words组成的一本英语词典。从中找出最长的一个单词，该单词是由words词典中其他单词逐步添加一个字母组成。
    * 若其中有多个可行的答案，则返回答案中字典序最小的单词。
    * 若无答案，则返回空字符串。
    * */

    public String longestWord(String[] words) {
        Set<String> set=new HashSet<>();
        for(String cur:words)
            set.add(cur);
        String res="";
        for(String curr:words){
            for(int i=1;i<=curr.length();i++){
                if(!set.contains(curr.substring(0,i)))
                    break;
                if(i==curr.length()) {
                    if (curr.length() > res.length() || curr.length() == res.length() && curr.compareTo(res) < 0)
                        res = curr;
                }
            }
        }
        return res;
    }
}
