package leetcode.leetcode21;

import java.util.Arrays;

public class Leetcode2007 {

    public int[] findOriginalArray(int[] changed) {
        if(changed.length%2==1)
            return new int[0];

        Arrays.sort(changed);
        int[] result=new int[changed.length/2];
        boolean[] reached=new boolean[changed.length];

        int index=0;
        int i=0;
        while(i< changed.length&&changed[i]==0){
            if(changed[i+1]!=0)
                return new int[0];
            result[index++]=0;
            i+=2;
        }
        int j=i;
        for(;i<changed.length;i++){
            if(reached[i])
                continue;
            while(j<changed.length&&changed[i]*2>changed[j])
                j++;
            if(j==changed.length||changed[j]>changed[i]*2)
                return new int[0];

            //  System.out.println(i+" "+j+" "+changed[i]+" "+changed[j]);
            reached[j++]=true;
            result[index++]=changed[i];
        }

        return result;
    }

}
