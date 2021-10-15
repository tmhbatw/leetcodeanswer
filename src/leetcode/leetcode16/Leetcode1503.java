package leetcode.leetcode16;

public class Leetcode1503 {
    public String reformatDate(String date) {
        String[] d=date.split(" ");
        int year=Integer.parseInt(d[2]);
        int day=Integer.parseInt(d[0].substring(0,d[0].length()-2));
        int month=getMonth(d[1]);
        String mon=(month<=9?"0":"")+month;
        String da=(day<=9?"0":"")+day;
        return year+"-"+mon+"-"+da;
    }

    private int getMonth(String cur){
        String[] month=new String[]{"Jan", "Feb", "Mar", "Apr", "May",
                "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        for(int i=0;i<month.length;i++){
            if(month[i].equals(cur))
                return i+1;
        }
        return 0;
    }
}
