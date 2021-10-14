package leetcode.leetcode9;

public class Leetcode860 {

    public boolean lemonadeChange(int[] bills) {
        int fiveNumber=0;
        int tenNumber=0;
        for(int cur:bills){
            switch (cur){
                case 5:
                    fiveNumber++;
                    break;
                case 10:
                    fiveNumber--;
                    tenNumber++;
                    if(fiveNumber<0)
                        return false;
                    break;
                default:
                    if(tenNumber>0&&fiveNumber>0){
                        tenNumber--;
                        fiveNumber--;
                    }else{
                        fiveNumber-=3;
                        if(fiveNumber<0)
                            return false;
                    }
            }
        }
        return true;
    }
}
