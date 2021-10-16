package leetcode.leetcode17;

import java.util.ArrayList;
import java.util.List;

public class Leetcode1656 {

    class OrderedStream {

        String[] s;
        int index;
        public OrderedStream(int n) {
            s=new String[n+1];
            index=1;
        }

        public List<String> insert(int idKey, String value) {
            s[idKey]=value;
            List<String> result=new ArrayList<>();
            if(idKey==index){
                for(;index<s.length;index++){
                    if(s[index]==null)
                        break;
                    result.add(s[index]);
                }
            }
            return result;
        }
    }
}
