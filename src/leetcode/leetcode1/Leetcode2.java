package leetcode.leetcode1;

import datastructure.ListNode;

public class Leetcode2 {
    /*Description
    * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，
    * 并且它们的每个节点只能存储 一位 数字。如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
    * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
    * 来源：力扣（LeetCode）
    * 链接：https://leetcode-cn.com/problems/add-two-numbers
    * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    * */

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result=new ListNode(0);
        ListNode cur=result;
        int count=0;
        while(l1!=null&&l2!=null){
            int number=l1.val+l2.val+count;
            count=number/10;
            number%=10;
            cur.next=new ListNode(number);
            cur=cur.next;
            l1=l1.next;
            l2=l2.next;
        }
        if(l1!=null){
            addNumbers(cur,l1,count);
        }else if(l2!=null)
            addNumbers(cur,l2,count);
        else if(count!=0)
            cur.next=new ListNode(count);
        return result.next;
    }

    private void addNumbers(ListNode cur,ListNode l,int count){
        while(l!=null){
            int number=l.val+count;
            count=number/10;
            number%=10;
            l=l.next;
            cur.next=new ListNode(number);
            cur=cur.next;
        }
        if(count!=0)
            cur.next=new ListNode(count);
    }
}
