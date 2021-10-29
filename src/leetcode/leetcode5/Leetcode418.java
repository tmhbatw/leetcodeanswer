package leetcode.leetcode5;

public class Leetcode418 {

    public int wordsTyping(String[] sentence, int rows, int cols) {
        int count=0;
        int index=0;

        for(int i=0;i<rows;i++){
            int cur=cols;
            while(cur>=sentence[index].length()){
                cur-=sentence[index].length()+1;
                index++;
                if(index==sentence.length){
                    index=0;
                    count++;
                }
            }
        }
        return count;
    }
}
