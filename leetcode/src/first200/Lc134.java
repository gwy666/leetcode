package first200;

import org.junit.Test;

public class Lc134 {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n=gas.length;
        for(int i=0;i<n;i++){
            if(check(i,gas,cost)){
                return i;
            }
        }
        return -1;
    }
    public boolean check(int i,int gas[],int cost[]){
        int cur=gas[i];
        int cos=cost[i];
        int index=i;
        for(int j=0;j<gas.length;j++){
            if(cur<cos){
                return false;
            }
            index=(i+1)%gas.length;
            cur=cur-cos+gas[index];
            cos=cost[index];
            i++;
        }
        return true;
    }
    @Test
    public void test(){
        int gas[]=new int[]{4,5,3,1,4};
        int cost[]=new int[]{5,4,3,4,2};
        System.out.println(canCompleteCircuit(gas,cost));
    }
}
