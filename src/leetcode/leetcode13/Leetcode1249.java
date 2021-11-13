package leetcode.leetcode13;

import java.util.ArrayList;
import java.util.List;

public class Leetcode1249 {


    public String minRemoveToMakeValid(String s) {
        char[] c=s.toCharArray();
        boolean[] reached=new boolean[c.length];
        List<Integer> list=new ArrayList<>();

        int count=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                count++;
                list.add(i);
            }else if(s.charAt(i)==')'){
                count--;
                if(count<0){
                    count++;
                    reached[i]=true;
                }
            }
        }
        for(int j=list.size()-1;j>=list.size()-count;j--)
            reached[list.get(j)]=true;
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<reached.length;i++){
            if(!reached[i])
                sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
