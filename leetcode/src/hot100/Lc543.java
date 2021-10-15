package hot100;

import api.TreeNode;
import org.junit.Test;

import java.util.Random;

public class Lc543 {

    public int getMaxDepth(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=getMaxDepth(root.left);
        int right=getMaxDepth(root.right);
        return Math.max(left,right)+1;
    }

    @Test
    public void test(){
        Integer arr[]=new Integer[]{4,-7,-3,null,null,-9,-3,9,-7,-4,null,6,null,-6,-6,null,null,0,6,5,null,9,null,null,-1,-4,null,null,null,-2};
        TreeNode root=TreeNode.buildTree(arr);
//        System.out.println(getMaxDepth(root));
        Random random=new Random();
        int n=random.nextInt(10);

    }
}
