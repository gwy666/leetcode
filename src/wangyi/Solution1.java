package wangyi;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution1 {
    static Set<Integer> set=new HashSet<>();
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();

        if(m%n!=0){
            System.out.println(-1);
        }
        else{
            int num=m/n;
            if(set.contains(num)){
                System.out.println(1);
            }
        }
    }
}
