package leetcode.leetcode9;

import java.util.ArrayList;
import java.util.List;

public class Leetcode809 {

    public int expressiveWords(String s, String[] words) {
        List<Character> c=new ArrayList<>();
        List<Integer> l=new ArrayList<>();
        reverse(s,c,l);

        int result=0;
        for(String word:words){
            List<Character> curC=new ArrayList<>();
            List<Integer> curL=new ArrayList<>();
            reverse(word,curC,curL);

            if(curC.size()!=c.size())
                continue;
            boolean add=true;
            for(int i=0;i<curC.size();i++){
                if(curC.get(i)!=c.get(i)||curL.get(i)>l.get(i)||curL.get(i)<l.get(i)&&l.get(i)<3){
                    add=false;
                    break;
                }
            }
            result+=add?1:0;
        }
        return result;
    }

    private void reverse(String s, List<Character> c,List<Integer> l){
        for(int i=0;i<s.length();i++){
            int start=i;
            while(i<s.length()-1&&s.charAt(i+1)==s.charAt(i)){
                i++;
            }
            c.add(s.charAt(i));
            l.add(i-start+1);
        }
    }
}
