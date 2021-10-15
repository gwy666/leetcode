package honor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution4 {

    public static void main(String[] args) throws IOException {
        int  c='0';
        System.out.println(c);
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String s=br.readLine();
        System.out.println(method(s));

    }
    public static String method(String s){
        StringBuilder br=new StringBuilder();
        br.append("5a");
        String strs[]=s.split("5a");
        for(String str:strs){

            str.trim().trim();
            if(check(str)){
                br.append(str).append("5a");
            }
        }
        if(br.equals("5a"))return null;
        else return br.toString();

    }
    public static boolean check(String s){

        if(s.length()==0)return false;
        int c=s.charAt(s.length()-2);
        int d=s.charAt(s.length()-3);


        int valid=0;
        valid+=c>=97?c-87:c-'0';
        valid+=(d>=97?c-87:d-'0')*16;
        String strs[]=s.split(" ");
        int n=strs.length;
        for(int i=0;i<n-1;i++){
            if(i<n-2&&strs[i].equals("5b")&&strs[i+1].equals("ba")){
                valid++;
            }
            if(i<n-2&&strs[i].equals("5b")&&strs[i+1].equals("bb")){
                valid++;
            }
        }
        return valid==n-1;

    }




}
