package competence.Lc9_19;

import org.junit.Test;

public class Lc5876 {


    public int sumOfBeauties(int[] nums) {
        int n=nums.length;
        int leftMax[]=new int[n];
        leftMax[0]=Integer.MIN_VALUE+1;
        int rightMin[]=new int[n];
        rightMin[n-1]=Integer.MAX_VALUE-1;
        for(int i=1;i<n;i++){
            leftMax[i]=Math.max(leftMax[i-1],nums[i-1]);
        }
        for(int i=n-2;i>=0;i--){
            rightMin[i]=Math.min(rightMin[i+1],nums[i+1]);
        }
        int res=0;
        for(int i=1;i<=n-2;i++){
            if(leftMax[i]<nums[i]&&rightMin[i]>nums[i]){
                res+=2;
            }
            else if(nums[i]>nums[i-1]&&nums[i]<nums[i+1]){
                res+=1;
            }
            else continue;
        }
        return res;
    }
    @Test
    public void test(){
        int nums[]=new int[]{1,2,3};
        System.out.println(sumOfBeauties(nums));
    }
}
