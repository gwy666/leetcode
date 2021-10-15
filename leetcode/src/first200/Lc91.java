package first200;

import org.junit.Test;

public class Lc91 {

    public int numDecodings(String s) {
        int n=s.length();
        if(s.startsWith("0"))return 0;
        int dp[]=new int[n+1];
        dp[0]=1;
        dp[1]=s.charAt(0)=='0'?0:1;
        for(int i=2;i<=n;i++){
            char c=s.charAt(i-1);
            if(c=='0'){
                if(s.charAt(i-2)!='1'&&s.charAt(i-2)!='2'){
                    return 0;
                }
                dp[i]=dp[i-2];
            }
            else{
                if(s.charAt(i-2)=='0'){
                    dp[i]=dp[i-3];
                }
                else{
                    if((s.charAt(i-2)-'0')*10+c-'0'<=26){
                        dp[i]=dp[i-2]+dp[i-1];
                    }
                    else{
                        dp[i]=dp[i-1];
                    }
                }
            }
        }

        return dp[n];

    }
    @Test
    public void test(){
        String s="2101";
        System.out.println(numDecodings(s));
    }
}
