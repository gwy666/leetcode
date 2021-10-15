package api;

import java.util.HashMap;
import java.util.Map;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(){

    }
    public TreeNode(int val){
        this.val=val;
    }
    public static TreeNode buildTree(Integer arr[]){
        Map<Integer,TreeNode> map=new HashMap();
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=null){
                TreeNode node=new TreeNode(arr[i]);
                map.put(i,node);
            }
        }
        for(int i=0;i<arr.length;i++){
            if(map.get(i)!=null){
                TreeNode root=map.get(i);
                root.left=map.getOrDefault(2*i+1,null);
                root.right=map.getOrDefault(2*i+2,null);
            }
        }
        return map.get(0);
    }
}
