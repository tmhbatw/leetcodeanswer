package forOffer2;

public class ForOffer17 {

    public String minWindow(String s, String t) {
        int[] num=getRes(t);
        int j=0;
        int start=0;
        int res=Integer.MAX_VALUE;
        int[] num1=new int[128];
        for(int i=0;i<s.length();i++){
            while(j<s.length()&&!isBigger(num1,num)){
                num1[s.charAt(j++)]++;
            }
            if(isBigger(num1,num)){
                if(j-i<res){
                    res=j-i;
                    start=i;
                }
            }
            num1[s.charAt(i)]--;
        }
        return res==Integer.MAX_VALUE?"":s.substring(start,start+res);
    }

    private boolean isBigger(int[] num1,int[] num2){
        for(int i=0;i<128;i++){
            if(num1[i]<num2[i])
                return false;
        }
        return true;
    }

    private int[] getRes(String s){
        int[] num=new int[128];
        for(int i=0;i<s.length();i++)
            num[s.charAt(i)]++;
        return num;
    }
}
