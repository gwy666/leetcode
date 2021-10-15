package first200;

import org.junit.Test;

import java.util.*;

public class Lc39 {


    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(candidates,0,new LinkedList<>(),target);
        Arrays.sort(candidates);
        return res;
    }
    public void backtrack(int candidates[],int idx, LinkedList<Integer> track,int target){
        if(target==0){
            res.add(new LinkedList<>(track));
            return ;
        }
        for(int i=idx;i<candidates.length;i++){
            if(candidates[i]>target)return ;
            track.add(candidates[i]);
            backtrack(candidates,i+1,track,target-candidates[i]);
            track.removeLast();
        }
    }
    @Test
    public void test(){
        int candidates[]=new int[]{1,2,3,4,5};
        System.out.println(combinationSum(candidates,5));
    }

}
