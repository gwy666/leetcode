package huawei;

import org.junit.Test;
import java.util.Arrays;
//官万瑶
public class Solution1 {
    public int method(int nums[],int target){
        Arrays.sort(nums);
        int n=nums.length;
        int res=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int num=nums[i];
            int j=i+1;
            int k=n-1;
            while(j<k&&j<n-1){
                if(Math.abs(nums[i]+nums[j]+nums[k]-target)<res){
                    res=nums[i]+nums[j]+nums[k];
                }
                if(nums[j]+nums[k]==target-num){
                    return 0;
                }
                else if(nums[j]+nums[k]<target-num){
                    j++;
                }
                else k--;
            }
        }
        return res;
    }
    @Test
    public void test(){
        int nums[]=new int[]{-4,-1,1,2};
        System.out.println(method(nums,1));
    }
}
