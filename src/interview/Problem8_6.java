package interview;

import java.util.List;

public class Problem8_6 {
    /*Description
    * 汉诺塔问题
    * */

    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        for(int i=0;i<A.size();i++)
            C.add(A.get(i));
    }
}
