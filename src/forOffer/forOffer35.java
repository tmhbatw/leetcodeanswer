package forOffer;

import java.util.HashMap;
import java.util.Map;

public class forOffer35 {
    /*Description
    *请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，
    * 还有一个 random 指针指向链表中的任意节点或者 null。
    * */

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        Map<Node,Node> map=new HashMap<>();
        Node result=new Node(0);
        Node cur=result;
        Node pre=head;
        while(head!=null){
            cur.next=new Node(head.val);
            cur=cur.next;
            map.put(head,cur);
            head=head.next;
        }
        cur=result.next;
        while(pre!=null){
            if(pre.random!=null){
                cur.random=map.get(pre.random);
            }
            pre=pre.next;
            cur=cur.next;
        }
        return result.next;
    }
}
