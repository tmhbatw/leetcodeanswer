package leetcode.leetcode6;

public class Leetcode573 {
    /*Description
    * 现在有一棵树，一只松鼠和一些坚果。位置由二维网格的单元格表示。
    * 你的目标是找到松鼠收集所有坚果的最小路程，且坚果是一颗接一颗地被放在树下。
    * 松鼠一次最多只能携带一颗坚果，松鼠可以向上，向下，向左和向右四个方向移动到相邻的单元格。移动次数表示路程。
    * */

    public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
        int result=0;
        int save=Integer.MAX_VALUE;
        for(int[] nut:nuts){
            int treeNutDistance=getDistance(tree,nut);
            result+=treeNutDistance*2;
            save=Math.min(save,getDistance(squirrel,nut)-treeNutDistance);
        }
        return result+save;
    }

    private int getDistance(int[] cur1,int[] cur2){
        return Math.abs(cur1[0]-cur2[0])+Math.abs(cur1[1]-cur2[1]);
    }
}
