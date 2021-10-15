package wangyi;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {

    public static void main(String[] args) {

    }
    Map<Integer,Integer> bMap=new HashMap<>();
    Map<Integer,Integer> rMap=new HashMap<>();

    public int minStep(int n,String s){
        bMap.put(-1,0);
        rMap.put(-1,0);
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='B'){
                bMap.put(i,bMap.get(i-1)+1);
            }
            else rMap.put(i,rMap.get(i-1)+1);
        }
        return -1;

    }

    public int get(int i,int j){
     return -1;
    }
}
