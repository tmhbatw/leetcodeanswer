package leetcode.leetcode5;

import java.util.Stack;

public class Leetcode430 {


    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }

    public Node flatten(Node head) {
        if(head==null)
            return null;
        Node result=new Node();
        Node cur=result;
        Stack<Node> s=new Stack<>();
        s.add(head);
        while(!s.isEmpty()){
            Node node=s.pop();
            cur.next=new Node();
            cur.next.val=node.val;
            cur.next.prev=cur;
            cur=cur.next;
            if(node.next!=null)
                s.add(node.next);
            if(node.child!=null)
                s.add(node.child);
        }
        result=result.next;
        result.prev=null;
        return result;
    }
}
