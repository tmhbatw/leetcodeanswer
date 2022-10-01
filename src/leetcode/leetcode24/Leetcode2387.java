package leetcode.leetcode24;

public class Leetcode2387 {

    public int matrixMedian(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        int count= m*n/2;

        int l=0,r=1000000;
        while(l<r){
            int mid=l+(r-l+1)/2;
            if(match(mid,grid,count)){
                l=mid;
            }else{
                r=mid-1;
            }
        }

        return l;
    }

    private boolean match(int mid,int[][] grid,int count){
        int cur=0;
        for(int[] num:grid){
            int l=0,r=num.length-1;
            if(num[0]>=mid){
                continue;
            }
            while(l<r){
                int m=(l+r+1)/2;
                if(num[m]>=mid){
                    r=m-1;
                }else{
                    l=m;
                }
            }
            cur+=l+1;
        }
        return cur<=count;
    }

}
