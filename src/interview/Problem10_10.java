package interview;

public class Problem10_10 {
    /*Description
    * 假设你正在读取一串整数。每隔一段时间，你希望能找出数字 x 的秩(小于或等于 x 的值的个数)。
    * 请实现数据结构和算法来支持这些操作，也就是说：
    * 实现 track(int x) 方法，每读入一个数字都会调用该方法；
    * 实现 getRankOfNumber(int x) 方法，返回小于或等于 x 的值的个数。
    * */

    class StreamRank {

        Node node;
        public StreamRank() {
            node=null;
        }

        public void track(int x) {
            if(node==null){
                node=new Node(x,1);
            }
            else {
                Node cur = node;
                while (true) {
                    if (x == cur.val) {
                        cur.time = cur.time + 1;
                        break;
                    }
                    if (x < cur.val) {
                        cur.time = cur.time + 1;
                        if(cur.left==null){
                            cur.left=new Node(x,1);
                            break;
                        }else {
                            cur = cur.left;
                        }
                    } else {
                        if(cur.right==null){
                            cur.right=new Node(x,1);
                            break;
                        }else {
                            cur = cur.right;
                        }

                    }
                }
            }
        }

        public int getRankOfNumber(int x) {
            int result=0;
            Node cur=node;
            while(cur!=null){
                if(cur.val==x){
                    return cur.time+result;
                }
                if(cur.val<x){
                    result+=cur.time;
                    cur=cur.right;
                }else{
                    cur=cur.left;
                }
            }
            return result;
        }
    }

    class Node{
        int val;
        int time;
        Node left;
        Node right;
        Node(int val,int time){
            this.val=val;
            this.time=time;
            this.left=null;
            this.right=null;
        }
    }

}
