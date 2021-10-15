package offer;

import api.TreeNode;

public class Of26 {

    boolean res=false;
    public boolean isSubStructure(TreeNode A, TreeNode B) {
       if(B==null){
           return false;
       }
       dfs(A,B);
       return res;
    }
    public void dfs(TreeNode A,TreeNode B){
        if(A==null){
            return ;
        }
        res=res||check(A,B);
        if(res){
            return ;
        }
        dfs(A.left,B);
        dfs(A.right,B);
    }
    public boolean check(TreeNode A,TreeNode B){
        if(B==null){
            return true;
        }
        if(A==null||A.val!=B.val)return false;

        return check(A.left,B.left)&&check(A.right,B.right);
    }
}
