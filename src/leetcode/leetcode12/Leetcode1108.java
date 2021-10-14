package leetcode.leetcode12;

public class Leetcode1108 {
    public String defangIPaddr(String address) {
        String[] s=address.split("\\.");
        StringBuilder sb=new StringBuilder(s[0]);
        for(int i=1;i<s.length;i++)
            sb.append("[.]").append(s[i]);
        return sb.toString();
    }
}
