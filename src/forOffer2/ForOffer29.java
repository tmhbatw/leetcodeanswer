package forOffer2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ForOffer29 {

    public int orchestraLayout(int num, int xPos, int yPos) {
        long n=num;
        long layer = Math.min(Math.min(yPos,xPos),Math.min( n - xPos - 1, n - yPos - 1))+1;
        long area= (long) num *num;
        long mid=(num-2*(layer-1));
        mid*=mid;
        long index=(area-mid)%9+1;
        long right=n-layer;
        long left=layer-1;
        if(xPos==left){
            index+=yPos-left;
        }else if(yPos==right){
            index+=right-left;
            index+=xPos-left;
        }else if(xPos==right){
            index+=2*(right-left);
            index+=right-yPos;
        }else{
            index+=3*(right-left);
            index+=right-xPos;
        }
        return (int)(index%9==0?9:index%9);
    }

    public Node insert(Node head, int insertVal) {
        if(head==null){
            Node result=new Node(insertVal);
            result.next=result;
            return result;
        }
        Node cur=head;
        while(cur.next!=head){
            if((cur.val<=insertVal&&cur.next.val>=insertVal)
                    ||(cur.next.val<cur.val
                    &&(cur.val<=insertVal ||insertVal<=cur.next.val))) {
                break;
            }
            cur = cur.next;
        }
        cur.next = new Node(insertVal,cur.next);
        return head;
    }

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
}
