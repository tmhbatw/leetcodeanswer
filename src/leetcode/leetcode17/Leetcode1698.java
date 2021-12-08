package leetcode.leetcode17;

import java.util.HashSet;
import java.util.Set;

public class Leetcode1698 {

    public int countDistinct(String s) {
        Set<String> set=new HashSet<>();
        for(int i=0;i<s.length();i++){
            StringBuilder sb=new StringBuilder();
            for(int j=i;j<s.length();j++){
                sb.append(s.charAt(j));
                set.add(sb.toString());
            }
        }
        return set.size();
    }
}
