package interview;

import datastructure.ListNode;

public class Problem2_5 {
    /*Description
    * 给定两个用链表表示的整数，每个节点包含一个数位。
    * 这些数位是反向存放的，也就是个位排在链表首部。
    * 编写函数对这两个整数求和，并用链表形式返回结果。
    * */

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int count=0;
        ListNode result=new ListNode(-1);
        ListNode cur=result;
        while(l1!=null||l2!=null){
            int v1=l1!=null?l1.val:0;
            int v2=l2!=null?l2.val:0;
            int curVal=v1+v2+count;
            cur.next=new ListNode(curVal%10);
            cur=cur.next;
            count=curVal/10;
            if(l1!=null)
                l1=l1.next;
            if(l2!=null)
                l2=l2.next;
        }
        if(count!=0)
            cur.next=new ListNode(count);
        return result.next;
    }
}
