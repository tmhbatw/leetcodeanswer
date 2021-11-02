package leetcode.leetcode14;

public class Leetcode1381 {

    class CustomStack {

        int[] num;
        int length;
        public CustomStack(int maxSize) {
            this.num=new int[maxSize];
            this.length=0;
        }

        public void push(int x) {
            if(length!=num.length)
                this.num[length++]=x;
        }

        public int pop() {
            if(length==0)
                return -1;
            return num[--length];
        }

        public void increment(int k, int val) {
            for(int i=0;i<Math.min(k,length);i++)
                num[i]+=val;
        }
    }

}
