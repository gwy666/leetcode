package alibaba;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Solution1 {
    static int n=5;
    static int k=2;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int len=Integer.parseInt(br.readLine());
        for(int i=0;i<len;i++){
            String s=br.readLine();
            String strs[]=s.split(" ");
            n=Integer.parseInt(strs[0]);
            k=Integer.parseInt(strs[1]);
            int nums1[]=new int[n];
            int nums2[]=new int[n];
            String s1=br.readLine();
            String str1[]=s1.split(" ");
            for(int j=0;j<s1.length();j++){
                nums1[j]=Integer.parseInt(str1[j]);
            }
            String s2=br.readLine();
            String str2[]=s1.split(" ");
            for(int j=0;j<s1.length();j++){
                nums1[j]=Integer.parseInt(str2[j]);
            }


        }
    }


    public static int method(int nums1[],int nums2[]){
        int res=0;
        Set<Integer> set=new HashSet<>();
        int i=0;
        for(;i<k;i++){
            set.add(nums1[i]);
        }
        boolean vis[]=new boolean[nums1.length+1];
        for(int j=0;j<n;j++){
            if(!set.contains(nums2[j])){
                res++;
                vis[j]=true;
            }
            else {
                set.remove(nums2[j]);
                while(i<nums1.length&&vis[nums2[j]]){
                    i++;
                }
                if(i<nums1.length){
                    set.add(nums1[i]);
                    i++;
                }

            }
        }
        return res;
    }
    @Test
    public void test(){
        int nums1[]=new int[]{1,2,3,4,5};
        int nums2[]=new int[]{3,2,1,5,4};
        System.out.println(method(nums1, nums2));
    }
}
