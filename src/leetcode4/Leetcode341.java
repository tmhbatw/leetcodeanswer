package leetcode4;

import datastructure.NestedInteger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Leetcode341 {
    /*Description
    * 给你一个嵌套的整型列表。请你设计一个迭代器，使其能够遍历这个整型列表中的所有整数。
    * 列表中的每一项或者为一个整数，或者是另一个列表。其中列表的元素也可能是整数或是其他列表。
    * */

    public class NestedIterator implements Iterator<Integer> {
        List<Integer> list;
        int index;

        public NestedIterator(List<NestedInteger> nestedList) {
            this.list=new ArrayList<>();
            this.index=0;
            for(NestedInteger cur:nestedList){
                addList(cur);
            }
        }

        private void addList(NestedInteger cur){
            if(cur.isInteger())
                list.add(cur.getInteger());
            else{
                for(NestedInteger curr:cur.getList())
                    addList(curr);
            }
        }

        @Override
        public Integer next() {
            return list.get(index++);
        }

        @Override
        public boolean hasNext() {
            return index<list.size();
        }
    }
}
