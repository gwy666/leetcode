package tencent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String s=br.readLine();
        System.out.println(dfs(s));

    }
    public static long dfs(String s){
        if(s.length()==0){
            return 0;
        }
        int index=s.indexOf("+");
        long next=0;
        if(index!=-1){
            next = dfs(s.substring(index+1,s.length()));
        }
        else{
            String strs[]=s.split("x");
            long res=1;
            for(String str:strs){
                String ss[]=str.split("@");
                long x=0;
                for(String s1:ss){
                    int n=Integer.parseInt(s1);
                    x=x|(n+x);
                }
                res*=x;
            }
            return res;
        }
        return Long.parseLong(s.substring(0,index))+next;
    }
}
