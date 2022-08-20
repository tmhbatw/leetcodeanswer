package leetcode.leetcode8;

import java.util.ArrayList;
import java.util.List;

public class Leetcode792 {

    public int numMatchingSubseq(String s, String[] words) {
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<26;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<s.length();i++){
            list.get(s.charAt(i)-'a').add(i);
        }

        int result=0;
        for(String word:words){
            result+=match(word,list);
        }
        return result;
    }

    private int match(String word,List<List<Integer>> list){
        int pre=-1;
        for(char cur:word.toCharArray()){
            pre=getRes(pre,list.get(cur-'a'))+1;
            if(pre==-1)
                return 0;
        }
        return 1;
    }

    private int getRes(int pre,List<Integer> list){
        if(list.size()==0||pre>list.get(list.size()-1))
            return -2;
        int l=0,r=list.size()-1;
        while(l<r){
            int mid=(l+r)/2;
            if(list.get(mid)>=pre){
                r=mid;
            }else{
                l=mid+1;
            }
        }
        return list.get(l);
    }


}
