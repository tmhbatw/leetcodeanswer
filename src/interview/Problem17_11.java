package interview;

public class Problem17_11 {
    /*Description
    * 有个内含单词的超大文本文件，给定任意两个单词，找出在这个文件中这两个单词的最短距离(相隔单词数)。
    * 如果寻找过程在这个文件中会重复多次，而每次寻找的单词不同，你能对此优化吗?
    * */

    public int findClosest(String[] words, String word1, String word2) {
        int pre1=-1,pre2=-1;
        int result=Integer.MAX_VALUE;
        for(int i=0;i<words.length;i++){
            if(words[i].equals(word1)){
                if(pre2!=-1){
                    result=Math.min(result,i-pre2);
                }
                pre1=i;
            }
            if(words[i].equals(word2)){
                if(pre1!=-1){
                    result=Math.min(result,i-pre1);
                }
                pre2=i;
            }
        }
        return result;
    }
}
