package leetcode.leetcode22;

public class Leetcode2105 {

    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int curA=capacityA,curB=capacityB;

        int result=0;
        int length=plants.length;
        for(int i=0;i<length/2;i++){
            if(curA<plants[i]){
                result++;
                curA=capacityA;
            }
            curA-=plants[i];
            if(curB<plants[length-i-1]){
                result++;
                curB = capacityB;
            }
            curB-=plants[length-i-1];
        }

        if(length%2==1){
            if(curA<plants[length/2]&&curB<plants[length/2])
                result++;
        }

        return result;
    }
}
