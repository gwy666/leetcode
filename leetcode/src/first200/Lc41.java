package first200;

import org.junit.Test;

public class Lc41 {

    public int firstMissingPositive(int[] nums) {
        int n=nums.length;
        for(int i=0;i<n;i++){
            while(nums[i]>=1&&nums[i]<=n&&nums[i]!=i+1){
                if(nums[i]==nums[nums[i]-1]){
                    break;
                }
                int temp=nums[nums[i]-1];
                nums[nums[i]-1]=nums[i];
                nums[i]=temp;

            }
        }

        for(int i=0;i<n;i++){
            if(nums[i]!=i+1){
                return i+1;
            }
        }
        return nums[n-1]+1;
    }

    @Test
    public void test(){
        int nums[]=new int[]{1};
        System.out.println(firstMissingPositive(nums));
    }
}
