package forOffer2;

import java.util.Stack;

public class ForOffer28 {

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    };

    public Node flatten(Node head) {
        if(head==null)
            return head;
        Node result=null;
        Node cur=null;

        Stack<Node> stack=new Stack<>();
        stack.add(head);

        while(!stack.isEmpty()){
            Node node=stack.pop();
            if(node.next!=null)
                stack.add(node.next);
            if(node.child!=null)
                stack.add(node.child);
            node.prev=null;
            node.next=null;
            node.child=null;

            if(result==null){
                result=node;
            }else{
                cur.next=node;
                node.prev=cur;
            }
            cur=node;
        }
        return result;
    }
}
