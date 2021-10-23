package interview;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Problem17_13 {

    public int respace(String[] dictionary, String sentence) {
        Set<String> set=new HashSet<>(Arrays.asList(dictionary));

        int[] res=new int[sentence.length()+1];
        for(int i=1;i<=res.length;i++)
            res[i]=i;

        for(int i=1;i<res.length;i++){
            for(int j=0;j<i;j++){
                if(set.contains(sentence.substring(j,i)))
                    res[i]=Math.min(res[i],res[j]);
            }
        }

        return res[sentence.length()];
    }
}
