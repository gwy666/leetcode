package first200;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lc60 {


    Map<Integer,Integer> map=new HashMap<>();
    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        List<Integer> list=new ArrayList<>();
        for(int i=1;i<=n;i++){
            list.add(i);
        }
        init();
        while(n!=1){

            int cur=(k-1)/(map.get(n-1));
            sb.append(list.get(cur));
            list.remove(cur);
            k=k-(cur)*map.get(--n);
        }
        sb.append(list.get(0));
        return sb.toString();
    }
    public void init(){
        int num=1;
        for(int i=1;i<=10;i++){
            num*=i;
            map.put(i,num);
        }
    }
    @Test
    public void test(){
        int n=4;int k=6;
        System.out.println(getPermutation(n,k));
    }
}
