package leetcode.leetcode9;

import java.util.ArrayList;
import java.util.List;

public class Leetcode816 {

    public List<String> ambiguousCoordinates(String s) {
        List<String> result=new ArrayList<>();
        s=s.substring(1,s.length()-1);
        for(int i=1;i<s.length();i++){
            List<String> l1=getList(s.substring(0,i));
            List<String> l2=getList(s.substring(i));
            for(String s1:l1){
                for(String s2:l2){
                    result.add("("+s1+", "+s2+")");
                }
            }
        }
        return result;
    }

    private List<String> getList(String s){
        List<String> result=new ArrayList<>();
        if(s.equals("0")){
            result.add("0");
            return result;
        }
        if(s.charAt(0)=='0'){
            if(s.charAt(s.length()-1)=='0')
                return result;
            result.add("0."+s.substring(1));
            return result;
        }
        if(s.charAt(s.length()-1)=='0'){
            result.add(s);
            return result;
        }
        for(int i=1;i<s.length();i++){
            result.add(s.substring(0,i)+"."+s.substring(i));
        }
        return result;
    }
}
