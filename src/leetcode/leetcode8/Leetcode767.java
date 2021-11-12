package leetcode.leetcode8;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Leetcode767 {

    class Node{
        char cur;
        int num;
        public Node(char cur,int num){
            this.cur=cur;
            this.num=num;
        }

        public String toString(){
            return this.cur+" "+this.num;
        }
    }

    public String reorganizeString(String s) {
        Map<Character,Integer> map=new HashMap<>();
        for(char c:s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        PriorityQueue<Node> q=new PriorityQueue<>((o1,o2)->{
            return o2.num-o1.num;
        });
        for(char key:map.keySet()){
            q.add(new Node(key,map.get(key)));
        }

        StringBuilder sb=new StringBuilder();
        char pre='\u0000';
        while(!q.isEmpty()){
            Node entry=q.poll();
            if(entry.cur==pre) {
                if(q.isEmpty())
                    return "";
                Node next=q.poll();
                sb.append(next.cur);
                pre=next.cur;
                next.num--;
                if(next.num>0)
                    q.add(next);
                q.add(entry);
            }else{
                pre=entry.cur;
                sb.append(pre);
                entry.num--;
                if(entry.num>0)
                    q.add(entry);
            }
        }
        return sb.toString();
    }
}
