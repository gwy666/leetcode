package honor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution2 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        if(x==y) System.out.println(n);
        else if (x < y) {
            System.out.println(n-y+x);
        }
        else System.out.println(y + n - x);
    }
//        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
//        String sn=br.readLine();
//        int n=Integer.parseInt(sn);
//        String s1=br.readLine();
//        int x=Integer.parseInt(s1);
//        String s2=br.readLine();
//        int y=Integer.parseInt(s2);
//        System.out.println(maxScore(n,x,y));
//    }
//    public static int maxScore(int n,int yes1,int yes2){
//        if(yes1==yes2){
//            return n;
//        }
//        int no=n-yes2;
//        int res=0;
//        if(yes1<yes2){
//            res+=yes1;
//            res+=no;
//        }
//        if(yes1>yes2){
//            int yes=yes1-yes2;
//            res=yes2+no-yes;
//        }
//        return res;
//    }
}
