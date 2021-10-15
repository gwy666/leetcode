package sort;

import org.junit.Test;

public class MergeSort {

    public void sort(int nums[]){
        process(nums,0,nums.length-1);

    }
    public void process(int nums[],int left,int right){
        if(left>=right)return ;
        if(left+1==right){
            if(nums[left]>nums[right])swap(nums,left,right);
            return ;
        }
        int mid=(left+right)/2;
        process(nums,left,mid-1);
        process(nums,mid,right);
        merge(nums,left,mid,right);
    }

    public void merge(int nums[],int left,int mid,int right){

        int copyNums[]=new int[right-left+1];
        int index=0;
        int i=left;
        int j=mid;
        while(i<=mid-1&&j<=right){
            if(nums[i]<nums[j]){
                copyNums[index++]=nums[i];
                i++;
            }
            else{
                copyNums[index++]=nums[j];
                j++;
            }
        }
        while(i<=mid-1){
            copyNums[index++]=nums[i++];
        }
        while(j<=right){
            copyNums[index++]=nums[j++];
        }
        for(int k=left;k<=right;k++){
            nums[k]=copyNums[k-left];
        }
    }
    public void swap(int nums[],int left,int right){
        int temp=nums[left];
        nums[left]=nums[right];
        nums[right]=temp;
    }

    @Test
    public void test(){
        int nums[]=new int[]{1,5,4,2};
        sort(nums);
    }
}
