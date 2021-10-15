package first200;

import org.junit.Test;

public class Lc8 {

    public int myAtoi(String s) {
        char c[]=s.trim().toCharArray();
        if(c.length==0)return 0;
        int res=0;
        int sign=1;
        int bndry=Integer.MAX_VALUE/10;
        int i=1;
        if(c[0]=='-')sign=-1;
        else if(c[0]!='+')i=0;
        for(int j=i;j<c.length;j++){
            if(!Character.isDigit(c[j]))break;
            if(res>bndry||res==bndry&&c[j]>'7')return sign==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
            res=res==0?c[j]-'0':res*10+c[j]-'0';
        }
        return res*sign;
    }
    @Test
    public void test(){
        String s="-2147483649";
        System.out.println(myAtoi(s));
    }
}
