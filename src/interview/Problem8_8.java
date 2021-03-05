package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem8_8 {
    /*Description
    * 有重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合。
    * */

    char[] c;
    boolean[] reached;
    List<String> result;
    int length;
    public String[] permutation(String S) {
        c=S.toCharArray();
        Arrays.sort(c);
        reached=new boolean[c.length];
        result=new ArrayList<>();
        this.length=S.length();
        dfs(0,new StringBuilder());
        String[] res=new String[result.size()];
        for(int i=0;i<result.size();i++)
            res[i]=result.get(i);
        return res;
    }

    private void dfs(int index,StringBuilder sb){
        if(index==length){
            result.add(sb.toString());
            return;
        }
        char pre=' ';
        for(int i=0;i<length;i++){
            if(reached[i]||pre==c[i])
                continue;
            StringBuilder curSb=new StringBuilder();
            curSb.append(c[i]);
            pre=c[i];
            reached[i]=true;
            dfs(index+1,curSb);
            reached[i]=false;
        }
    }

}
