package first200;

import org.junit.Test;

public class Lc66 {
    public int[] plusOne(int[] digits) {
        int n=digits.length;
        int car=1;
        if(digits[n-1]<9){
            digits[n-1]+=1;
            return digits;
        }
        digits[n-1]=0;
        for(int i=n-2;i>=0;i--){
            int temp=digits[i];
            digits[i]=(digits[i]+car)%10;
            car=(temp+car)/10;
        }
        if(car==1){
            int res[]=new int[n+1];
            res[0]=1;
            for(int i=1;i<=n;i++){
                res[i]=digits[i-1];
            }
            return res;
        }
        return digits;
    }

    @Test
    public void test(){
        int digits[]=new int[]{9};
        int res[]=plusOne(digits);
        for(int i:res){
            System.out.print(i+" ");
        }
    }
}
