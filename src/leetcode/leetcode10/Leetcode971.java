package leetcode.leetcode10;

import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode971 {

    List<Integer> result=new ArrayList<>();
    boolean flag=false;
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        reverse(root,voyage,0,voyage.length-1);
        if(flag){
            result=new ArrayList<>();
            result.add(-1);
            return result;
        }
        return result;
    }

    private void reverse(TreeNode root,int[] voyage, int start,int end){
        if(root==null||flag)
            return;
        if(start>end||root.val!=voyage[start]){
            flag=true;
            return;
        }

        if(root.left==null&&root.right==null){
            if(start!=end){
                flag=true;
            }
            return;
        }
        if(root.left==null){
            reverse(root.right,voyage,start+1,end);
        }else if(root.right==null){
            reverse(root.left,voyage,start+1,end);
        }else{
            if(end-start<=0||(voyage[start+1]!=root.left.val&&voyage[start+1]!=root.right.val)){
                flag=true;
                return;
            }
            if(voyage[start+1]==root.left.val){
                for(int j=start+2;j<=end;j++){
                    if(voyage[j]==root.right.val){
                        reverse(root.left,voyage,start+1,j-1);
                        reverse(root.right,voyage,j,end);
                        return;
                    }
                }
                flag=true;
            }else{
                result.add(root.val);
                for(int j=start+2;j<=end;j++){
                    if(voyage[j]==root.left.val){
                        reverse(root.right,voyage,start+1,j-1);
                        reverse(root.left,voyage,j,end);
                        return;
                    }
                }
                flag=true;
            }
        }
    }

}
