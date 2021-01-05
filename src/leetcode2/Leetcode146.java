package leetcode2;

import java.util.HashMap;
import java.util.Map;

public class Leetcode146 {
    /*Description
    * 运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制
    * 实现 LRUCache 类：
    * LRUCache(int capacity) 以正整数作为容量capacity 初始化 LRU 缓存
    * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
    * void put(int key, int value)如果关键字已经存在，则变更其数据值；如果关键字不存在，
    * 则插入该组「关键字-值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
    * */

    class LRUCache {
        int number=0;
        int capacity;
        LinkedNode start;
        LinkedNode cur;
        Map<Integer,LinkedNode> map;

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
