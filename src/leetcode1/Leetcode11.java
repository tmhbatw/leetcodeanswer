package leetcode1;

public class Leetcode11 {
    /*Description
    * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点(i,ai) 。
    * 在坐标内画 n 条垂直线，垂直线 i的两个端点分别为(i,ai) 和 (i, 0) 。找出其中的两条线，
    * 使得它们与x轴共同构成的容器可以容纳最多的水。
    * */

    public int maxArea(int[] height) {
        int result=0;
        int left=0,right=height.length-1;
        while(left<right){
            result=Math.max(result,(right-left)*Math.min(height[left],height[right]));
            if(height[left]<height[right])
                left++;
            else
                right--;
        }
        return result;
    }
}
