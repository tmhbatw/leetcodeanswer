package leetcode8;

public class Leetcode702 {
    /*Description
    * 给定一个升序整数数组，写一个函数搜索 nums 中数字 target。如果 target 存在，返回它的下标，否则返回 -1。
    * 注意，这个数组的大小是未知的。你只可以通过 ArrayReader 接口访问这个数组，ArrayReader.get(k) 返回数组中第 k 个元素（下标从 0 开始）。
    * 你可以认为数组中所有的整数都小于 10000。如果你访问数组越界，ArrayReader.get 会返回 2147483647。
    * */
    class ArrayReader {
      public int get(int index) {
          return (int)(Math.random()*Integer.MAX_VALUE);
      }
     }
    public int search(ArrayReader reader, int target) {
        int left=0,right=Integer.MAX_VALUE;
        while(left<=right){
            int mid=left+(right-left)/2;
            int val=reader.get(mid);
            if(val<target)
                left=mid+1;
            else if(val>target)
                right=mid-1;
            else
                return mid;
        }
        return -1;
    }


}
