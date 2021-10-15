package tencent;

import java.util.Scanner;

public class Solution1 {

    public static void main(String[] args) {
        System.out.println(6%6);
        System.out.println(method(1));
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            int x=sc.nextInt();
            System.out.println(method(x));
        }
    }

    public static int method(int x){
        int i=1;
        while(i<Integer.MAX_VALUE){
            int count=0;
            int last=1-x;
            for(int j=1;j<=i;j++){
                if(i%j==0){
                    count++;
                    if(j-last<x)break;
                    if(count==4)return i;
                }
            }
            i++;
        }
        return -1;
    }
}
