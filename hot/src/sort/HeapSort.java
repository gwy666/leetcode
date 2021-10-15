package sort;

import org.junit.Test;

public class HeapSort {

    public void sort(int nums[]){

        int heapSize=nums.length;
        int n=heapSize;
        buildHeap(nums,n);
        for(int i:nums){
            System.out.println(i);
        }
        for(int i=0;i<n;i++){
            swap(nums,0,heapSize-1);
            heapSize--;
            adjustHeap(nums,0,heapSize);
        }

    }
    public void buildHeap(int nums[],int heapSize){
        for(int i=heapSize/2+1;i>=0;i--){
            adjustHeap(nums,i,heapSize);
        }
    }
    public void adjustHeap(int nums[],int i,int heapSize){
        int large=i;
        int left=2*i+1;
        int right=2*i+2;
        if(left<heapSize&&nums[left]>nums[large]){
            large=left;
        }
        if(right<heapSize&&nums[right]>nums[large]){
            large=right;
        }
        if(large!=i){
            swap(nums,large,i);
            adjustHeap(nums,large,heapSize);
        }
    }
    public void swap(int nums[],int left,int right){
        int temp=nums[left];
        nums[left]=nums[right];
        nums[right]=temp;
    }
    @Test
    public void test(){
        int nums[]=new int []{3,2,4,1,5};
        sort(nums);

    }
}
