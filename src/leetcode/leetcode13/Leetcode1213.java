package leetcode.leetcode13;

import java.util.ArrayList;
import java.util.List;

public class Leetcode1213 {

    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        int index2=0;
        int index3=0;
        int length2=arr2.length;
        int length3=arr3.length;

        List<Integer> result=new ArrayList<>();
        for(int i=0;i<arr1.length;i++){
            while(index2<length2&&arr2[index2]<arr1[i])
                index2++;
            while(index3<length3&&arr3[index3]<arr1[i])
                index3++;
            if(index2==length2||index3==length3)
                return result;
            if(arr2[index2]==arr1[i]&&arr3[index3]==arr1[i])
                result.add(arr1[i]);
        }

        return result;
    }
}
