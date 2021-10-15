package JD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.Scanner;

public class Solution1 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int x=sc.nextInt();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String s=br.readLine();
        String strs[]=s.split(" ");
        int nums[]=new int[n];
        int index=0;
        for(String str:strs){
            nums[index++]=Integer.parseInt(str);
        }
        Arrays.sort(nums);
        int count=0;
        for(int i=1;i<n;i++){
            if(nums[i]-nums[i-1]>x){
                int gap=nums[i]-nums[i-1];
                while(gap>x){
                    if(k-->0){
                        gap-=x;
                    }
                    else{
                        count++;
                        break;
                    }
                }
            }
        }
        System.out.println(count+1);
    }
}
