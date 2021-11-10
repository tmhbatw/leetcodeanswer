package leetcode.leetcode8;

import sun.awt.image.ImageWatched;

import java.util.*;

public class Leetcode752 {

    public int openLock(String[] deadends, String target) {

        Set<String> dead = new HashSet<>(Arrays.asList(deadends));
        if(dead.contains("0000"))
            return -1;
        if(target.equals("0000"))
            return 0;
        Set<String> exist=new HashSet<>();
        exist.add("0000");



        Queue<String> q=new LinkedList<>();
        q.add("0000");
        int distance=0;
        while(!q.isEmpty()){
            distance++;
            int size=q.size();
            while(size-->0){
                String cur=q.poll();
                for(String next:getNext(cur)){
                    if(dead.contains(next)||exist.contains(next))
                        continue;
                    if(next.equals(target))
                        return distance;
                    exist.add(next);
                    q.add(next);
                }
            }
        }
        return -1;
    }

    private String[] getNext(String cur){
        String[] res=new String[8];
        for(int i=0;i<4;i++){
            char[] curr1=cur.toCharArray();
            curr1[i]=getSmall(curr1[i]);
            char[] curr2=cur.toCharArray();
            curr2[i]=getBig(curr2[i]);
            res[i*2]=new String(curr1);
            res[i*2+1]=new String(curr2);
        }
        return res;
    }

    private char getSmall(char cur){
        if(cur=='0')
            return '9';
        return (char)(cur-1);
    }

    private char getBig(char cur){
        if(cur=='9')
            return '0';
        return (char)(cur+1);
    }


}
