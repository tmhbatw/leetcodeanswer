package forOffer2;

import java.util.HashSet;
import java.util.Set;

public class ForOffer16 {

    public int lengthOfLongestSubstring(String s) {
        Set<Character> set=new HashSet<>();
        int j=0;
        int result=0;
        for(int i=0;i<s.length();i++){
            while(j<s.length()&&!set.contains(s.charAt(j)))
                set.add(s.charAt(j++));
            result=Math.max(result,j-i);
            set.remove(s.charAt(i));
        }
        return result;
    }
}
