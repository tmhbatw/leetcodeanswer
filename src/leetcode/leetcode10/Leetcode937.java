package leetcode.leetcode10;

import java.util.Arrays;

public class Leetcode937 {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs,(o1,o2)->{
            if(isLetter(o1)&&isLetter(o2)) {
                if(getS(o1).equals(getS(o2)))
                    return o1.compareTo(o2);
                return getS(o1).compareTo(getS(o2));
            }
            if(isLetter(o1))
                return -1;
            if(isLetter(o2))
                return 1;
            return 0;
        });
        return logs;
    }

    private String getS(String s){
        int spaceNumber=s.indexOf(" ");
        return s.substring(spaceNumber+1);
    }

    private boolean isLetter(String cur){
        String[] s=cur.split(" ");
        return s[1].charAt(0)>'9'||s[1].charAt(0)<'0';
    }
}
