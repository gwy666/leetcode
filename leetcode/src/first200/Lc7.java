package first200;

import org.junit.Test;

public class Lc7 {

    public int reverse(int x) {
        int res=0;
        while(x!=0){
            if(res<Integer.MIN_VALUE/10||res>Integer.MAX_VALUE/10){
                return 0;
            }
            res=res*10+x%10;
            x/=10;
        }
        return res;
    }

    @Test
    public void test(){
        int x=10;
        System.out.println(reverse(Integer.MAX_VALUE));
    }
}
