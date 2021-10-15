package first200;

import org.junit.Test;

public class Lc42 {

    public int trap(int[] height) {
        int n=height.length;
        int leftMax=0,rightMax=0;
        int res=0;
        int left=0,right=n-1;
        while(left<right){
            leftMax=Math.max(leftMax,height[left]);
            rightMax=Math.max(rightMax,height[right]);
            if(height[left]<height[right]){
                res+=Math.min(leftMax,rightMax)-height[left];
                left++;

            }
            else{
                res+=Math.min(leftMax,rightMax)-height[right];
                right--;
            }
        }
        return res;
    }
    @Test
    public void test(){
        int nums[]=new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(nums));
    }
}
