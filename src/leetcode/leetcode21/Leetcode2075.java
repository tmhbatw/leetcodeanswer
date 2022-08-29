package leetcode.leetcode21;

public class Leetcode2075 {

    public String decodeCiphertext(String encodedText, int rows) {
        if(encodedText.length()==0)
            return "";
        int length=encodedText.length();
        int col=length/rows;

        char[][] res=new char[rows][col];
        for(int i=0;i<rows;i++)
            res[i]=encodedText.substring(i*col,(i+1)*col).toCharArray();

        StringBuilder sb=new StringBuilder();
        for(int j=0;j<col-rows+1;j++){
            for(int i=0;i<rows;i++){
                sb.append(res[i][i+j]);
            }
        }
        for(int i=0;i<rows-1;i++)
            sb.append(res[i][i+col-rows+1]);
        int index=sb.length()-1;
        while(sb.charAt(index)==' ')
            index--;
        return sb.substring(0,index+1);
    }
}
