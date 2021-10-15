package sort;

import org.junit.Test;

public class ShellSort {

    public void sort(int nums[]){
        int n=nums.length;
        int step=n/2;
        while(step>=1){
            for(int i=0;i<step;i++){
                for(int j=i+step;j<n;j+=step){
                    int num=nums[j];
                    int k=j-step;
                    while(k>=0&&num<nums[k]){
                       nums[k+step]=nums[k];
                       k-=step;
                    }
                    nums[k+step]=num;
                }
            }
            step/=2;
        }
        for(int i:nums){
            System.out.println(i);
        }
    }

    @Test
    public void test(){
        int nums[]=new int[]{5,2,3,1};
        sort(nums);
    }
}
