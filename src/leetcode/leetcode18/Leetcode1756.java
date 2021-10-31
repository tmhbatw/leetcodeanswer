package leetcode.leetcode18;

import java.util.ArrayList;
import java.util.List;

public class Leetcode1756 {

    class MRUQueue {

        List<Integer> list;
        public MRUQueue(int n) {
            this.list=new ArrayList<>();
            for(int i=1;i<=n;i++){
                this.list.add(i);
            }
        }

        public int fetch(int k) {
            int remove=list.remove(k-1);
            list.add(remove);
            return remove;
        }
    }
}
