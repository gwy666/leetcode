package first200;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class Lc77 {

    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtrack(n,k,1,new LinkedList<>());
        return res;
    }

    public void backtrack(int n,int k,int i,LinkedList<Integer> track){
        if(track.size()+n-i+1<k)return ;
        if(track.size()==k){
            res.add(new LinkedList<>(track));
            return ;
        }

        for(int j=i;j<=n;j++){
            track.add(j);
            backtrack(n,k,j+1,track);
            track.removeLast();
        }
    }
    @Test
    public void test(){
        int n=4;
        int k=2;
        System.out.println(combine(n,k));
    }

}
