package interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Problem3_3 {
    /*Description
    * 堆盘子。设想有一堆盘子，堆太高可能会倒下来。因此，在现实生活中，盘子堆到一定高度时，
    * 我们就会另外堆一堆盘子。请实现数据结构SetOfStacks，模拟这种行为。SetOfStacks应该由多个栈组成，
    * 并且在前一个栈填满时新建一个栈。此外，SetOfStacks.push()和SetOfStacks.pop()应该与普通栈的操作方法相同（
    * 也就是说，pop()返回的值，应该跟只有一个栈时的情况一样）。 进阶：实现一个popAt(int index)方法，根据指定的子栈，执行pop操作。
    * 当某个栈为空时，应当删除该栈。当栈中没有元素或不存在该栈时，pop，popAt 应返回 -1.
    * */

    class StackOfPlates {
        int index;
        List<Stack<Integer>> list;
        int size;

        public StackOfPlates(int cap) {
            this.index=-1;
            list=new ArrayList<>();
            this.size=cap;
        }

        public void push(int val) {
            Stack<Integer> s;
            if(index==-1||list.get(index).size()==size) {
                s = new Stack<>();
                list.add(s);
                index++;
            }else
                s=list.get(index);
            s.add(val);
        }

        public int pop() {
            if(size<=0)
                return -1;
            if(index==-1)
                return -1;
            Stack<Integer> s=list.get(index);
            int val=s.pop();
            if(s.isEmpty()){
                list.remove(index--);
            }
            return val;
        }

        public int popAt(int index) {
            if(size<=0)
                return -1;
            if(list.size()<=index){
                return -1;
            }
            Stack<Integer> cur=list.get(index);
            int val=cur.pop();
            if(cur.isEmpty()){
                list.remove(index);
                this.index--;
            }
            return val;
        }
    }
}
