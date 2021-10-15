package hot100;

import org.junit.Test;

public class Lc3 {
    public int lengthOfLongestSubstring(String s) {
        if(s==null||s.length()==0)return 0;
        int n=s.length();
        int res=0;
        int window[]=new int[256];
        int left=0,right=0;
        while(right<n){
            char c=s.charAt(right);
            right++;
            window[c]++;
            while(window[c]>1){
                char d=s.charAt(left);
                left++;
                window[d]--;
            }
            res=Math.max(res,right-left);
        }
        return res;
    }
    @Test
    public void test(){
        String s= "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
