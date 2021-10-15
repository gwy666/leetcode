package first200;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Lc131 {


    List<List<String>> res=new ArrayList<>();
    public List<List<String>> partition(String s) {
        int n=s.length();
        boolean dp[][]=new boolean[n][n];
        for(int i=n-1;i>=0;i--){
            for(int j=i;j<n;j++){
                if(i==j)dp[i][j]=true;
                else if(i+1==j){
                    dp[i][j]=s.charAt(i)==s.charAt(j);
                }
                else dp[i][j]=dp[i+1][j-1]&&s.charAt(i)==s.charAt(j);
            }
        }
        for(boolean i[]:dp){
            for(boolean j:i){
                System.out.print(j+" ");
            }
            System.out.println();
        }
        recur(s,dp,0,new LinkedList<>());
        return res;
    }
    public void recur(String s, boolean dp[][], int idx, LinkedList<String> track){
        if(idx==s.length()){
            res.add(new LinkedList<>(track));
            return ;
        }
        for(int i=idx;i<s.length();i++){

            if(!dp[idx][i]){
                continue;
            }
            track.add(s.substring(idx,i+1));
            recur(s,dp,i+1,track);
            track.removeLast();
        }
    }

    @Test
    public void test(){
        String s="aab";
        System.out.println(partition(s));
    }
}
