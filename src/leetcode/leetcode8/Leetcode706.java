package leetcode.leetcode8;

public class Leetcode706 {
    /*Description
    * 不使用任何内建的哈希表库设计一个哈希映射
    * 具体地说，你的设计应该包含以下的功能
    * put(key, value)：向哈希映射中插入(键,值)的数值对。如果键对应的值已经存在，更新这个值。
    * get(key)：返回给定的键所对应的值，如果映射中不包含这个键，返回-1。
    * remove(key)：如果映射中存在这个键，删除这个数值对。
    * */

    class MyHashMap {
        LinkNode[] num;

        /** Initialize your data structure here. */
        public MyHashMap() {
            num=new LinkNode[769];
        }

        /** value will always be non-negative. */
        public void put(int key, int value) {
            int index=key%769;
            LinkNode node=num[index];
            if(node==null)
                num[index]=new LinkNode(key,value);
            else if(node.key==key)
                node.val=value;
            else{
                while(node.next!=null){
                    if(node.next.key==key) {
                        node.next.val = value;
                        return;
                    }
                    node=node.next;
                }
                node.next=new LinkNode(key,value);
            }
        }

        /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
        public int get(int key) {
            int index=key%769;
            LinkNode node=num[index];
            while(node!=null){
                if(node.key==key)
                    return node.val;
                node=node.next;
            }
            return -1;
        }

        /** Removes the mapping of the specified value key if this map contains a mapping for the key */
        public void remove(int key) {
            int index=key%769;
            LinkNode node=num[index];
            if(node==null)
                return;
            if(node.key==key)
                num[index]=node.next;
            while(node.next!=null){
                if(node.next.key==key) {
                    node.next = node.next.next;
                    return;
                }
                node=node.next;
            }
        }
    }

    class LinkNode{
        int key,val;
        LinkNode next;
        LinkNode(int key,int val){
            this.key=key;
            this.val=val;
        }
    }

}
