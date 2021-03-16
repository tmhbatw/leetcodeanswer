package interview;

import java.util.HashMap;
import java.util.Map;

public class Problem16_25 {
    /*Description
    *设计和构建一个“最近最少使用”缓存，该缓存会删除最近最少使用的项目。缓存应该从键映射到值(允许你插入和检索特定键对应的值)，
    * 并在初始化时指定最大容量。当缓存被填满时，它应该删除最近最少使用的项目。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
    * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
    * 写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间

    * */

    class LRUCache {
        int capacity;
        int number;
        Map<Integer,Node> map;
        Node start;
        Node end;
        public LRUCache(int capacity) {
            this.capacity=capacity;
            this.map=new HashMap<>();
            this.number=0;
            this.start=new Node(0,0);
            this.end=new Node(0,0);
            this.start.next=end;
            this.end.pre=start;
        }

        public int get(int key) {
            if(!map.containsKey(key))
                return -1;
            Node cur=map.get(key);
            move(cur);
            return cur.val;
        }

        private void move(Node cur){
            Node pre=cur.pre;
            Node next=cur.next;
            pre.next=next;
            next.pre=pre;
            Node endPre=end.pre;
            endPre.next=cur;
            cur.pre=endPre;
            end.pre=cur;
            cur.next=end;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                Node cur=map.get(key);
                cur.val=value;
                move(cur);
            }else{
                if(number<capacity){
                    number++;
                }else{
                    Node remove=start.next;
                    start.next=remove.next;
                    start.next.pre=start;
                    map.remove(remove.key);
                }
                Node node=new Node(key,value);
                map.put(key,node);
                Node endPre=end.pre;
                endPre.next=node;
                node.pre=endPre;
                end.pre=node;
                node.next=end;
            }
        }
        class Node{
            int key;
            int val;
            Node pre;
            Node next;
            Node(int key,int val){
                this.key=key;
                this.val=val;
                this.pre=null;
                this.next=null;
            }
        }
    }


}
