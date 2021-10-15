package first200;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Lc47 {

    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean vis[]=new boolean[nums.length];
        backtrack(nums,0,new LinkedList<>(),vis);


        return res;
    }
    public void backtrack(int nums[], int idx, LinkedList<Integer> track,boolean vis[]){
        if(idx==nums.length){
            res.add(new LinkedList<>(track));
            return ;
        }
        for(int i=0;i<nums.length;i++){
            if(i>0&&nums[i]==nums[i-1]&&!vis[i-1]||vis[i]){
                continue;
            }
            track.add(nums[i]);
            vis[i]=true;
            backtrack(nums,idx+1,track,vis);
            track.removeLast();
            vis[i]=false;
        }
    }
    @Test
    public void test(){
        int nums[]=new int[]{1,1,3};
        System.out.println(permuteUnique(nums));
    }
}
