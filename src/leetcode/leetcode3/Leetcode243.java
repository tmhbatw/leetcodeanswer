
package leetcode.leetcode3;

public class Leetcode243 {
    /*Description
     * 给定一个单词列表和两个单词 word1 和 word2，返回列表中这两个单词之间的最短距离。
     * */

    public int shortestDistance(String[] words, String word1, String word2) {
        int count1=-1;
        int count2=-1;
        int result=Integer.MAX_VALUE;
        for(int i=0;i<words.length;i++){
            if(words[i].equals(word1)){
                if(count2!=-1)
                    result=Math.min(i-count2,result);
                count1=i;
            }
            else if(words[i].equals(word2)){
                if(count1!=-1)
                    result=Math.min(i-count1,result);
                count2=i;
            }
        }
        return result;
    }
}