package leetcode.leetcode16;

public class Leetcode1540 {

    public boolean canConvertString(String s, String t, int k) {
        if(s.length()!=t.length())
            return false;
        int[] time=new int[26];
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=t.charAt(i)){
                int cur=t.charAt(i)-s.charAt(i)+(t.charAt(i)<s.charAt(i)?26:0);
                time[cur]++;
            }
        }

        int max=0;
        int maxIndex=0;
        for(int j=25;j>=0;j--){
            if(time[j]>max){
                max=time[j];
                maxIndex=j;
            }
        }
        //System.out.println(max+" "+maxIndex);
        return (max-1)*26+maxIndex<=k;
    }


}
