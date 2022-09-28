package lcp;

import datastructure.TreeNode;

import java.lang.reflect.Array;
import java.util.Arrays;

public class lcp64 {

    public int closeLampInTree(TreeNode root) {

        return getRes(root)[0];
    }


    private int[] getRes(TreeNode root){
        if(root==null)
            return new int[4];

        int[] l=getRes(root.left);
        int[] r=getRes(root.right);
        int[] result=new int[4];

        //返回三个值  第一个，全暗的最小操作次数
        //          第二个，全亮的最小操作次数
        //          第三个，根结点亮，其次暗的最小操作次数
        //          第四个，根结点暗，其余亮的最小操作次数
        if(root.val==1){
            result[0]=Math.min(1+l[0]+r[0],1+l[1]+r[1]);
            result[0]=Math.min(result[0],1+l[2]+r[2]);

            result[1]=Math.min(l[1]+r[1],2+l[0]+r[0]);
            result[1]=Math.min(result[1],2+l[3]+r[3]);
            result[1]=Math.min(result[1],2+l[2]+r[2]);

            result[2]=Math.min(l[0]+r[0],2+l[1]+r[1]);
            result[2]=Math.min(result[2],2+l[2]+r[2]);
            result[2]=Math.min(result[2],2+l[3]+r[3]);



            result[3]=Math.min(1+l[1]+r[1],1+l[0]+r[0]);
            result[3]=Math.min(result[3],1+l[3]+r[3]);
        }else{
            result[0]=Math.min(l[0]+r[0],2+l[1]+r[1]);
            result[0]=Math.min(result[0],2+l[2]+r[2]);
            result[0]=Math.min(result[0],2+r[3]+l[3]);

            result[1]=Math.min(1+l[1]+r[1],1+r[0]+l[0]);
            result[1]=Math.min(result[1],1+r[3]+l[3]);


            result[2]=Math.min(1+l[0]+r[0],1+l[1]+r[1]);
            result[2]=Math.min(result[2],1+l[2]+r[2]);

            result[3]=Math.min(l[1]+r[1],2+l[0]+r[0]);
            result[3]=Math.min(result[3],2+r[2]+l[2]);
            result[3]=Math.min(result[3],2+l[3]+r[3]);
        }


        return result;
    }


}
