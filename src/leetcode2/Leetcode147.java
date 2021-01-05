package leetcode2;

import datastructure.ListNode;

public class Leetcode147 {
    /*Description
    * 对链表进行插入排序。
    * 插入排序算法：
    * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
    * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
    * 重复直到所有输入数据插入完为止。
     * */

    public ListNode insertionSortList(ListNode head) {
        ListNode result=new ListNode(0);
        while(head!=null){
            ListNode cur=head;
            head=head.next;
            cur.next=null;
            ListNode curr=result;
            while(curr.next!=null&&curr.next.val<cur.val){
                curr=curr.next;
            }
            ListNode left=curr.next;
            curr.next=cur;
            cur.next=left;
        }
        return result.next;
    }
}
