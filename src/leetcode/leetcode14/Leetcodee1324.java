package leetcode.leetcode14;

import java.util.ArrayList;
import java.util.List;

public class Leetcodee1324 {
    public List<String> printVertically(String s) {
        String[] word=s.split(" ");
        int row=0;
        for(String w:word)
            row=Math.max(w.length(),row);

        char[][] res=new char[row][word.length];
        for(int j=0;j<word.length;j++){
            for(int i=0;i<word[j].length();i++){
                res[i][j]=word[j].charAt(i);
            }
        }

        List<String> result=new ArrayList<>();
        for(char[] c:res){
            StringBuilder sb=new StringBuilder();
            for(char cc:c){
                if(cc=='\u0000')
                    sb.append(' ');
                else
                    sb.append(cc);
            }
            int remove=sb.length()-1;
            while(sb.charAt(remove)==' ')
                remove--;
            result.add(sb.substring(0,remove+1));
        }

        return result;
    }
}
