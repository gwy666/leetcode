package first200;

import api.TreeNode;

public class Lc108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums==null||nums.length==0){
            return null;
        }
        return recur(nums,0,nums.length-1);
    }

    public TreeNode recur(int nums[],int left,int right){
        if(left>right){
            return null;
        }
        int mid=(left+right)/2;
        TreeNode root=new TreeNode(nums[mid]);
        root.left=recur(nums,left,mid-1);
        root.right=recur(nums,mid+1,right);
        return root;
    }
}
