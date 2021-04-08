package leetcode.leetcode1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode49 {
    /*Description
    *给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
    * */

    /*Solution
    * 可以用质数保存26个字母
    * */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap<>();
        for(String cur:strs){
            String time=getTime(cur);
            List<String> list=map.getOrDefault(time,new ArrayList<>());
            list.add(cur);
            map.put(time,list);
        }
        List<List<String>> result=new ArrayList<>();
        for(Map.Entry entry:map.entrySet()){
            result.add((List<String>)entry.getValue());
        }
        return result;
    }

    private String getTime(String cur){
        int[] curr=new int[26];
        for(int i=0;i<cur.length();i++){
            curr[cur.charAt(i)-'a']++;
        }
        StringBuilder sb=new StringBuilder();
        for(int time:curr)
            sb.append(time).append(" ");
        return sb.toString();
    }

    //比较暴力的解法
/*    public List<List<String>> groupAnagrams(String[] strs) {
        int length=strs.length;
        int[][] time=new int[length][27];
        for(int i=0;i<length;i++){
            time[i]=getTime(strs[i]);
        }
        List<List<String>> result=new ArrayList<>();
        boolean[] reached=new boolean[length];
        for(int i=0;i<length;i++){
            if(reached[i])
                continue;
            int[] cur=time[i];
            List<String> res=new ArrayList<>();
            res.add(strs[i]);
            for(int j=i+1;j<length;j++){
                if(reached[j]||cur[26]!=time[j][26])
                    continue;
                if(isSame(cur,time[j])){
                    res.add(strs[j]);
                    reached[j]=true;
                }
            }
            result.add(res);
        }
        return result;
    }

    private boolean isSame(int[] c1,int[] c2){
        for(int i=0;i<26;i++){
            if(c1[i]!=c2[i])
                return false;
        }
        return true;
    }

    private int[] getTime(String cur){
        int[] result=new int[27];
        for(int i=0;i<cur.length();i++){
            result[cur.charAt(i)-'0']++;
        }
        result[26]=cur.length();
        return result;
    }*/
}
