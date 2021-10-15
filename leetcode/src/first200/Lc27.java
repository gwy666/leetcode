package first200;

public class Lc27 {

    public int removeElement(int[] nums, int val) {
        int n=nums.length;
        int left=0;
        int right=n-1;
        int res=n;
        while(left<right){
            while(left<right&&nums[left]!=val){
                left++;
            }
            while(left<right&&nums[right]==val){
                res--;
                right--;
            }
            if(left<right){
                swap(nums,left,right);
                left++;
                right--;
                res--;
            }
        }
        return res;
    }
    public void swap(int nums[],int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
