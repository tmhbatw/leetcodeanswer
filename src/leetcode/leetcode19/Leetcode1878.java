package leetcode.leetcode19;

import java.util.PriorityQueue;

public class Leetcode1878 {

    public int[] getBiggestThree(int[][] grid) {
        PriorityQueue<Integer> p=new PriorityQueue<>((o1,o2)->{
            return o1-o2;
        });


        int m=grid.length,n=grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){

                for(int l=0;l<=j;l+=2){
                    int i1=i-l/2;
                    int i2=i+l/2;
                    if(i1<0||i2>=m)
                        break;

                    int j1=j-l;
                    int j2=j;

                    int curSum = 0;
                    for(int ii=i,jj=j1;ii>=i1;ii--,jj++){
                        curSum += grid[ii][jj];
                    }
                    for(int ii=i,jj=j2;ii>i1;ii--,jj--){
                        curSum += grid[ii][jj];
                    }
                    for(int ii=i+1,jj=j1+1;ii<=i2;ii++,jj++){
                        curSum += grid[ii][jj];
                    }
                    for(int ii=i+1,jj=j2-1;ii<i2;ii++,jj--){
                        curSum += grid[ii][jj];
                    }

                    if(p.contains(curSum))
                        continue;
                    p.add(curSum);
                    if(p.size()>3)
                        p.poll();
                }
            }
        }

        int[] result=new int[p.size()];
        for(int i=result.length-1;i>=0;i--)
            result[i]=p.poll();
        return result;
    }


}
