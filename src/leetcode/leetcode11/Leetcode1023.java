package leetcode.leetcode11;

import java.util.ArrayList;
import java.util.List;

public class Leetcode1023 {

    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> result=new ArrayList<>();
        for(String q:queries)
            result.add(isMatch(q,pattern));
        return result;
    }

    private boolean isMatch(String query,String p){
        int index2=0;
        for(int i=0;i<query.length();i++){
            char c=query.charAt(i);
            if(index2<p.length()&&c==p.charAt(index2))
                index2++;
            else if(c<='Z'&&c>='A')
                return false;
        }
        return index2==p.length();
    }
}
