package leetcode.leetcode7;

public class Leetcode684 {
    /*Description
    * 在本问题中, 树指的是一个连通且无环的无向图。
    * 输入一个图，该图由一个有着N个节点 (节点值不重复1, 2, ..., N) 的树及一条附加的边构成。
    * 附加的边的两个顶点包含在1到N中间，这条附加的边不属于树中已存在的边。
    * 结果图是一个以边组成的二维数组。每一个边的元素是一对[u, v]，满足u < v，表示连接顶点u和v的无向图的边。
    * 返回一条可以删去的边，使得结果图是一个有着N个节点的树。如果有多个答案，则返回二维数组中最后出现的边。答案边[u, v] 应满足相同的格式u < v
    * */

    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        int[] type=new int[n+1];
        for(int i=1;i<=n;i++){
            type[i]=i;
        }
        for(int[] cur:edges){
            int type1=getType(cur[0],type);
            int type2=getType(cur[1],type);
            if(type1==type2)
                return cur;
            type[type2]=type[type1];
        }
        return null;
    }

    private int getType(int i,int[] type){
        if(type[i]==i)
            return i;
        return getType(type[i],type);
    }
}
