package leetcode.leetcode7;

public class Leetcode672 {

    public int flipLights(int n, int presses) {
        n=Math.min(3,n);

        if(presses==0)
            return 1;

        if(n==1){
            return 2;
        }

        if(n==2){
            if (presses == 1) {
                return 3;
            }
            return 4;
        }

        switch (presses){
            case 1:
                return 4;
            case 2:
                return 7;
            default:
                return 8;
        }
    }
}
