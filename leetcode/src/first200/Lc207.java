package first200;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Lc207 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> lists=new ArrayList<>();
        int in[]=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            lists.add(new ArrayList<>());
        }
        for(int prerequisite[]:prerequisites){
            int i=prerequisite[0];
            int j=prerequisite[1];
            in[i]++;
            lists.get(j).add(i);
        }
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(in[i]==0){
                queue.add(i);
            }
        }
        int count=0;
        while(!queue.isEmpty()){
            Integer i=queue.poll();
            count++;
            for(Integer j:lists.get(i)){
                in[j]--;
                if(in[j]==0){
                    queue.add(j);
                }
            }
        }
        return count==numCourses;
    }
}
