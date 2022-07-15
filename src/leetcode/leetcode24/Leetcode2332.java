package leetcode.leetcode24;

import java.util.Arrays;

public class Leetcode2332 {

    //计算最后一个能上公交车的人

    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        Arrays.sort(buses);
        Arrays.sort(passengers);
        int i=0;
        int j=0;
        int[] bus=new int[buses.length];

        for(;i<passengers.length;i++){
            while(j<buses.length&&passengers[i]>buses[j]) {
                j++;
            }
            if(j==buses.length||j==buses.length-1&&bus[j]==capacity)
                break;
            if(bus[j]==capacity)
                j++;
            bus[j]++;
            // System.out.println(i+" "+j+" "+curCount);
        }

        //此时从0到i-1的人都在车上
        //当还有空位时
        if(bus[bus.length-1]<capacity){
            if(i==0||passengers[i-1]<buses[buses.length-1])
                return buses[buses.length-1];
            i--;
            while(i>=1&&passengers[i-1]+1==passengers[i])
                i--;
            return passengers[i]-1;
        }

        //没有空位把最后一个上车的人踢掉
        i--;
        while(i>=1&&passengers[i-1]+1==passengers[i])
            i--;
        return passengers[i]-1;
    }
}
