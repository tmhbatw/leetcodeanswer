package leetcode.leetcode5;

public class Leetcode427 {

    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }


    public Node construct(int[][] grid) {
        return construct(grid,0,0,grid.length-1,grid[0].length-1);
    }

    public Node construct(int[][] grid,int r1,int c1,int r2,int c2){
        if(r1==r2&&c1==c2){
            return new Node(getBooleanValue(grid[r1][c1]),true);
        }

        int val=grid[r1][c1];
        for(int i=r1;i<=r2;i++){
            for(int j=c1;j<=c2;j++){
                if(val!=grid[i][j]){
                    Node result=new Node(true,false);
                    result.topLeft=construct(grid,r1,c1,(r1+r2)/2,(c1+c2)/2);
                    result.topRight=construct(grid,r1,(c1+c2)/2+1,(r1+r2)/2,c2);
                    result.bottomLeft=construct(grid,(r1+r2)/2+1,c1,r2,(c1+c2)/2);
                    result.bottomRight=construct(grid,(r1+r2)/2+1,(c1+c2)/2+1,r2,c2);
                    return result;
                }
            }
        }

        return new Node(getBooleanValue(val),true);
    }

    private boolean getBooleanValue(int cur){
        return cur != 0;
    }
}
