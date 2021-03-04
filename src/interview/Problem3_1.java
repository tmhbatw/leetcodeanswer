package interview;

public class Problem3_1 {
    /*Description
    * 三合一。描述如何只用一个数组来实现三个栈。
    * 你应该实现push(stackNum, value)、pop(stackNum)、isEmpty(stackNum)、peek(stackNum)方法。
    * stackNum表示栈下标，value表示压入的值。
    * 构造函数会传入一个stackSize参数，代表每个栈的大小。
    * */

    class TripleInOne {
        int[] num;
        int index1;
        int index2;
        int index3;
        int size;
        public TripleInOne(int stackSize) {
            this.index1=0;
            this.index2=stackSize;
            this.index3=stackSize*2;
            this.size=stackSize;
            this.num=new int[stackSize*3];
        }

        public void push(int stackNum, int value) {
            switch (stackNum){
                case 0:
                    if(index1==size)
                        return;
                    num[index1++]=value;
                    break;
                case 1:
                    if(index2==size*2)
                        return;
                    num[index2++]=value;
                    break;
                default:
                    if(index3==size*3)
                        return;
                    num[index3++]=value;
            }
        }

        public int pop(int stackNum) {
            switch (stackNum){
                case 0:
                    if(isEmpty(0))
                        return -1;
                    return num[--index1];
                case 1:
                    if(isEmpty(1))
                        return -1;
                    return num[--index2];
                default:
                    if(isEmpty(2))
                        return -1;
                    return num[--index3];
            }
        }

        public int peek(int stackNum) {
            switch (stackNum){
                case 0:
                    if(isEmpty(0))
                        return -1;
                    return num[index1-1];
                case 1:
                    if(isEmpty(1))
                        return -1;
                    return num[index2-1];
                default:
                    if(isEmpty(2))
                        return -1;
                    return num[index3-1];
            }
        }

        public boolean isEmpty(int stackNum) {
            switch (stackNum){
                case 0:
                    return index1==0;
                case 1:
                    return index2==size;
                default:
                    return index3==size*2;
            }
        }
    }
}
