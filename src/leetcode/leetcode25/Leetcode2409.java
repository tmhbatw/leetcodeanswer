package leetcode.leetcode25;

public class Leetcode2409 {
    int[] month=new int[]{0,31,28,31,30,31,30,31,31,30,31,30,31};
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        String start=arriveAlice;
        if(arriveBob.compareTo(arriveAlice)>0)
            start =arriveBob;
        String end = leaveAlice;
        if(leaveBob.compareTo(leaveAlice)<0)
            end = leaveBob;

        if(start.compareTo(end)>0)
            return 0;

        int[] p1=parseStr(start);
        int[] p2=parseStr(end);
        if(p1[0]==p2[0]){
            return (p2[1]-p1[1]+1);
        }
        int result = 0;
        for(int i=p1[0]+1;i<=p2[0]-1;i++)
            result+=month[i];
        return result+p2[1]+month[p1[0]]-p1[1]+1;
    }

    private int[] parseStr(String s){
        String[] result=s.split(":");
        return new int[]{Integer.parseInt(result[0]),Integer.parseInt(result[1])};
    }
}
