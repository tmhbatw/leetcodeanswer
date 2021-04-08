package leetcode.leetcode4;

public class Leetcode365 {
    /*Description
    * 有两个容量分别为 x升 和 y升 的水壶以及无限多的水。请判断能否通过使用这两个水壶，从而可以得到恰好 z升 的水？
    * 如果可以，最后请用以上水壶中的一或两个来盛放取得的 z升 水。
    * 你允许：
    * 装满任意一个水壶
    * 清空任意一个水壶
    * */


    public boolean canMeasureWater(int x, int y, int z) {
        if(x+y<z)
            return false;
        if(z==0)
            return true;
        if(x==0)
            return z%y==0;
        if(y==0)
            return z%x==0;
        int res=getRes(Math.max(x,y),Math.min(x,y));
        return z%res==0;
    }

    private int getRes(int x,int y){
        if(x%y==0){
            return y;
        }
        return getRes(y,x%y);
    }
}
