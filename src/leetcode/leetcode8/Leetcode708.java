package leetcode.leetcode8;

public class Leetcode708 {
    /*Description
    * 给定循环升序列表中的一个点，写一个函数向这个列表中插入一个新元素 insertVal ，使这个列表仍然是循环升序的。
    * 给定的可以是这个列表中任意一个顶点的指针，并不一定是这个列表中最小元素的指针。
    * 如果有多个满足条件的插入位置，你可以选择任意一个位置插入新的值，插入后整个列表仍然保持有序。
    * 如果列表为空（给定的节点是 null），你需要创建一个循环有序列表并返回这个节点。否则。请返回原先给定的节点。
    * */

    class Node {
        public int val;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    };

    public Node insert(Node head, int insertVal) {
        if(head==null){
            Node result=new Node(insertVal);
            result.next=result;
            return result;
        }
        if(head.next==head){
            head.next=new Node (insertVal);
            head.next=head;
            return head;
        }
        Node cur=head;
        while(true){
            if(insertVal>=cur.val&&(insertVal<=cur.next.val||cur.next.val<cur.val)||cur.next.val<cur.val
                &&cur.next.val>insertVal){
                cur.next=new Node(insertVal);
                cur.next.next=head;
                return head;
            }
            cur=cur.next;
        }
    }
}
