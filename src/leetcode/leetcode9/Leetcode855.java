package leetcode.leetcode9;

public class Leetcode855 {

    class ExamRoom {

        class Node{
            Node pre;
            Node next;
            int val;
            public Node(int cur){
                this.val=cur;
            }
        }

        Node start;
        Node end;
        public ExamRoom(int n) {
            start=new Node(-1);
            end = new Node(n);
            start.next=end;
            end.pre=end;
        }

        public int seat() {
            if(start.next==end){
                Node result=new Node(0);
                result.pre=start;
                start.next=result;
                result.next=end;
                end.pre=result;
                return 0;
            }
            Node cur=start;
            Node insert=start;
            int dis=0;
            while(cur.next!=null){
                int nextDis= (cur.next.val-cur.val)/2;
                if(cur==start||cur.next==end){
                    nextDis=cur.next.val-cur.val-1;
                }
                if(nextDis>dis){
                    dis=nextDis;
                    insert=cur;
                }
                cur=cur.next;
            }
            int val= insert==start?0: insert.val+dis;
            Node result=new Node(val);
            result.pre=insert;
            insert.next.pre=result;
            result.next=insert.next;
            insert.next=result;
            return val;
        }

        public void leave(int p) {
            Node cur = start;
            while(true){
                if(cur.val==p){
                    cur.pre.next=cur.next;
                    cur.next.pre=cur.pre;
                    break;
                }
            }
        }
    }


}
