package leetcode.leetcode12;

public class Leetcode1103 {

    public int[] distributeCandies(int candies, int num_people) {
        int[] num=new int[num_people];
        int base=1;
        int i=0;
        while(candies>0){
            num[i]+=Math.min(base,candies);
            i++;
            if(i==num_people)
                i=0;
            candies-=base;
            base++;
        }
        return num;
    }
}
