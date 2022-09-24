package leetcode.leetcode12;

import java.util.ArrayList;
import java.util.List;

public class Leetcode1146 {

    class SnapshotArray {
        class Node {
            int val;
            int index;
            public Node(int val,int index){
                this.val=val;
                this.index=index;
            }
        }
        List<List<Node>> list=new ArrayList<>();
        int index=0;
        public SnapshotArray(int length) {
            int[] number=new int[length];
            for(int i=0;i<length;i++) {
                List<Node> l=new ArrayList<>();
                l.add(new Node(0,0));
                list.add(l);
            }
        }

        public void set(int index, int val) {
            List<Node> list=this.list.get(index);
            if(list.get(list.size()-1).index==this.index){
                list.get(list.size()-1).val=val;
            }else{
                Node node=new Node(val,this.index);
                list.add(node);
            }
        }

        public int snap() {
            return index++;
        }

        public int get(int index, int snap_id) {
            List<Node> list=this.list.get(index);
            // System.out.println("index is :"+" "+index+" "+snap_id);
            // for(Node cur:list){
            //     System.out.println(cur.val+" "+cur.index);
            // }

            if(snap_id>=list.get(list.size()-1).index){
                return list.get(list.size()-1).val;
            }
            int l=0,r=list.size()-1;
            while(l<r){
                int mid=(l+r+1)/2;
                if(list.get(mid).index<=snap_id){
                    l=mid;
                }else{
                    r=mid-1;
                }
            }
            return list.get(l).val;
        }
    }



}
