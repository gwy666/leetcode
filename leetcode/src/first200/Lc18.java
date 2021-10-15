package first200;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lc18 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n=nums.length;
        List<List<Integer>> res=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(i>0&&nums[i]==nums[i-1])continue;
            for(int j=i+1;j<n;j++){
                if(j-1>i&&nums[j]==nums[j-1])continue;
                int sum=nums[i]+nums[j];
                int k=j+1;
                int l=n-1;
                while(k<l){
                    if(k-1>j&&nums[k]==nums[k-1]){
                        k++;
                        continue;
                    }
                    if(nums[k]+nums[l]<target-sum){
                        k++;
                    }
                    else if(nums[k]+nums[l]>target-sum){
                        l--;
                    }
                    else if(nums[k]+nums[l]==target-sum){
                        List<Integer> list=new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        list.add(nums[l]);
                        res.add(list);
                        k++;
                        l--;
                    }
                }
            }
        }
        return res;
    }
    @Test
    public void test(){
        int nums[]=new int[]{2,2,2,2,2};
        int target=8;
        System.out.println(fourSum(nums,target));
    }
}
