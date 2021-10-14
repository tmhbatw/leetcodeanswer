package leetcode.leetcode12;

public class Leetcode1118 {

    public int numberOfDays(int year, int month) {
        switch (month){
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                return 31;
            case 2:
                if(year%400==0)
                    return 29;
                if(year%100==0)
                    return 28;
                return year%4==0?29:28;
            default:
                return 30;
        }
    }
}
