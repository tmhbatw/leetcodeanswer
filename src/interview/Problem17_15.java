package interview;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Problem17_15 {

    public String longestWord(String[] words) {
        Set<String> set=new HashSet<>(Arrays.asList(words));
        Arrays.sort(words,(o1,o2)->{
            return o2.length()-o1.length();
        });

        for(String cur:words){
            boolean[] reached=new boolean[cur.length()+1];
            reached[0]=true;
            for(int i=1;i<=reached.length;i++){
                for(int j=0;j<i;j++){
                    if(i==reached.length&&j==0)
                        continue;
                    if(reached[j]&&set.contains(cur.substring(j,i))) {
                        reached[i] = true;
                        break;
                    }
                }
            }
            if(reached[cur.length()])
                return cur;
        }
        return "";
    }
}
