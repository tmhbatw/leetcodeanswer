package leetcode.leetcode24;

import datastructure.ListNode;

import java.util.Arrays;

public class Leetcode2326 {

    int[][] newPos=new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    int index = 0;

    int curx=0,cury=0;
    int m;
    int n;

    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] result=new int[m][n];
        for(int[] cur:result)
            Arrays.fill(cur,-1);
        this.m=m;
        this.n=n;

        while(head!=null){
            int cur = head.val;
            head=head.next;
            addNode(result,cur);
        }

        return result;
    }

    private void addNode(int[][] result,int cur){
        //System.out.println(curx+" "+cury);
        result[curx][cury]=cur;

        int nextx=curx+newPos[index][0];
        int nexty=cury+newPos[index][1];
        if(nexty>=n||nexty<0||nextx>=m||nextx<0||result[nextx][nexty]!=-1){
            index++;
            if(index==4)
                index=0;
            curx+=newPos[index][0];
            cury+=newPos[index][1];
        }else{
            curx=nextx;
            cury=nexty;
        }
    }

}
