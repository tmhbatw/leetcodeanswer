package interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Problem16_20 {
    /*Description
    * 在老式手机上，用户通过数字键盘输入，手机将提供与这些数字相匹配的单词列表。每个数字映射到0至4个字母。
    * 给定一个数字序列，实现一个算法来返回匹配单词的列表。你会得到一张含有有效单词的列表。
    * */

    char[][] c=new char[10][];
    {
        c[2]="abc".toCharArray();
        c[3]="def".toCharArray();
        c[4]="ghi".toCharArray();
        c[5]="jkl".toCharArray();
        c[6]="mno".toCharArray();
        c[7]="pqrs".toCharArray();
        c[8]="tuv".toCharArray();
        c[9]="wxyz".toCharArray();
    }
    public List<String> getValidT9Words(String num, String[] words) {
        List<String> result=new ArrayList<>();
        for(String cur:words){
            if(match(num,cur))
                result.add(cur);
        }
        return result;
    }

    private boolean match(String num,String cur) {
        if(num.length()!=cur.length())
            return false;
        for(int i=0;i<cur.length();i++){
            char curr=cur.charAt(i);
            char[] c=this.c[num.charAt(i)-'0'];
            boolean flag=false;
            for(int j=0;j<c.length;j++){
                if(c[j]==curr)
                    flag=true;
            }
            if(!flag)
                return false;
        }
        return true;
    }
}
