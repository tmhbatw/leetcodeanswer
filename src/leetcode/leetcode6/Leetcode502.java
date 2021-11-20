package leetcode.leetcode6;

import sun.util.resources.cldr.kk.CurrencyNames_kk;

import java.util.*;

public class Leetcode502 {

    class Node{
        int profit;
        int capital;
        public Node(int profit,int capital){
            this.profit=profit;
            this.capital=capital;
        }
    }

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        List<Node> list=new ArrayList<>();
        for(int i=0;i<profits.length;i++)
            list.add(new Node(profits[i],capital[i]));
        list.sort((o1,o2)->o1.capital-o2.capital);
        PriorityQueue<Node> p=new PriorityQueue<>((o1,o2)-> o2.profit-o1.profit);
        int index=0;
        int result=w;
        while(k-->0){
            for(;index<list.size();index++){
                if(list.get(index).capital>result)
                    break;
                p.add(list.get(index));
            }
            if(p.isEmpty())
                break;
            Node cur=p.poll();
            result+=cur.profit;
        }
        return result;
    }
}
