package leetcode.leetcode11;

public class Leetcode1041 {

    int n=0;
    int x=0;
    int y=0;
    public boolean isRobotBounded(String instructions) {
        int[][] next=new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        for(char c:instructions.toCharArray()){
            switch (c){
                case 'R':
                    n++;
                    if(n==4)
                        n=0;
                    break;
                case 'L':
                    n--;
                    if(n<0)
                        n=3;
                    break;
                default:
                    x+=next[n][0];
                    y+=next[n][1];
            }
        }
        return n!=0||x==0&&y==0;

    }

}
