package interview;

public class Problem16_11 {
    /*Description
    * 你正在使用一堆木板建造跳水板。有两种类型的木板，其中长度较短的木板长度为shorter，
    * 长度较长的木板长度为longer。你必须正好使用k块木板。编写一个方法，生成跳水板所有可能的长度。
    * 返回的长度需要从小到大排列。
    * */

    public int[] divingBoard(int shorter, int longer, int k) {
        if(k==0)
            return new int[0];
        if(shorter==longer){
            return new int[]{shorter*k};
        }
        int[] res=new int[k+1];
        res[0]=shorter*k;
        for(int i=1;i<=k;i++)
            res[i]=res[i-1]+longer-shorter;
        return res;
    }
}
