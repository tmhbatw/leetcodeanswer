package leetcode.leetcode21;

public class Leetcode2029 {

    public boolean stoneGameIX(int[] stones) {
        int count1=0;
        int count0=0;
        int count2=0;

        for(int num:stones){
            switch (num%3){
                case 0:
                    count0++;
                    break;
                case 1:
                    count1++;
                    break;
                default:
                    count2++;
            }
        }

        if(count1==0&&count2==0){
            return false;
        }

        if(count1==0){
            if(count2<=2)
                return false;
            return  (2 +count0)%2==1;
        }

        if(count2==0){
            if(count1<=2)
                return false;
            return (2+count0)%2==1;
        }

        //先拿1，再拿1，再拿2，再拿1，再拿2，再拿1  or
        //先拿2，再拿2，再拿1，再拿2，再拿1，再拿2
        return getOne(count0,count1,count2)||getTwo(count0,count1,count2);
    }

    private boolean getOne(int c0,int c1,int c2) {
        boolean alice=false;
        c1--;
        if(c0%2==0){
            alice=true;
        }
        if(c1==0)
            return alice;
        c1--;
        alice=!alice;
        if(c1==c2)
            return false;
        if(c2<c1)
            return alice;
        return !alice;
    }

    private boolean getTwo(int c0,int c1,int c2) {
        boolean alice=false;
        c2--;
        if(c0%2==0){
            alice=true;
        }
        if(c2==0)
            return alice;
        c2--;
        alice=!alice;
        if(c1==c2)
            return false;
        if(c1<c2)
            return alice;
        return !alice;
    }

}
