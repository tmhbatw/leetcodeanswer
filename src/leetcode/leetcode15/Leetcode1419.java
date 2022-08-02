package leetcode.leetcode15;

public class Leetcode1419 {

    public int minNumberOfFrogs(String croakOfFrogs) {
        int[] time=new int[4];
        int cur=0;
        int result=0;
        for(int i=0;i<croakOfFrogs.length();i++){
            switch (croakOfFrogs.charAt(i)){
                case 'c':
                    time[0]++;
                    cur++;
                    result=Math.max(result,cur);
                    break;
                case 'r':
                    if(time[0]==0)
                        return -1;
                    time[0]--;
                    time[1]++;
                    break;
                case 'o':
                    if(time[1]==0)
                        return -1;
                    time[1]--;
                    time[2]++;
                    break;
                case 'a':
                    if(time[2]==0)
                        return -1;
                    time[2]--;
                    time[3]++;
                    break;
                case 'k':
                    if(time[3]==0)
                        return -1;
                    time[3]--;
                    cur--;
            }
        }
        for(int num:time){
            if(num!=0)
                return -1;
        }
        return result;
    }
}
