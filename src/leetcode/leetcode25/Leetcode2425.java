package leetcode.leetcode25;

import java.util.HashSet;
import java.util.Set;

public class Leetcode2425 {

    class LUPrefix {

        Set<Integer> set;
        int result=0;
        public LUPrefix(int n) {
            this.set=new HashSet<>();
        }

        public void upload(int video) {
            if(video==result+1){
                result++;
                while(set.contains(result+1)){
                    set.remove(++result);
                }
            }else
                set.add(video);
        }

        public int longest() {
            return result;
        }
    }


}
