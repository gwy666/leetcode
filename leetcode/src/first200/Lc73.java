package first200;

import java.util.HashSet;
import java.util.Set;

public class Lc73 {
    public void setZeroes(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        Set<Integer> row=new HashSet<>();
        Set<Integer> column=new HashSet<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    row.add(i);
                    row.add(j);
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(row.contains(i)||column.contains(j)){
                    matrix[i][j]=0;
                }
            }
        }
    }
}
