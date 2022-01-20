package leetcode.leetcode22;

public class Leetcode2120 {

    public int[] executeInstructions(int n, int[] startPos, String s) {
        int[] result=new int[s.length()];
        for(int i=0;i<s.length();i++){
            int ii=startPos[0];
            int jj=startPos[1];

            int j=i;
            for(;j<s.length();j++){
                switch (s.charAt(j)){
                    case 'R':
                        jj++;
                        break;
                    case 'L':
                        jj--;
                        break;
                    case 'U':
                        ii--;
                        break;
                    case 'D':
                        ii++;
                        break;
                }

                if(ii>=n||jj>=n||ii<0||jj<0)
                    break;
            }
            result[i]=j-i;

        }
        return result;
    }
}
