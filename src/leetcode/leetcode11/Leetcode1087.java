package leetcode.leetcode11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Leetcode1087 {
    String[] res;
    int i=0;

    public String[] expand(String s) {
        List<List<String>> list=new ArrayList<>();
        int length=s.length();
        int base=1;
        for(int i=0;i<length;i++){
            List<String> l=new ArrayList<>();

            if(s.charAt(i)=='{'){
                StringBuilder sb=new StringBuilder();
                while(i<length-1&&s.charAt(i+1)!='}'){
                    sb.append(s.charAt(++i));
                }
                i++;
                String[] ss=sb.toString().split(",");
                l.addAll(Arrays.asList(ss));
                Collections.sort(l);

                base*=l.size();
            }else{
                StringBuilder sb=new StringBuilder();
                while(i<length&&s.charAt(i)!='{'){
                    sb.append(s.charAt(i++));
                }
                i--;
                l.add(sb.toString());
            }
            list.add(l);
        }

        this.res=new String[base];
        dfs(0,list,new StringBuilder());
        return res;
    }

    private void dfs(int index,List<List<String>> list,StringBuilder sb){
        if(index==list.size()){
            res[i++]=sb.toString();
            return;
        }

        List<String> l=list.get(index);
        for(String s:l){
            StringBuilder newSb=new StringBuilder(sb);
            newSb.append(s);
            dfs(index+1,list,newSb);
        }
    }
}
