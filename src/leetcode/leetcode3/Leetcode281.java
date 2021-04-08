package leetcode.leetcode3;

import java.util.List;

public class Leetcode281 {
    /*Description
    * 给出两个一维的向量，请你实现一个迭代器，交替返回它们中间的元素。
    * */

    public class ZigzagIterator {
        List<Integer> v1;
        List<Integer> v2;
        int index1=0;
        int index2=0;
        boolean isV1=true;
        public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
            this.v1=v1;
            this.v2=v2;
        }

        public int next() {
            isV1=!isV1;
            if(isV1){
                if(index2==v2.size())
                    return next();
                return v2.get(index2++);
            }else{
                if(index1==v1.size())
                    return next();
                return v1.get(index1++);
            }
        }

        public boolean hasNext() {
            return index1<v1.size()||index2<v2.size();
        }
    }
}
