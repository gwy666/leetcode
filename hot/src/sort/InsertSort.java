package sort;

import org.junit.Test;

public class InsertSort {

    public void sort(int nums[]){
        int n=nums.length;
        for(int i=1;i<n;i++){
            int num=nums[i];
            int left=0;
            int right=i-1;
            if(nums[right]>num){
                while(left<right){
                    int mid=(left+right)/2;
                    if(nums[mid]<num){
                        left=mid+1;
                    }
                    else right=mid;
                }

                for(int j=i;j>left;j--){
                    nums[j]=nums[j-1];
                }
                nums[left]=num;
            }
            else continue;
        }
        for(int i:nums){
            System.out.println(i);
        }
    }

    @Test
    public void test(){
        int nums[]=new int[]{1,5,3,2};
        sort(nums);
    }
}
