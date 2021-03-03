package interview;

import datastructure.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Problem1_10 {
    /*Description
    * 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
    * 如果不得使用临时缓冲区，该怎么解决？
    * */

    /*Solution
    *不使用缓冲区则可能需要双重循坏
    * nt？？
    * */

    public ListNode removeDuplicateNodes(ListNode head) {
        if(head==null)
            return null;
        ListNode cur=head;
        Set<Integer> set=new HashSet<>();
        set.add(head.val);
        while(cur.next!=null){
            if(set.contains(cur.next.val)){
                cur.next=cur.next.next;
            }else{
                cur=cur.next;
                set.add(cur.val);
            }
        }
        return head;
    }
}
