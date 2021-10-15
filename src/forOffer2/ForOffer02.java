package forOffer2;

public class ForOffer02 {
    public String addBinary(String a, String b) {
        int count=0;
        StringBuilder sb=new StringBuilder();
        for(int j=0;j<Math.max(a.length(),b.length());j++){
            int valA=a.length()>j?(a.charAt(a.length()-j-1)-'0'):0;
            int valB=b.length()>j?(b.charAt(b.length()-j-1)-'0'):0;
            int cur=valA+valB+count;
            sb.append(cur%2);
            count=cur/2;
        }
        if(count!=0)
            sb.append(count);
        return sb.reverse().toString();
    }
}
