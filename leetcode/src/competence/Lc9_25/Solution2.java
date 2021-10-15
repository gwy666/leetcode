package competence.Lc9_25;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    List<List<Integer>> res=new ArrayList<>();

    public int[][] bicycleYard(int[] position, int[][] terrain, int[][] obstacle) {
        dfs(position[0],position[1],terrain,obstacle,1);
        System.out.println(res);
        return null;
    }

    public void dfs(int x,int y,int terrain[][],int obstacle[][],int speed){
        int m=terrain.length;
        int n=terrain[0].length;
        if(x<1||x>=m-1||y<1||y>=n-1)return ;
        if(speed<=0)return ;
        if(speed==1) {
            List<Integer> list=new ArrayList<>();
            list.add(x);
            list.add(y);
        }

        dfs(x+1,y,terrain,obstacle,speed+terrain[x][y]-terrain[x+1][y]);
        dfs(x-1,y,terrain,obstacle,speed+terrain[x][y]-terrain[x-1][y]);
        dfs(x,y+1,terrain,obstacle,speed+terrain[x][y]-terrain[x][y+1]);
        dfs(x,y-1,terrain,obstacle,speed+terrain[x][y]-terrain[x][y-1]);
    }
    @Test
    public void test(){
        int position[]=new int[]{1,1};
        int terrain[][] = new int[][]{{5,0},{0,6}};
        int obstacle[][] = new int[][]{{0,6},{7,0}};
        int res[][]=bicycleYard(position,terrain,obstacle);

//        for(int i[]:res){
//            for(int j:i){
//                System.out.print(j+" ");
//            }
//            System.out.println();
//        }
    }
}
