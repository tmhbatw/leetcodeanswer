package interview;

import java.util.*;

public class Problem16_19 {
    /*Description
    * 你有一个用于表示一片土地的整数矩阵land，该矩阵中每个点的值代表对应地点的海拔高度。
    * 若值为0则表示水域。由垂直、水平或对角连接的水域为池塘。池塘的大小是指相连接的水域的个数。
    * 编写一个方法来计算矩阵中所有池塘的大小，返回值需要从小到大排序。
    * */

    List<Integer> set;
    int size=0;
    int row,col;
    int[][] land;
    public int[] pondSizes(int[][] land) {
        if(land.length==0)
            return new int[0];
        set=new ArrayList<>();
        this.land=land;
        row=land.length;
        col=land[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(land[i][j]==0){
                    size=0;
                    dfs(i,j);
                    set.add(size);
                }
            }
        }
        int[] res=new int[set.size()];
        int index=0;
        for(int cur:set)
            res[index++]=cur;
        Arrays.sort(res);
        return res;
    }

    private void dfs(int i,int j){
        if(i>=0&&i<row&&j>=0&&j<col&&land[i][j]==0){
            size++;
            land[i][j]=1;
            dfs(i+1,j);
            dfs(i-1,j);
            dfs(i,j+1);
            dfs(i,j-1);
            dfs(i-1,j-1);
            dfs(i-1,j+1);
            dfs(i+1,j-1);
            dfs(i+1,j+1);
        }
    }
}
