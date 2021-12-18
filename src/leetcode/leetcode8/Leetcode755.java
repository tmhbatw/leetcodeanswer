package leetcode.leetcode8;

public class Leetcode755 {

    public int[] pourWater(int[] heights, int volume, int k) {
        while(volume-->0){
            int min=k;
            for(int j=k-1;j>=0;j--){
                if(heights[j]>heights[j+1])
                    break;
                if(heights[j]<heights[min]){
                    min=j;
                }
            }

            if(min!=k) {
                heights[min]++;
                continue;
            }

            for(int i=k+1;i<heights.length;i++){
                if(heights[i]>heights[i-1])
                    break;
                if(heights[i]<heights[min])
                    min=i;
            }
            heights[min]++;
        }
        return heights;
    }
}
