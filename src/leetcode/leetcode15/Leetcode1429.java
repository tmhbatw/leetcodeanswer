package leetcode.leetcode15;

import apple.laf.JRSUIUtils;

import java.util.*;

public class Leetcode1429 {

    class Node{
        int val;
        Node pre;
        Node next;
        public Node(int val){
            this.val=val;
        }
    }

    class FirstUnique {

        Map<Integer,Node> map=new HashMap<>();
        Node first;
        Node last;
        public FirstUnique(int[] nums) {
            this.first=new Node(-1);
            this.last=new Node(-1);
            first.next=last;
            last.pre=first;
            for(int num:nums)
                add(num);
        }

        public int showFirstUnique() {
            return first.next.val;
        }

        public void add(int value) {
            if(map.containsKey(value)){
                Node remove=map.get(value);
                if(remove==null)
                    return;
                map.put(value,null);
                remove.pre.next=remove.next;
                remove.next.pre=remove.pre;
            }else{
                Node add=new Node(value);
                map.put(value,add);
                Node l=last.pre;
                l.next=add;
                add.pre=l;
                add.next=last;
                last.pre=add;
            }
        }
    }
}
