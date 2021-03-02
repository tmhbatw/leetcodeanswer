package forOffer;

import datastructure.ListNode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class forOffer06 {
    /*Description
    * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
    * */

    public int[] reversePrint(ListNode head) {
        List<Integer> list=new ArrayList<>();
        while(head!=null) {
            list.add(head.val);
            head=head.next;
        }
        int[] res=new int[list.size()];
        for(int j=list.size()-1;j>=0;j--){
            res[list.size()-1-j]=list.get(j);
        }
        return res;
    }

}
