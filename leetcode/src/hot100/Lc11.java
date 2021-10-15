package hot100;

import java.util.Stack;

public class Lc11 {

    public int maxArea(int[] height) {
        int n=height.length;
        int left=0;
        int right=n-1;
        int res=0;
        while(left<right){
            if(height[left]<height[right]){
                res=Math.max(res,(right-left)*height[left]);
                left++;
            }
            else{
                res=Math.max(res,(right-left)*height[right]);
                right--;
            }
        }
        return res;
    }
}
