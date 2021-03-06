package leetcode.leetcode2;

import java.util.HashMap;
import java.util.Map;

public class Leetcode138 {
    /*Description
    * 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
    * 要求返回这个链表的深拷贝。
    * 我们用一个由n个节点组成的链表来表示输入/输出中的链表。每个节点用一个[val, random_index]表示：
    * val：一个表示Node.val的整数。
    * random_index：随机指针指向的节点索引（范围从0到n-1）；如果不指向任何节点，则为null。
    * */

    Map<Node,Node> map=new HashMap<>();
    public Node copyRandomList(Node head) {
        if(head==null)
            return null;
        if(map.containsKey(head))
            return map.get(head);
        Node result=new Node(head.val);
        map.put(head,result);
        result.random=copyRandomList(head.random);
        result.next=copyRandomList(head.next);
        return result;
    }

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
}
