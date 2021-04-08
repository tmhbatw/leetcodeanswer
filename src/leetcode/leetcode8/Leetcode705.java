package leetcode.leetcode8;

public class Leetcode705 {
    /*Description
    * 不使用任何内建的哈希表库设计一个哈希集合（HashSet）。
    * 实现 MyHashSet 类：
    * void add(key) 向哈希集合中插入值 key 。
    * bool contains(key) 返回哈希集合中是否存在这个值 key 。
    * void remove(key) 将给定值 key 从哈希集合中删除。如果哈希集合中没有这个值，什么也不做。
    * */

    class MyHashSet {
        LinkNode[] node;
        /** Initialize your data structure here. */
        public MyHashSet() {
            node=new LinkNode[1000];
        }

        public void add(int key) {
            int index=key%1000;
            if(this.node[index]==null)
                this.node[index]=new LinkNode(key);
            LinkNode node=this.node[index];
            if(node.val==key)
                return;
            while(node.next!=null){
                if(node.next.val==key)
                    return;
                node=node.next;
            }
            node.next=new LinkNode(key);
        }

        public void remove(int key) {
            int index=key%1000;
            if(this.node[index]==null)
                return;
            LinkNode node=this.node[index];
            if(node.val==key)
                this.node[index]=node.next;
            while(node.next!=null){
                if(node.next.val==key){
                    node.next=node.next.next;
                    return;
                }
                node=node.next;
            }
        }

        /** Returns true if this set contains the specified element */
        public boolean contains(int key) {
            int index=key%1000;
            LinkNode node=this.node[index];
            while(node!=null){
                if(node.val==key)
                    return true;
                node=node.next;
            }
            return false;
        }
    }

    class LinkNode{
        int val;
        LinkNode next;
        LinkNode(int val){
            this.val=val;
        }
    }
}
