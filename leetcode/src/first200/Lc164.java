package first200;

import org.junit.Test;

import java.util.Arrays;

public class Lc164 {

    public int maximumGap(int[] nums) {

        int n=nums.length;
        if(n==1){
            return 0;
        }
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for(int i:nums){
            max=Math.max(max,i);
            min=Math.min(min,i);
        }
        int d=Math.max(1,(max-min)/(n-1));
        int bucketSize=(max-min)/d+1;
        int bucket[][]=new int[bucketSize][2];
        for(int i[]:bucket){
            Arrays.fill(i,-1);
        }
        int bucket_max=Integer.MIN_VALUE;
        int bucket_min=Integer.MAX_VALUE;
        for(int num:nums){
            int idx=(num-min)/d;
            if(bucket[idx][0]==-1){
                bucket[idx][0]=num;
                bucket[idx][1]=num;
            }
            else{
                bucket[idx][0]=Math.min(bucket[idx][0],num);
                bucket[idx][1]=Math.max(bucket[idx][1],num);
            }
        }
        int last=-1;
        int res=0;
        for(int i=0;i<bucket.length;i++){
            if(bucket[i][0]==-1){
                continue;
            }
            if(i>=1){
                res=Math.max(res,bucket[i][0]-last);
            }
            last=bucket[i][1];
        }
        return res;
    }

    @Test
    public void test(){
        int nums[]=new int[]{1,3,100};
        System.out.println(maximumGap(nums));
    }
}
