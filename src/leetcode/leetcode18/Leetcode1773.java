package leetcode.leetcode18;

import java.util.List;

public class Leetcode1773 {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int index=0;
        switch (ruleKey){
            case "color":
                index=1;
                break;
            case "name":
                index=2;
                break;
        }
        int count=0;
        for(List<String> cur:items){
            if(cur.get(index).equals(ruleValue))
                count++;
        }
        return count;
    }
}
