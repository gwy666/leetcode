package honor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution3 {

    static int x;
    static int y;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String s=br.readLine();
        List<String> res=new ArrayList<>();
        int L=0;
        int Q=s.indexOf("Q=");
        int P=s.indexOf("P=");
        String s1=s.substring(L+3,Q-2);
        String s2=s.substring(Q+3,P-2);
        String s3=s.substring(P+2);
        String point[]=s3.split(",");
        x=Integer.parseInt(point[0]);
        y=Integer.parseInt(point[1]);

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        String lPoints[]=s1.split("|");
        String qPoints[]=s2.split("|");
        for(String q:qPoints){

        }
    }
    public static boolean check(String qPoint,String lPoints[]){
        return true;
    }


}
