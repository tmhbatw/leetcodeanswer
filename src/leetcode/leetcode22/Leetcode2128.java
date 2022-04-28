package leetcode.leetcode22;

public class Leetcode2128 {

    public boolean removeOnes(int[][] grid) {
        String base = getRes(grid[0]);
        for(int i=1;i<grid.length;i++){
            if(!getRes(grid[i]).equals(base))
                return false;
        }
        return true;
    }

    private String getRes(int[] grid){
        int count = 0;
        int pre = -1;

        StringBuilder sb=new StringBuilder();
        for(int num:grid){
            if(num==pre){
                count++;
            }else{
                sb.append(count).append(" ");
                pre = num;
                count = 1;
            }
        }
        sb.append(count);

        return sb.toString();
    }

}
