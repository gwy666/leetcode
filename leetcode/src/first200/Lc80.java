package first200;

import org.junit.Test;

public class Lc80 {
    public int removeDuplicates(int[] nums) {
        int n=nums.length;
        int left=2;
        int right=2;


        while(right<n){
            if(nums[right]!=nums[right-1]){
                nums[left++]=nums[right];
            }
            else{

            }

            right++;
        }

        return left;
    }
    @Test
    public void test(){
        int nums[]=new int[]{1,1,1,2,2,3};
        System.out.println(removeDuplicates(nums));
    }
}
