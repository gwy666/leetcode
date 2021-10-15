package first200;

import org.junit.Test;

public class Lc26 {
    public int removeDuplicates(int[] nums) {
        int n=nums.length;
        int left=1;
        int right=1;
        int last=Integer.MAX_VALUE;
        while(right<n){
            if(nums[right]!=nums[right-1]){
                nums[left++]=nums[right];
            }
            right++;
        }

        return left;
    }
    @Test
    public void test(){
        int nums[]=new int[]{0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
    }
}
