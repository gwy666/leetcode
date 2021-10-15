package honor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String s=br.readLine();
        String strs[]=s.split(",");
        int n=strs.length;
        int nums[]=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=Integer.parseInt(strs[i]);
        }
        boolean vis[]=new boolean[n];
        int index=0;
        List<List<Integer>> res=new ArrayList<>();
        int count=n;
        while(count!=0){

            List<Integer> list=new ArrayList<>();
            int last=Integer.MAX_VALUE;
            for(int i=0;i<n;i++){
                if(!vis[i]&&nums[i]<last){
                    list.add(nums[i]);
                    vis[i]=true;
                    count--;
                    last=nums[i];
                }
            }
            res.add(list);
        }
        System.out.println(res.size());
        for(List<Integer> list:res){
            for(int i=0;i<list.size()-1;i++){
                System.out.print(list.get(i)+",");
            }
            System.out.println(list.get(list.size()-1));
        }
    }
}
