package leetcode.leetcode3;

public class Leetcode275 {
    /*Description
    *给定一位研究者论文被引用次数的数组（被引用次数是非负整数），数组已经按照升序排列。编写一个方法，计算出研究者的 h 指数。
    * h 指数的定义: “h 代表“高引用次数”（high citations），一名科研人员的 h 指数是指他（她）的 （N 篇论文中）
    * 总共有 h 篇论文分别被引用了至少 h 次。（其余的N - h篇论文每篇被引用次数不多于 h 次。）"
    * */

    public int hIndex(int[] citations) {
        if(citations==null||citations.length==0)
            return 0;
        int number=citations.length;
        int left=0,right=number-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            int time=citations[mid];
            if(time<number-mid)
                left=mid+1;
            else if(mid==number-1||citations[mid+1]<number-mid-1)
                return number-mid;
            else
                right=mid-1;
        }
        return number-left;
    }
}
