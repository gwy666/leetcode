package hot100;

import api.TreeNode;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Lc337 {
    int res=0;
    Map<TreeNode ,Integer> stole=new HashMap<>();
    Map<TreeNode ,Integer> unStole=new HashMap<>();
    public int rob(TreeNode root) {

        recur(root);
        return res;
    }
    public void recur(TreeNode root){
        if(root==null)return ;
        recur(root.left);
        recur(root.right);
        int n=unStole.getOrDefault(root.left,0)+unStole.getOrDefault(root.right,0)+root.val;
        int m=Math.max(stole.getOrDefault(root.left,0),unStole.getOrDefault(root.left,0))+Math.max(stole.getOrDefault(root.right,0),unStole.getOrDefault(root.right,0));
        stole.put(root,n);
        unStole.put(root,m);
        res=Math.max(n,m);

    }

    @Test
    public void test(){
        Integer arr[]=new Integer[]{3,2,3,null,3,null,1};
        System.out.println(rob(TreeNode.buildTree(arr)));
    }
}
