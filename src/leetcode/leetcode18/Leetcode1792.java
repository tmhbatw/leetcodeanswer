package leetcode.leetcode18;

import java.util.PriorityQueue;

public class Leetcode1792 {

    class Class{
        int good;
        int sum;
        double add;
        public Class(int good,int sum){
            this.good=good;
            this.sum=sum;
            this.add=(sum-good)*1.0/sum/(sum+1);
        }
    }
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<Class> p=new PriorityQueue<>((o1,o2)->{
            return o2.add>=o1.add?1:-1;
        });

        for(int[] c:classes)
            p.add(new Class(c[0],c[1]));
        while(extraStudents-->0){
            Class cur=p.poll();
            p.add(new Class(cur.good+1,cur.sum+1));
        }

        double res=0;
        for(Class c:p)
            res+=c.good*1.0/c.sum;
        return res/classes.length;
    }
}
