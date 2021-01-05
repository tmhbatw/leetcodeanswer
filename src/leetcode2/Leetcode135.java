package leetcode2;

import java.util.Arrays;

public class Leetcode135 {
    /*Description
    * 老师想给孩子们分发糖果，有 N个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
    * 你需要按照以下要求，帮助老师给这些孩子分发糖果：
    * 每个孩子至少分配到 1 个糖果。
    * 评分更高的孩子必须比他两侧的邻位孩子获得更多的糖果。
    * 那么这样下来，老师至少需要准备多少颗糖果呢？
    * */

    public int candy(int[] ratings) {
        if(ratings==null||ratings.length==0)
            return 0;
        int length=ratings.length;
        int[] numLeft=new int[length];
        numLeft[0]=1;
        for(int i=1;i<length;i++){
            if(ratings[i]>ratings[i-1])
                numLeft[i]=numLeft[i-1]+1;
            else
                numLeft[i]=1;
        }
        int[] numRight=new int[length];
        numRight[length-1]=1;
        for(int i=length-2;i>=0;i--){
            if(ratings[i]>ratings[i+1])
                numRight[i]=numRight[i+1]+1;
            else
                numRight[i]=1;
        }
        int result=0;
        for(int i=0;i<length;i++)
            result+=Math.max(numLeft[i],numRight[i]);
        return result;
    }
}
