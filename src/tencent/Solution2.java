package tencent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String s1=br.readLine();
        int n=Integer.parseInt(s1);
        for(int i=0;i<n;i++){
            String s2=br.readLine();
            int m=Integer.parseInt(s2);
            String s3=br.readLine();
            String strs[]=s3.split(" ");
            int nums[]=new int[m];
            int index=0;
            for(String s:strs){
                nums[index++]=Integer.parseInt(s);
            }
            System.out.println(method(nums));
        }
    }
    public static int method(int nums[]){
        int res=Integer.MIN_VALUE;
        int n=nums.length;
        int dp[]=new int[n];
        dp[n-1]=nums[n-1];
        for(int i=n-2;i>=0;i--){
            dp[i]=nums[i];
           if(i+nums[i]<n){
               dp[i]+=dp[i+nums[i]];
           }
           res=Integer.max(res,dp[i]);
        }
        return res;
    }
}
