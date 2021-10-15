package first200;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Lc46 {

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        boolean dp[]=new boolean[nums.length];
        backtrack(nums,0,new LinkedList<>(),dp);
        return res;
    }
    public void backtrack(int nums[], int idx, LinkedList<Integer> track,boolean dp[]){
        if(idx==nums.length){
            res.add(new LinkedList<>(track));
            return ;
        }
        for(int i=0;i<nums.length;i++){
            if(dp[i]){
                continue;
            }
            track.add(nums[i]);
            dp[i]=true;
            backtrack(nums,idx+1,track,dp);
            track.removeLast();
            dp[i]=false;
        }

    }
    @Test
    public void test(){
        int nums[]=new int[]{1,2,3};
        System.out.println(permute(nums));
    }
}
