package leetcode.leetcode8;

public class Leetcode707 {
    /*Description
    * 设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：
    * val和next。val是当前节点的值，next是指向下一个节点的指针/引用。
    * 如果要使用双向链表，则还需要一个属性prev以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。
    * 在链表类中实现这些功能：
    * get(index)：获取链表中第index个节点的值。如果索引无效，则返回-1。
    * addAtHead(val)：在链表的第一个元素之前添加一个值为val的节点。插入后，新节点将成为链表的第一个节点。
    * addAtTail(val)：将值为val 的节点追加到链表的最后一个元素。
    * addAtIndex(index,val)：在链表中的第index个节点之前添加值为val 的节点。
    * 如果index等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
    * deleteAtIndex(index)：如果索引index 有效，则删除链表中的第index 个节点。
    * */


    class MyLinkedList {
        class Node{
            int val;
            Node next;
            public Node(int val){
                this.val=val;
                this.next=null;
            }
        }
        Node start;
        Node end;
        int number;

        /** Initialize your data structure here. */
        public MyLinkedList() {
            this.start=new Node(0);
            this.end=start;
            this.number=0;
        }

        /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
        public int get(int index) {
            if(index<0||index>=number){
                return -1;
            }
            Node cur=start.next;
            while(index-->0){
                cur=cur.next;
            }
            return cur.val;
        }

        /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
        public void addAtHead(int val) {
            number++;
            Node curStart=start.next;
            start.next=new Node(val);
            if(number==1)
                end=start.next;
            start.next.next=curStart;
        }

        /** Append a node of value val to the last element of the linked list. */
        public void addAtTail(int val) {
            number++;
            end.next=new Node(val);
            end=end.next;
        }

        /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
        public void addAtIndex(int index, int val) {
            if(index<=0)
                addAtHead(val);
            else if(index==number)
                addAtTail(val);
            else{
                number++;
                Node cur=start;
                while(index-->0){
                    cur=cur.next;
                }
                Node next=cur.next;
                cur.next=new Node(val);
                cur.next.next=next;
            }
        }

        /** Delete the index-th node in the linked list, if the index is valid. */
        public void deleteAtIndex(int index) {
            if(index>=number||index<0)
                return;
            number--;
            Node cur=start;
            for(int i=0;i<index;i++){
                cur=cur.next;
            }
            if(index==number){
                end=cur;
            }
            cur.next=cur.next.next;
        }
    }

}
