package leetcode3;

public class Leetcode274 {
    /*Description
    * 给定一位研究者论文被引用次数的数组（被引用次数是非负整数）。编写一个方法，计算出研究者的 h指数。
    * h 指数的定义：h 代表“高引用次数”（high citations），一名科研人员的 h 指数是指他（她）的 （N 篇论文中）
    * 总共有 h 篇论文分别被引用了至少 h 次。且其余的N - h篇论文每篇被引用次数不超过 h 次。
    * 例如：某人的 h 指数是 20，这表示他已发表的论文中，每篇被引用了至少 20 次的论文总共有 20 篇。
    * */

    public int hIndex(int[] citations) {
        int number=citations.length;
        int max=0;
        for(int cur:citations)
            max=Math.max(cur,max);
        int[] dp=new int[max+2];
        for(int cur:citations)
            dp[cur+1]++;
        for(int i=1;i<=max+1;i++)
            dp[i]+=dp[i-1];
        int left=0,right=max;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(mid>number-dp[mid])
                right=mid-1;
            else if(mid+1>number-dp[mid+1])
                return mid;
            else
                left=mid+1;
        }
        return left;
    }
}
