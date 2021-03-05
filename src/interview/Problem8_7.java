package interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Problem8_7 {
    /*Description
    * 无重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合，字符串每个字符均不相同。
    * */

    List<String> result;
    char[] c;
    public String[] permutation(String S) {
        result=new ArrayList<>();
        c=S.toCharArray();
        dfs(0);
        String[] res=new String[result.size()];
        for(int i=0;i<result.size();i++)
            res[i]=result.get(i);
        return res;
    }

    private void dfs(int index){
        if(index==c.length){
            result.add(new String(c));
            return;
        }
        for(int i=index+1;i<c.length;i++){
            char temp=c[index];
            c[index]=c[i];
            c[i]=temp;
            dfs(index+1);
            c[i]=c[index];
            c[index]=temp;
        }
        dfs(index+1);
    }
}
