package first200;

import org.junit.Test;

import java.util.*;

public class Lc40 {

    List<List<Integer>> res=new ArrayList<>();
    Map<Integer,Integer> map=new HashMap<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        for(int candidate:candidates){
            map.put(candidate,map.getOrDefault(candidate,0)+1);
        }
        backtrack(candidates,0,new LinkedList<>(),target);
        return res;
    }
    public void backtrack(int candidates[],int idx,LinkedList<Integer> track,int target){
        if(target==0){
            res.add(new LinkedList<>(track));
            return ;
        }
        if(target<0)return ;
        int index=idx;
        while(index<candidates.length){
            int n=map.get(candidates[index]);
            if(target<candidates[index])return ;
            for(int i=1;i<=n;i++){
                for(int j=1;j<=i;j++){
                    track.add(candidates[index]);
                }
                backtrack(candidates,index+n,track,target-i*candidates[index]);
                for(int j=1;j<=i;j++){
                    track.removeLast();
                }
            }
            index+=n;
        }
    }

    @Test
    public void test(){
        int nums[]=new int[]{1,2,5,6,7,10};
        System.out.println(combinationSum2(nums,8));
    }
}
