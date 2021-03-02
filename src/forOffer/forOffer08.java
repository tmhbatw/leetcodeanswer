package forOffer;

import java.util.Stack;

public class forOffer08 {
    /*Description
    * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
    * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
    * */

    class CQueue {
        boolean isAddStatus;
        Stack<Integer> add;
        Stack<Integer> delete;
        int number;

        public CQueue() {
            isAddStatus=true;
            this.add=new Stack<>();
            this.delete=new Stack<>();
            this.number=0;
        }

        public void appendTail(int value) {
            number++;
            if(!isAddStatus){
                isAddStatus=true;
                while(!delete.isEmpty())
                    add.add(delete.pop());
            }
            add.add(value);
        }

        public int deleteHead() {
            if(number==0)
                return -1;
            number--;
            if(isAddStatus){
                isAddStatus=false;
                while(!add.isEmpty())
                    delete.add(add.pop());
            }
            return delete.pop();
        }
    }
}
