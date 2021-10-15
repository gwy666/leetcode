package competence.Lc9_25;

import org.junit.Test;

public class Solution3 {
    int n;
    int finalC[][];

    public int[] volunteerDeployment(int[] finalCnt, long totalNum, int[][] edges, int[][] plans) {

        n=finalCnt.length;
        finalC=new int[n+1][2];
        int index=1;
        finalC[0][1]=1;
        for(int i:finalCnt){
            finalC[index++][0]=i;
        }

        boolean flag[][]=new boolean[n+1][n+1];
        for(int edge[]:edges){
            int x=edge[0];
            int y=edge[1];
            flag[x][y]=true;
            flag[y][x]=true;
        }
        for(int i=plans.length-1;i>=0;i--){
            int num=plans[i][0];
            int idx=plans[i][1];
            if(num==1){
                finalC[idx][0]*=2;
                finalC[idx][1]*=2;
            }
            if(num==2){
                for(int j=0;j<=n;j++){
                    if(flag[j][idx]){
                        finalC[j][0]-=finalC[idx][0];
                        finalC[j][1]-=finalC[idx][1];
                    }
                }
            }
            if(num==3){
                for(int j=0;j<=n;j++){
                    if(flag[j][idx]){
                        finalC[j][0]+=finalC[idx][0];
                        finalC[j][1]+=finalC[idx][1];
                    }
                }
            }
        }
        long a=0;
        long b=0;
        for(int i=0;i<n+1;i++){
            a+=finalC[i][0];
            b+=finalC[i][1];
        }
        int res[]=new int[n+1];
        long x=(totalNum-a)/b;
        for(int i=0;i<=n;i++){
            res[i]=(int)(finalC[i][0]+finalC[i][1]*x);
        }
        return res;
    }

    @Test
    public void test() {
        int finalCnt[] = new int[]{1, 16};
        long totalNum = 21;
        int deges[][] = new int[][]{{0, 1}, {1, 2}};
        int plans[][] = new int[][]{{2, 1}, {1, 0}, {3, 0}};
        int res[]=volunteerDeployment(finalCnt,totalNum,deges,plans);
        for(int i:res)
        {
            System.out.println(i);}
    }
}
