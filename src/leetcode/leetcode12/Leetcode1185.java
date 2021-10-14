package leetcode.leetcode12;

public class Leetcode1185 {
    public String dayOfTheWeek(int day, int month, int year) {
        if(month==1||month==2) {
            month += 12;
            year--;
        }
        int d = (day+2*month+3*(month+1)/5+year+year/4-year/100+year/400)%7;  //基姆拉尔森计算公式
        String[] result = { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday","Sunday"};
        return result[d];
    }
}
