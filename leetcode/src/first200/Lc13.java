package first200;

import org.junit.Test;

public class Lc13 {


    public int romanToInt(String s) {
        int n=s.length();
        int res=0;
        int index=0;
        char c='0';
        while(index<n){
            c=s.charAt(index);
            if(c=='M')res+=1000;
            else if(c=='D')res+=500;
            else if(c=='C'){
                if(index+1<n&&s.charAt(index+1)=='D'){
                    res+=400;
                    index++;
                }
                else if(index+1<n&&s.charAt(index+1)=='M'){
                    res+=900;
                    index++;
                }
                else res+=100;
            }
            else if(c=='L')res+=50;
            else if(c=='X'){
                if(index+1<n&&s.charAt(index+1)=='L'){
                    res+=40;
                    index++;
                }
                else if(index+1<n&&s.charAt(index+1)=='C'){
                    res+=90;
                    index++;
                }
                else res+=10;
            }
            else if(c=='V')res+=5;
            else if(c=='I'){
                if(index+1<n&&s.charAt(index+1)=='V'){
                    res+=4;
                    index++;
                }
                else if(index+1<n&&s.charAt(index+1)=='X'){
                    res+=9;
                    index++;
                }
                else res+=1;
            }
            index++;
        }
        return res;
    }

    @Test
    public void test(){
        String s="MCMXCIV";
        System.out.println(romanToInt(s));
    }
}
