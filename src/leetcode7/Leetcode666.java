package leetcode7;

public class Leetcode666 {
    /*Description
    * 对于一棵深度小于5的树，可以用一组三位十进制整数来表示。
    * 对于每个整数：
    * 百位上的数字表示这个节点的深度 D，1 <= D <= 4。
    * 十位上的数字表示这个节点在当前层所在的位置 P， 1 <= P <= 8。位置编号与一棵满二叉树的位置编号相同。
    * 个位上的数字表示这个节点的权值 V，0 <= V <= 9。
    * 给定一个包含三位整数的升序数组，表示一棵深度小于 5 的二叉树，请你返回从根到所有叶子结点的路径之和。
    * */

    public int pathSum(int[] nums) {
        int[][] time=new int[5][9];
        for(int i=0;i<5;i++){
            for(int j=0;j<9;j++)
                time[i][j]=-1;
        }
        int result=0;
        for(int cur:nums){
            int row=cur/100;
            int col=(cur%100)/10;
            int val=cur%10;
            time[row][col]=val;
        }
        for(int i=0;i<5;i++){
            for(int j=0;j<9;j++){
                if(time[i][j]!=-1&&(i==4||time[i+1][j*2-1]==-1&&time[i+1][j*2]==-1)){
                    result+=time[i][j];
                    int col=j;
                    for(int k=i-1;k>=1;k--){
                        result+=time[k][(col+1)/2];
                        col=(col+1)/2;
                    }
                }
            }
        }
        return result;
    }
}
