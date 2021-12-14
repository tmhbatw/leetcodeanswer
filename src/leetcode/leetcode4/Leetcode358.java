package leetcode.leetcode4;

import java.util.PriorityQueue;

public class Leetcode358 {

    class Node{
        char cur;
        int time;
        public Node(char cur,int time){
            this.cur=cur;
            this.time=time;
        }
    }

    public String rearrangeString(String s, int k) {
        if(k==0)
            return s;
        int[] time=new int[26];
        for(char c:s.toCharArray())
            time[c-'a']++;
        PriorityQueue<Node> q=new PriorityQueue<>((o1,o2)->{
            if(o1.time==o2.time)
                return o1.cur-o2.cur;
            return o2.time-o1.time;
        });
        for(int i=0;i<26;i++) {
            if(time[i]>0)
                q.add(new Node((char) (i + 'a'), time[i]));
        }

        char[] res=new char[s.length()];
        for(int i=0;i<s.length();i++){
            if(i>=k){
                char pre=res[i-k];
                if(time[pre-'a']>0)
                    q.add(new Node(pre,time[pre-'a']));
            }
            if(q.isEmpty())
                return "";

            Node cur=q.poll();
            res[i]=cur.cur;
            time[cur.cur-'a']--;
        }
        return new String(res);
    }
}
