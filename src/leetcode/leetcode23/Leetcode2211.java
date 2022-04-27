package leetcode.leetcode23;

public class Leetcode2211 {

    public int countCollisions(String directions) {
        int rTime = 0;
        int result = 0;
        boolean left=false;

        for(char cur:directions.toCharArray()){
            switch (cur){
                case 'R':
                    rTime++;
                    break;
                case 'S':
                    result += rTime;
                    rTime = 0;
                    left = true;
                case 'L':
                    if (rTime !=0){
                        result += rTime +1;
                        rTime =0;
                        left = true;
                    }
                    else if(left){
                        result++;
                    }
            }
        }
        return result;

    }
}
