package interview;

import datastructure.ListNode;
import datastructure.TreeNode;

public class Problem2_6 {
    /*Description
    * 编写一个函数，检查输入的链表是否是回文的。
     * */

    public boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null)
            return true;
        ListNode fast=head,slow=head;
        while(fast.next!=null&&fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode reverse=reverse(slow.next);
        while(reverse!=null){
            if(reverse.val!=head.val)
                return false;
            reverse=reverse.next;
            head=head.next;
        }
        return true;
    }

    private ListNode reverse(ListNode cur){
        ListNode result=cur;
        ListNode next=cur.next;
        cur.next=null;
        while(next!=null){
            ListNode temp=next.next;
            next.next=cur;
            cur=next;
            next=temp;
        }
        return cur;
    }
}
