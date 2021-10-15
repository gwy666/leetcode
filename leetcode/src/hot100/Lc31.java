package hot100;

public class Lc31 {

    public void nextPermutation(int[] nums) {
        int n=nums.length;
        int start=n-1;
        while(start>0&&nums[start-1]>=nums[start]){
            start--;
        }
        if(start==0){
            swap(nums,0,n-1);
        }
        int num=nums[start-1];
        int left=start;
        int right=n-1;
        while(left<right){
            int mid=(left+right)/2;
            if(nums[mid]>num){
                left=mid;
            }
            else right=mid-1;
        }
        int temp=nums[start-1];
        nums[start-1]=nums[left];
        nums[left]=temp;
        swap(nums,start,n-1);

    }
    public void swap(int nums[],int left,int right){
        int i=left;
        int j=right;
        while(i<j){
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
        }
    }
}
