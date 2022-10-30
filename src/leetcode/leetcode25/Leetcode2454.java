package leetcode.leetcode25;

import java.util.ArrayList;
import java.util.List;

public class Leetcode2454 {

    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> result=new ArrayList<>();
        for(String q:queries){
            for(String d:dictionary){
                if(isMatch(q,d)){
                    result.add(q);
                    break;
                }
            }
        }
        return result;
    }

    private boolean isMatch(String q,String d){
        int count=0;
        for(int i=0;i<q.length();i++){
            if(q.charAt(i)!=d.charAt(i)){
                count++;
                if(count>2)
                    return false;
            }
        }
        return true;
    }

}
