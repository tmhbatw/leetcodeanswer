package interview;

public class Problem10_5 {
    /*Description
    * 稀疏数组搜索。有个排好序的字符串数组，其中散布着一些空字符串，
    * 编写一种方法，找出给定字符串的位置。
    * */

    public int findString(String[] words, String s) {
        for(int i=0;i<words.length;i++){
            if(words[i].equals(s))
                return i;
        }
        return -1;
    }
}
