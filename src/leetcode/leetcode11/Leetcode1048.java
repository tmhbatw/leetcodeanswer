package leetcode.leetcode11;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Leetcode1048 {

    int result = 0;

    public int longestStrChain(String[] words) {
        List<List<String>> l=new ArrayList<>();
        for(int i=0;i<17;i++)
            l.add(new ArrayList<>());
        for(String w:words){
            l.get(w.length()).add(w);
        }

        List<Integer> time=new ArrayList<>();
        for(int i=1;i<l.size();i++){
            if(i==1){
                for(String s:l.get(1)){
                    time.add(1);
                    result=1;
                }
            }
            else{
                time = getRes(l.get(i-1),l.get(i),time);
            }
        }
        return result;
    }

    private List<Integer> getRes(List<String> l,List<String> l2,List<Integer> time){
        List<Integer> result=new ArrayList<>();
        for(String s2:l2){
            int cur=1;
            for(int i=0;i<l.size();i++){
                if(match(s2,l.get(i))){
                    cur=Math.max(time.get(i)+1,cur);
                }
            }
            result.add(cur);
            this.result=Math.max(this.result,cur);
        }
        return result;
    }

    private boolean match(String s1,String s2){
        int j=0;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)==s2.charAt(j))
                j++;
            if(j==s2.length())
                return true;
        }
        return j==s2.length();
    }

}
