package leetcode.leetcode25;

import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode2415 {

    public TreeNode reverseOddLevels(TreeNode root) {
        List<TreeNode> list=new ArrayList<>();
        list.add(root);

        boolean reverse= false;
        while(list.size()>0){
            if(reverse){
                for(int i=0;i<list.size()/2;i++){
                    int pre=list.get(i).val;
                    list.get(i).val=list.get(list.size()-1-i).val;
                    list.get(list.size()-1-i).val=pre;
                }
            }

            List<TreeNode> next=new ArrayList<>();
            for(TreeNode cur:list){
                if(cur.left!=null)
                    next.add(cur.left);
                if(cur.right!=null)
                    next.add(cur.right);
            }

            reverse = !reverse;
            list=next;
        }
        return root;
    }

}
