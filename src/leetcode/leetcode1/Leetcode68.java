package leetcode.leetcode1;

import java.util.ArrayList;
import java.util.List;

public class Leetcode68 {
    /*Description
    * 给定一个单词数组和一个长度maxWidth，重新排版单词，使其成为每行恰好有maxWidth个字符，且左右两端对齐的文本。
    * 你应该使用“贪心算法”来放置给定的单词；也就是说，尽可能多地往每行中放置单词。
    * 必要时可用空格' '填充，使得每行恰好有 maxWidth个字符。
    * 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。
    * 文本的最后一行应为左对齐，且单词之间不插入额外的空格。
    * 说明:
    * 单词是指由非空格字符组成的字符序列。
    * 每个单词的长度大于 0，小于等于maxWidth。
    * 输入单词数组 words至少包含一个单词。
    * */

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result=new ArrayList<>();
        int wordLength=words.length;
        for(int i=0;i<wordLength;i++){
            int curLength=words[i].length();
            int start=i;
            StringBuilder sb=new StringBuilder();
            sb.append(words[start]);
            while(i<wordLength-1&&curLength+words[i+1].length()+1<=maxWidth){
                curLength+=words[i+1].length()+1;
                i++;
            }
            if(i==wordLength-1){
                for(int j=start+1;j<=i;j++)
                    sb.append(" ").append(words[j]);
                addSpace(sb,maxWidth-sb.length());
            }else{
                int left=maxWidth-curLength;
                int curWordLength=i-start+1;
                if(curWordLength==1){
                    addSpace(sb,maxWidth-sb.length());
                }else {
                    int spaceNumber=left/(curWordLength-1);
                    left -= spaceNumber * (curWordLength - 1);
                    for (int j = start + 1; j < start + 1 + left; j++) {
                        addSpace(sb, spaceNumber + 2);
                        sb.append(words[j]);
                    }
                    for (int j = start + 1 + left; j <= i; j++) {
                        addSpace(sb, spaceNumber + 1);
                        sb.append(words[j]);
                    }
                }
            }
            result.add(sb.toString());
        }
        return result;
    }

    private void addSpace(StringBuilder sb,int spaceNumber){
        while(spaceNumber-->0)
            sb.append(" ");
    }
}
