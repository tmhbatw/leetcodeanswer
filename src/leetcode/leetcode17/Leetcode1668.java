package leetcode.leetcode17;

import java.util.ArrayList;
import java.util.List;

public class Leetcode1668 {

    public int maxRepeating(String sequence, String word) {
        List<Integer> list=new ArrayList<>();
        int start=-1;
        while((start=sequence.indexOf(word,start+1))!=-1){
            list.add(start);
        }
        int result=0;
        for(int i=0;i<list.size();i++){
            int count=1;
            int pre=list.get(i);
            for(int j=i+1;j<list.size();j++){
                if(list.get(j)-pre==word.length()){
                    count++;
                    pre=list.get(j);
                }else if(list.get(j)-pre>word.length())
                    break;
            }
            result=Math.max(result,count);
        }
        return result;
    }
}
