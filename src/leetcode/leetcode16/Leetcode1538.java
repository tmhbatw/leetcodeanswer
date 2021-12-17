package leetcode.leetcode16;

import java.util.Arrays;

public class Leetcode1538 {
     interface ArrayReader {
         // Compares 4 different elements in the array
         // return 4 if the values of the 4 elements are the same (0 or 1).
         // return 2 if three elements have a value equal to 0 and one element has value equal to 1 or vice versa.
         // return 0 : if two element have a value equal to 0 and two elements have a value equal to 1.
         public int query(int a, int b, int c, int d);

         // Returns the length of the array
         public int length();
     };


    public int guessMajority(ArrayReader reader) {
        int length=reader.length();
        int[] num=new int[length];
        //获取前四位的值,设第一位为0；
        num[0]=1;
        if(reader.query(0,2,3,4)== reader.query(1,2,3,4)){
            num[1]=1;
        }
        if(reader.query(0,1,3,4)==reader.query(1,2,3,4)){
            num[2]=1;
        }
        if(reader.query(0,1,2,4)==reader.query(1,2,3,4)){
            num[3]=1;
        }

        for(int i=4;i<length;i++){
            if(reader.query(0,1,2,3)==reader.query(1,2,3,i))
                num[i]=1;
        }

        int sum= Arrays.stream(num).sum();
        if(sum+sum==length)
            return -1;
        int search=sum+sum>length?1:0;
        for(int i=0;i<length;i++){
            if(num[i]==search)
                return i;
        }
        return -1;
    }
}
