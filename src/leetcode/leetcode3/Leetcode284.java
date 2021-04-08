package leetcode.leetcode3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Leetcode284 {
    /*Description
    * 给定一个迭代器类的接口，接口包含两个方法：next()和hasNext()。
    * 设计并实现一个支持peek()操作的顶端迭代器 -- 其本质就是把原本应由next()方法返回的元素peek()出来。
    * */

    class PeekingIterator implements Iterator<Integer> {
        List<Object> list=new ArrayList<>();
        int index=0;
        public PeekingIterator(Iterator<Integer> iterator) {
            while(iterator.hasNext())
                list.add(iterator.next());
        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            return (int)list.get(index);
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            return (int)list.get(index++);
        }

        @Override
        public boolean hasNext() {
            return index<list.size();
        }
    }
}
