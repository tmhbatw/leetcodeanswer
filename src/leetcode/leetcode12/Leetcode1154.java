package leetcode.leetcode12;

public class Leetcode1154 {

    public int dayOfYear(String date) {
        String[] d=date.split("-");
        int year=Integer.parseInt(d[0]);
        int month=Integer.parseInt(d[1]);
        int day=Integer.parseInt(d[2]);
        int result=0;
        for(int i=1;i<month;i++){
            result+=numberOfDays(year,i);
        }
        return result+day;
    }

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
