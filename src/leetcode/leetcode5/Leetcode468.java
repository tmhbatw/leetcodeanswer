package leetcode.leetcode5;

public class Leetcode468 {

    public String validIPAddress(String queryIP) {
        if(isIPv4(queryIP)){
            return "IPv4";
        }
        if(isIPv6(queryIP)){
            return "IPv6";
        }
        return "Neither";
    }

    private boolean isIPv4(String ip){
        String[] s=ip.split("\\.");
        if(s.length!=4||ip.charAt(ip.length()-1)=='.')
            return false;
        for(String str:s){
            if(!isStrIpv4(str))
                return false;
        }
        return true;
    }

    private boolean isStrIpv4(String s){
        if(s.length()==0)
            return false;
        if(s.equals("0"))
            return true;
        if(s.charAt(0)=='0'||s.length()>3)
            return false;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)>'9'||s.charAt(i)<'0')
                return false;
        }
        return Integer.parseInt(s)<=255;
    }

    private boolean isIPv6(String ip){
        String[] s=ip.split(":");
        if(s.length!=8||ip.charAt(ip.length()-1)==':')
            return false;
        for(String str:s){
            if(!isStrIPv6(str))
                return false;
        }
        return true;
    }

    private boolean isStrIPv6(String s){
        if(s.length()>4||s.length()==0)
            return false;


        for(int i=0;i<s.length();i++){
            char cur=s.charAt(i);
            if(cur=='.'||cur<='Z'&&cur>'F'||cur<='z'&&cur>'f')
                return false;
        }
        return true;
    }
}
