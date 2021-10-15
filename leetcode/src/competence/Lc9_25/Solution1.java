package competence.Lc9_25;

import api.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class Solution1 {
    int res=0;
    Set<Integer> set=new HashSet<>();
    public int numColor(TreeNode root) {
        dfs(root);
        return res;

    }
    public void dfs(TreeNode root){
        if(root==null)return ;
        if(!set.contains(root.val)){
            res++;
            set.add(root.val);
        }
        dfs(root.left);
        dfs(root.right);
    }
}
