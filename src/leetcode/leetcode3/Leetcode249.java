package leetcode.leetcode3;

import java.util.ArrayList;
import java.util.List;

public class Leetcode249 {
    /*Description
    * 给定一个字符串，对该字符串可以进行 “移位” 的操作，也就是将字符串中每个字母都变为其在字母表中后续的字母，
    * 比如："abc" -> "bcd"。这样，我们可以持续进行 “移位” 操作，从而生成如下移位序列：
    * "abc" -> "bcd" -> ... -> "xyz"
    * 给定一个包含仅小写字母字符串的列表，将该列表中所有满足“移位” 操作规律的组合进行分组并返回。
    * */

    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> result=new ArrayList<>();
        if(strings==null||strings.length==0)
            return result;
        int length=strings.length;
        String[] dp=new String[length];
        for(int i=0;i<length;i++){
            dp[i]=change(strings[i]);
        }
        boolean[] reached=new boolean[length];
        for(int i=0;i<length;i++){
            if(reached[i])
                continue;
            List<String> list=new ArrayList<>();
            String cur=dp[i];
            list.add(strings[i]);
            for(int j=i+1;j<length;j++){
                if(!reached[j]&&dp[j].equals(cur)){
                    list.add(strings[j]);
                    reached[j]=true;
                }
            }
            result.add(list);
        }
        return result;
    }

    private String change(String cur){
        StringBuilder sb=new StringBuilder();
        sb.append('a');
        int diff=cur.charAt(0)-'a';
        for(int i=1;i<cur.length();i++){
            char curr=cur.charAt(i);
            curr=(char)(curr-diff);
            if(curr<'a')
                curr=(char)(curr+26);
            sb.append(curr);
        }
        return sb.toString();
    }
}
