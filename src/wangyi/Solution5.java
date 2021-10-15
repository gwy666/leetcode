package wangyi;

import java.util.Scanner;

public class Solution5 {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            int num=sc.nextInt();
            if(get(num)!=-1){
                System.out.println(get(num));
            }
            else if(get(num)==-1) System.out.println(-1);
        }
    }
    public static int get(int num){
        int n=num+1;
        int step=0;
        while(n%2!=0){
            n/=2;
            step++;
        }
        return n==1?step-1:-1;
    }

}
