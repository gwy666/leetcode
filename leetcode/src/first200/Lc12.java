package first200;

import org.junit.Test;

public class Lc12 {
    public String intToRoman(int num) {

        StringBuilder sb = new StringBuilder();
        while(num!=0){
            int n1=num/1000;
            for(int i=0;i<n1;i++){
                sb.append('M');
            }
            num%=1000;
            int n2=num/100;
            if(n2<5){
                if(n2==4)sb.append("CD");
                else for(int i=0;i<n2;i++){
                    sb.append("C");
                }
            }
            else{
                if(n2==9)sb.append("CM");
                else{
                    sb.append("D");
                    for(int i=0;i<n2-5;i++){
                        sb.append("C");
                    }
                }
            }
            num%=100;
            int n3=num/10;
            if(n3<5){
                if(n3==4)sb.append("XL");
                else for(int i=0;i<n3;i++){
                    sb.append("X");
                }
            }
            else{
                if(n3==9)sb.append("XC");
                else {
                    sb.append("L");
                    for(int i=0;i<n3-5;i++){
                        sb.append("X");
                    }
                }
            }
            num%=10;
            int n4=num;
            if(n4<5){
                if(n4==4)sb.append("IV");
                else for(int i=0;i<n4;i++){
                    sb.append("I");
                }
            }
            else{
                if(n4==9)sb.append("IX");
                else {
                    sb.append("V");
                    for(int i=0;i<n4-5;i++){
                        sb.append("I");
                    }
                }
            }
            num/=10;
        }
        return sb.toString();
    }
    @Test
    public void test(){
        int num=58;
        System.out.println(intToRoman(num));
    }
}
