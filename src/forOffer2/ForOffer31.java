package forOffer2;

import leetcode.leetcode2.Leetcode146;

import java.util.HashMap;
import java.util.Map;

public class ForOffer31 {
    class LRUCache {
        int number=0;
        int capacity;
        LinkedNode start;
        LinkedNode cur;
        Map<Integer, LinkedNode> map;

        public LRUCache(int capacity) {
            this.capacity=capacity;
            this.start=new LinkedNode(-1,-1);
            cur=start;
            this.map=new HashMap<>();
        }

        public int get(int key) {
            LinkedNode cur=map.get(key);
            if(cur==null)
                return -1;
            LinkedNode node=map.get(key);
            moveNode(node);
            return node.val;
        }

        private void moveNode(LinkedNode node){
            if(node.right==null)
                return;
            LinkedNode left=node.left,right=node.right;
            left.right=right;
            right.left=left;
            cur.right=node;
            node.left=cur;
            node.right=null;
            cur=cur.right;
        }

        public void put(int key, int value) {
            if(map.containsKey(key)) {
                LinkedNode node=map.get(key);
                node.val = value;
                moveNode(node);
            }
            else{
                LinkedNode node=new LinkedNode(key,value);
                map.put(key,node);
                node.left=cur;
                cur.right=node;
                cur=node;
                number++;
                if(number>capacity){
                    number--;
                    map.remove(start.right.key);
                    start=start.right;
                }
            }
        }

        class LinkedNode{
            int key;
            int val;
            LinkedNode right;
            LinkedNode left;
            public LinkedNode(int key,int val){
                this.key=key;
                this.val=val;
            }
        }
    }
}
