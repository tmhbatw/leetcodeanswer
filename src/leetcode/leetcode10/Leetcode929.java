package leetcode.leetcode10;

import java.util.HashSet;
import java.util.Set;

public class Leetcode929 {
    public int numUniqueEmails(String[] emails) {

    Set<String> set=new HashSet<>();
        for(String cur:emails){
        String[] curr=cur.split("@");
        set.add(getChange(curr[0])+" "+curr[1]);
    }
        return set.size();
}

    private String getChange(String s){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            switch (s.charAt(i)){
                case '+':
                    i=s.length();
                case '.':
                    break;
                default:
                    sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
