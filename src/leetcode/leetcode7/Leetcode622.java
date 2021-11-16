package leetcode.leetcode7;

public class Leetcode622 {

    class Node{
        Node pre;
        Node next;
        int val;
        public Node(int val){
            this.val=val;
        }
    }

    class MyCircularQueue {
        int capacity;
        int size;
        Node first;
        Node last;

        public MyCircularQueue(int k) {
            this.capacity=k;
            this.size=0;
            this.first=new Node(-1);
            this.last=new Node(-1);
            first.next=last;
            last.pre=first;
        }

        public boolean enQueue(int value) {
            if(size==capacity)
                return false;
            size++;
            Node cur=new Node(value);
            Node pre=last.pre;
            pre.next=cur;
            cur.pre=pre;
            cur.next=last;
            last.pre=cur;
            return true;
        }

        public boolean deQueue() {
            if(size==0)
                return false;
            size--;
            Node post=first.next.next;
            first.next=post;
            post.pre=first;
            return true;
        }

        public int Front() {
            return first.next.val;
        }

        public int Rear() {
            return last.pre.val;
        }

        public boolean isEmpty() {
            return size==0;
        }

        public boolean isFull() {
            return size==capacity;
        }

    }
}
