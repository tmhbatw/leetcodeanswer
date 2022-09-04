package leetcode.leetcode16;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Leetcode1514 {

    class Point{
        int i;
        double probability;

        public Point(int i,double probability){
            this.i=i;
            this.probability=probability;
        }
    }

    public double maxProbability(int n, int[][] edges,
                                 double[] succProb, int start, int end) {
        List<List<Point>> next=new ArrayList<>();
        for(int i=0;i<n;i++){
            next.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int[] edge=edges[i];
            next.get(edge[0]).add(new Point(edge[1],succProb[i]));
            next.get(edge[1]).add(new Point(edge[0],succProb[i]));
        }

        double[] reach=new double[n];
        reach[start]=1;

        PriorityQueue<Point> q=new PriorityQueue<>((o1,o2)->{
            return o2.probability>=o1.probability?1:-1;
        });
        q.add(new Point(start,1));

        while(!q.isEmpty()){
            Point cur=q.poll();
            for(Point p:next.get(cur.i)){
                double nextPobability=cur.probability*p.probability;
                if(nextPobability>reach[p.i]){
                    reach[p.i]=nextPobability;
                    q.add(new Point(p.i,nextPobability));
                }
            }
        }

        return reach[end];
    }
}
