package forOffer2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class ForOffer40 {

    public int maxmiumScore(int[] cards, int cnt) {
        List<Integer> list1=new ArrayList<>();
        List<Integer> list2=new ArrayList<>();
        for(int cur:cards){
            if(cur%2==0)
                list2.add(cur);
            else
                list1.add(cur);
        }
        list1.sort(Comparator.reverseOrder());
        list2.sort(Comparator.reverseOrder());
        int[] sum1=new int[list1.size()+1];
        int[] sum2=new int[list2.size()+1];
        for(int i=1;i<sum1.length;i++){
            sum1[i]=sum1[i-1]+list1.get(i-1);
        }
        for(int i=1;i<sum2.length;i++){
            sum2[i]=sum2[i-1]+list2.get(i-1);
        }

        int result=0;
        int index=0;
        for(;index<=cnt;index+=2){
            int index2=cnt-index;
            if(index>list1.size()||index2>list2.size())
                continue;
            result=Math.max(result,sum1[index]+sum2[index2]);
        }

        return result;
    }


    public int maximalRectangle(String[] matrix) {
        char[][] m=new char[matrix.length][matrix[0].length()];
        for(int i=0;i<matrix.length;i++)
            m[i]=matrix[i].toCharArray();
        if(m==null||m.length==0)
            return 0;
        int row=m.length,col=m[0].length;
        int[][] time=new int[row+1][col];
        int result=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(m[i][j]=='1')
                    time[i+1][j]=time[i][j]+1;
            }
            int[] left=new int[col];
            Stack<int[]> stack=new Stack<>();
            stack.add(new int[]{-1,-1});
            for(int j=0;j<col;j++){
                while(stack.peek()[0]>=time[i+1][j])
                    stack.pop();
                left[j]=stack.peek()[1];
                stack.add(new int[]{time[i+1][j],j});
            }
            stack=new Stack<>();
            stack.add(new int[]{-1,col});
            for(int j=col-1;j>=0;j--){
                while(stack.peek()[0]>=time[i+1][j])
                    stack.pop();
                int right=stack.peek()[1];
                result=Math.max(result,(right-left[j]-1)*time[i+1][j]);
                stack.add(new int[]{time[i+1][j],j});
            }
        }
        return result;
    }
}
