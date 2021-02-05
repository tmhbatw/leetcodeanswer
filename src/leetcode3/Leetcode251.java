package leetcode3;

import java.util.ArrayList;
import java.util.List;

public class Leetcode251 {
    /*Description
    * 请设计并实现一个能够展开二维向量的迭代器。该迭代器需要支持 next 和 hasNext 两种操作。
    * */

    class Vector2D {
        List<Integer> v;
        int index;

        public Vector2D(int[][] v) {
            this.v=new ArrayList();
            for(int[] cur:v){
                for(int j=0;j<cur.length;j++)
                    this.v.add(cur[j]);
            }
            this.index=0;
        }

        public int next() {
            return v.get(index++);
        }

        public boolean hasNext() {
            return index<v.size();
        }
    }
}
