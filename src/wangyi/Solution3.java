package wangyi;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution3 {
    public static void main(String[] args) throws IOException {

        int res=Integer.MAX_VALUE;
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String s=br.readLine();
        for(int i=0;i<=s.length()-5;i++){
            String str=s.substring(i,i+5);
            res=Math.min(res,minStep(str));
        }
        System.out.println(res);

    }
    public static int minStep(String s){
        String target="AcMer";
        int res=0;
        for(int i=0;i<5;i++){
            char c=s.charAt(i);
            char d=target.charAt(i);
            if(c==d){
                continue;
            }
            else if(Math.abs(c-d)==32){
                res+=5;
            }
            else if(c-'a'>0&&d-'a'>0){
                res+=5;
            }
            else if(c-'a'<0&&d-'a'<0){
                res+=5;
            }
            else res+=10;
        }
        return res;
    }

    @Test
    public void test(){
        char c='A';
        char d='a';
        String s="abMqr";
        System.out.println(minStep(s));
    }
}

