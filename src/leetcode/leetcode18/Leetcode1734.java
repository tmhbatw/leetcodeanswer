package leetcode.leetcode18;

import java.lang.reflect.GenericDeclaration;

public class Leetcode1734 {
    public int[] decode(int[] encoded) {
        int xor=0;
        for(int i=1;i<=encoded.length+1;i++)
            xor^= i;
        for(int i=1;i< encoded.length;i+=2)
            xor^=encoded[i];
        int[] result=new int[encoded.length+1];
        result[0]=xor;
        for(int i=1;i<result.length;i++){
            result[i]=result[i-1]^encoded[i-1];
        }
        return result;
    }
}
