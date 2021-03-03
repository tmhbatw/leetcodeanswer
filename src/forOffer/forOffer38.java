package forOffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class forOffer38 {
    /*Description
    * 输入一个字符串，打印出该字符串中字符的所有排列。
    * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
    *    * */

    public String[] permutation(String s) {
        char[] c=s.toCharArray();
        Arrays.sort(c);
        int length=s.length();
        List<String> list=new ArrayList<>();
        boolean[] reached=new boolean[c.length];
        dfs(list,c,reached,"",0,length);
        String[] res=new String[list.size()];
        for(int i=0;i<list.size();i++)
            res[i]=list.get(i);
        return res;
    }

    private void dfs(List<String> list,char[] c,boolean[] reached,String cur,int index,int length){
        if(index==length){
            list.add(cur);
            return;
        }
        char pre=' ';
        for(int i=0;i<length;i++){
            if(!reached[i]){
                if(pre==c[i])
                    continue;
                pre=c[i];
                reached[i]=true;
                dfs(list,c,reached,cur+c[i],index+1,length);
                reached[i]=false;
            }
        }
    }
}
