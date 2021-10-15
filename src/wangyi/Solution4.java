package wangyi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution4 {
    public static void main(String[] args) throws IOException {

//        Scanner sc=new Scanner(System.in);
//
//        int n=sc.nextInt();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
//        String s=sc.nextLine();
        String s1=br.readLine();
        int n=Integer.parseInt(s1);
        String s=br.readLine();
        System.out.println(method(s));
    }
    public static int method(String s){
        int n=s.length();
        int dp[]=new int[n];
        dp[0]=1;
        for(int i=1;i<n;i++){
            if(s.charAt(i)!=s.charAt(i-1)){
                dp[i]=dp[i-1]+1;
                for(int j=i-1;j>=0;j--){
                    if(s.charAt(j)==s.charAt(i)){
                        dp[i]=Math.min(dp[i-1]+1,dp[j]+1);
                        break;
                    }
                }
            }
            else dp[i]=dp[i-1];
        }

        return dp[n-1];
    }
}
