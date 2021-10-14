package leetcode.leetcode11;

import java.util.ArrayList;
import java.util.List;

public class Leetcode1078 {
    public String[] findOcurrences(String text, String first, String second) {
        String[] t=text.split(" ");
        int length=t.length;
        List<String> result=new ArrayList<>();

        for(int i=0;i<length-2;i++){
            if(t[i].equals(first)&&t[i+1].equals(second)){
                result.add(t[i+2]);
            }
        }

        String[] res=new String[result.size()];
        for(int i=0;i<res.length;i++)
            res[i]=result.get(i);
        return res;
    }
}
