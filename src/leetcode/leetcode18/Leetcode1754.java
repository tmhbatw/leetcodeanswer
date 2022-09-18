package leetcode.leetcode18;

public class Leetcode1754 {

    //将比较开头的字符改为比较开头的非递减序列
    public String largestMerge(String word1, String word2) {
        StringBuilder sb=new StringBuilder();
        int i=0,j=0;
        while(i<word1.length()||j<word2.length()){
            if(i==word1.length()){
                return sb.append(word2.substring(j)).toString();
            }
            if(j==word2.length()){
                return sb.append(word1.substring(i)).toString();
            }

            if(word1.substring(i).compareTo(word2.substring(j))<0){
                sb.append(word2.charAt(j++));
            }else{
                sb.append(word1.charAt(i++));
            }
        }

        return sb.toString();
    }

}
