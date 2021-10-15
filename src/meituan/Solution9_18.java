package meituan;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution9_18 {
    public static void main(String[] args) throws IOException {



        Scanner sc = new Scanner(System.in);
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n = sc.nextInt();
        for(int i=0;i<n;i++){
            int len=sc.nextInt();
            String s=br.readLine();
            System.out.println(method(s));
        }
    }
    public static String method(String s){
        s=method1(s);
        return method2(s);
    }
    static Map<Integer,String> map=new HashMap();
    public static void init(){
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");
    }
    public static String method1(String s){
        int n=s.length();
        int index=0;
        StringBuilder sb=new StringBuilder();
        int last=s.charAt(0);

        while(index<n){
            if(s.charAt(index)=='-'){
                index++;
                if(index<n&&s.charAt(index)=='-'){
                    sb.append('-');
                }
            }
            else {
                if(s.charAt(index)!=last){
                    sb.append('-');
                }
                sb.append(s.charAt(index));
                last=s.charAt(index);
                index++;

            }
        }
        return sb.toString();
    }
    public static String method2(String s){
        String strs[]=s.split("-");
        init();
        StringBuilder sb=new StringBuilder();
        for(String str:strs){
            if(str.equals("")||str.equals("-")){
                continue;
            }
            if(str.startsWith("0")){
                int count=str.length();
                for(int i=0;i<count;i++)sb.append('-');
            }
            else {
                int count= str.length();
                String ls=map.get(str.charAt(0)-'0');
                sb.append(ls.charAt((count-1)%ls.length()));
            }
        }
        return sb.toString();
    }
}