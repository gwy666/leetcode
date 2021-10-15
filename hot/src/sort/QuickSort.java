package sort;

public class QuickSort {

    public void sort(int nums[]){
        recur(nums,0,nums.length-1);
    }
    public void recur(int nums[],int left,int right){
        if(left>=right||left<0||right>=nums.length)return ;
        int n=nums[left];
        int i=left;
        int j=right;
        while(i<=j){
            while(i<=j&&nums[i]<=n){
                i++;
            }
            while(i<=j&&nums[j]>=n){
                j--;
            }
            if(i<j){
                swap(nums,i,j);
            }
        }
        swap(nums,left,j);
        recur(nums,left,j-1);
        recur(nums,j+1,right);

    }
    public void swap(int nums[],int left,int right){
        int temp=nums[left];
        nums[left]=nums[right];
        nums[right]=temp;
    }
}
