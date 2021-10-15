package tencent;


import api.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution4 {

    Map<Integer,TreeNode> map=new HashMap<>();
    Map<TreeNode,TreeNode>  parent=new HashMap<>();
    public TreeNode solve (TreeNode root, int[][] b) {
        dfs(root);
        for(int a[]:b){
            int x=a[0];
            int y=a[1];
            TreeNode p=map.get(x);
            TreeNode q=map.get(y);
            if(!check(p,q)){
                TreeNode parentP=parent.get(p);
                TreeNode parentQ=parent.get(q);
                boolean pLeft=parentP.left==p?true:false;
                boolean qLeft=parentQ.left==q?true:false;
                if(pLeft&&qLeft){
                    parentP.left=q;
                    parentQ.left=p;
                }
                else if(!pLeft&&qLeft){
                    parentP.right=q;
                    parentQ.left=p;
                }
                else if(pLeft&&!qLeft){
                    parentP.left=q;
                    parentQ.right=p;
                }
                else{
                    parentP.right=q;
                    parentQ.right=p;
                }
            }
        }
        return root;
    }

    public void dfs(TreeNode root){
        if(root==null){
            return ;
        }
        map.put(root.val,root);
        if(root.left!=null)parent.put(root.left,root);
        if(root.right!=null)parent.put(root.right,root);
        dfs(root.left);
        dfs(root.right);
    }
    public boolean check(TreeNode p,TreeNode q){
        TreeNode temp=p;
        while(parent.get(p)!=null){
            if(parent.get(p)==q){
                return true;
            }
            p=parent.get(p);
        }
        p=temp;
        while(parent.get(q)!=null){
            if(parent.get(q)==p){
                return true;
            }
            q=parent.get(q);
        }
        return false;
    }
}
