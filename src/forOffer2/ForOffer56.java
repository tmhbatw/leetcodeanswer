package forOffer2;

import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class ForOffer56 {

    List<Integer> list=new ArrayList<>();
    public boolean findTarget(TreeNode root, int k) {
        inOrder(root);
        int l=0,r=list.size()-1;
        while(l<r){
            if(list.get(l)+list.get(r)==k)
                return true;
            if(list.get(l)+list.get(r)<k)
                l++;
            else
                r--;
        }
        return false;
    }

    private void inOrder(TreeNode root){
        if(root==null)
            return ;
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }
}
