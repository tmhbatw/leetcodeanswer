package leetcode.leetcode5;

import java.util.*;

public class Leetcode433 {

    public int minMutation(String start, String end, String[] bank) {
        if(start.equals(end))
            return 0;

        boolean miss=true;
        Map<Integer, List<Integer>> next=new HashMap<>();
        for(int i=0;i<bank.length;i++)
            next.put(i,new ArrayList<>());
        for(int i=0;i<bank.length;i++){
            for(int j=0;j<bank.length;j++){
                if(isSimilar(bank[i],bank[j])){
                    next.get(i).add(j);
                    next.get(j).add(i);
                }
            }
            if(bank[i].equals(end))
                miss=false;
        }

        if(miss)
            return -1;

        Queue<Integer> q=new LinkedList<>();
        int dis=1;
        boolean[] reached=new boolean[bank.length];
        for(int i=0;i<bank.length;i++){
            if(isSimilar(start,bank[i])){
                q.add(i);
                reached[i]=true;
            }
        }

        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int cur=q.poll();
                if(bank[cur].equals(end))
                    return dis;
                for(int n:next.get(cur)){
                    if(reached[n])
                        continue;
                    reached[n]=true;
                    q.add(n);
                }
            }
            dis++;
        }

        return -1;
    }
    private boolean isSimilar(String s1,String s2){
        int count=0;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i))
                count++;
        }
        return count==1;
    }

}
