package leetcode.leetcode21;

public class Leetcode2079 {


    public int wateringPlants(int[] plants, int capacity) {
        int result=plants.length;

        int curCapacity=capacity;
        for(int i=0;i<plants.length;i++){
            if(curCapacity<plants[i]){
                curCapacity=capacity;
                result+=(i+1)*2;
            }

            curCapacity-=plants[i];
        }
        return result;
    }
}
