package leetcode.leetcode4;

import datastructure.ListNode;

public class Leetcode382 {
    /*Description
    * 给定一个单链表，随机选择链表的一个节点，并返回相应的节点值。保证每个节点被选的概率一样。
    * 进阶:如果链表十分大且长度未知，如何解决这个问题？你能否使用常数级空间复杂度实现？
    * */

    /*Solution
    * 可以使用蓄水池抽样算法
    * */

    class Solution {

        /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
        ListNode root;
        public Solution(ListNode head) {
            this.root=head;
        }

        /** Returns a random node's value. */
        public int getRandom() {
            int number=1;
            ListNode cur=root;
            int result=0;
            while(cur!=null){
                int random=(int)(Math.random()*number);
                if(random<1)
                    result=cur.val;
                cur=cur.next;
                number++;
            }
            return result;
        }
    }
}
