package first200;

import org.junit.Test;

import java.util.*;

public class Lc56 {

    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        List<int[]> list=new LinkedList<>();
        list.add(new int[]{intervals[0][0],intervals[0][1]});
        for(int i=1;i<intervals.length;i++){
            int nums[]=list.get(list.size()-1);
            int x=nums[0];
            int y=nums[1];
            if(intervals[i][0]>y){
                list.add(new int[]{intervals[i][0],intervals[i][1]});
            }
            else{
                nums[1]=Math.max(y,intervals[i][1]);
            }
        }



        return list.toArray(new int[list.size()][]);
    }

    @Test
    public void test(){
        int intervals[][] = new int[][]{{1,3},{2,6},{15,18},{8,10}};
        int res[][]=merge(intervals);
        for(int i[]:res){
            System.out.println(i[0]+"-"+i[1]);
        }
    }
}
