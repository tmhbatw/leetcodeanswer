package leetcode5;

import java.util.List;
import java.util.Locale;

public class Leetcode422 {
    /*Description
    * 给你一个单词序列，判断其是否形成了一个有效的单词方块。
    * 有效的单词方块是指此由单词序列组成的文字方块的第 k 行
    * 和第 k 列 (0 ≤ k < max(行数, 列数)) 所显示的字符串完全相同。
    * */

    public boolean validWordSquare(List<String> words) {
        if(words==null||words.size()==0||words.get(0).length()==0)
            return true;
        int size=words.size();
        for(String cur:words){
            if(cur.length()>size)
                return false;
        }
        char[][] array=changeToArray(words);
        for(int i=0;i<size-1;i++){
            for(int j=i+1;j<size;j++){
                if(array[i][j]!=array[j][i])
                    return false;
            }
        }
        return true;
    }

    private char[][] changeToArray(List<String> words){
        int size=words.size();
        char[][] res=new char[size][size];
        for(int i=0;i<size;i++) {
            String cur=words.get(i);
            for(int j=0;j<cur.length();j++)
                res[i][j]=cur.charAt(j);
        }
        return res;
    }
}
