package first200;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Lc78 {


    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums,0,new LinkedList<>());
        return res;
    }
    public void backtrack(int nums[], int idx, LinkedList<Integer> track){
        if(idx==nums.length){
            res.add(new LinkedList<>(track));
            return ;
        }
        track.add(nums[idx]);
        backtrack(nums,idx+1,track);
        track.removeLast();
        backtrack(nums,idx+1,track);
    }
    @Test
    public void test(){
        int nums[]=new int[]{1,2,3};
        System.out.println(subsets(nums));
    }
}
