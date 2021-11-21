package leetcode.leetcode7;

public class Leetcode641 {

    class Node {
        Node pre;
        Node post;
        int val;
        public Node(int val){
            this.val=val;
        }
    }
    class MyCircularDeque {

        Node first=new Node(-1);
        Node last =new Node(-1);
        int capacity;
        int size;
        public MyCircularDeque(int k) {
            this.size=0;
            this.capacity=k;
            this.first.post=this.last;
            this.last.pre=this.first;
        }

        public boolean insertFront(int value) {
            if(size==capacity)
                return false;
            Node add=new Node(value);
            Node next=first.post;
            first.post=add;
            add.pre=first;
            next.pre=add;
            add.post=next;
            size++;
            return true;
        }

        public boolean insertLast(int value) {
            if(size==capacity)
                return false;
            Node add=new Node(value);
            Node pre=last.pre;
            pre.post=add;
            add.pre=pre;
            last.pre=add;
            add.post=last;
            size++;
            return true;
        }

        public boolean deleteFront() {
            if(isEmpty())
                return false;
            size--;
            Node remove=first.post;
            first.post=remove.post;
            first.post.pre=first;
            return true;
        }

        public boolean deleteLast() {
            if(isEmpty())
                return false;
            size--;
            Node remove=last.pre;
            last.pre=remove.pre;
            last.pre.post=last;
            return true;
        }

        public int getFront() {
            return first.post.val;
        }

        public int getRear() {
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
