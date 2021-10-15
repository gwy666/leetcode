package first200;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Lc53 {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals==null||intervals.length==0){
            int res[][]=new int[1][2];
            res[0][0]=newInterval[0];
            res[0][1]=newInterval[1];
            return res;
        }
        if(intervals.length==1){
            int x=newInterval[0];
            int y=newInterval[1];
            if(x>=intervals[0][0]&&x<=intervals[0][1]){
                int res[][]=new int[1][2];
                res[0][0]=intervals[0][0];
                res[0][1]=Math.max(intervals[0][1],y);
                return res;
            }
            if(y>=intervals[0][0]&&y<=intervals[0][1]){
                int res[][]=new int[1][2];
                res[0][0]=Math.min(intervals[0][0],x);
                res[0][1]=intervals[0][1];
                return res;
            }
            if(y<intervals[0][0]){
                int res[][]=new int[2][2];
                res[0][0]=x;
                res[0][1]=y;
                res[1][0]=intervals[0][0];
                res[1][1]=intervals[0][1];
                return res;
            }
            if(x>intervals[0][1]){
                int res[][]=new int[2][2];
                res[0][0]=intervals[0][0];
                res[0][1]=intervals[0][1];
                res[1][0]=x;
                res[1][1]=y;
                return res;
            }
            if(x<intervals[0][0]&&y>intervals[0][1]){
                int res[][]=new int[1][2];
                res[0][0]=x;
                res[0][1]=y;
                return res;
            }
        }
        int x=newInterval[0];
        int y=newInterval[1];
        int n=intervals.length;
        int index1=-1;
        int index2=-1;
        for(int i=0;i<n;i++){
            if(intervals[i][0]<=x&&i<n-1&&intervals[i+1][0]>x){
                index1=i;
            }
            if(intervals[i][0]<=y&&i<n-1&&intervals[i+1][0]>y){
                index2=i;
            }
        }
        System.out.println("index1: "+index1);
        System.out.println("index2: "+index2);
        if(index1==-1&&index2==-1){
            if(y<=intervals[0][1]){
                int res[][]=new int[n+1][2];
                res[0][0]=x;
                res[0][1]=y;
                for(int i=1;i<=n;i++){
                    res[i][0]=intervals[i-1][0];
                    res[i][1]=intervals[i-1][1];
                }
                return res;
            }
            else if(x>=intervals[n-1][1]){
                int res[][]=new int[n+1][2];
                res[n][0]=x;
                res[n][1]=y;
                for(int i=0;i<n;i++){
                    res[i][0]=intervals[i][0];
                    res[i][1]=intervals[i][1];
                }
                return res;
            }
        }
        if(index1==-1&&index2!=-1){
            int res[][]=new int[n-index2][2];
            if(y<intervals[index2][1]){
                res[0][0]=x;
                res[0][1]=intervals[index2][1];
            }
            else {
                res[0][0]=x;
                res[0][1]=y;
            }
            for(int i=index2+1;i<n;i++){
                res[i-index2][0]=intervals[i][0];
                res[i-index2][1]=intervals[i][1];
            }
            return res;
        }
        if(index1!=-1&&index2==-1){

            if(x<intervals[index1][1]){
                int res[][]=new int[index1+1][2];
                res[index1][0]=intervals[index1][0];
                res[index1][1]=y;
                for(int i=0;i<index1;i++){
                    res[i][0]=intervals[i][0];
                    res[i][1]=intervals[i][1];
                }
                return res;
            }
            else{
                int res[][]=new int[index1+2][2];
                res[index1+1][0]=x;
                res[index1+1][1]=y;
                for(int i=0;i<=index1;i++){
                    res[i][0]=intervals[i][0];
                    res[i][1]=intervals[i][1];
                }
                return res;
            }
        }
        if(index1!=-1&&index2!=-1) {
            if (index1 == index2) {
                if (y <= intervals[index1][1]) return intervals;
                else {
                    if (x <= intervals[index1][1]) {
                        int res[][] = new int[intervals.length][2];
                        for (int i = 0; i < intervals.length; i++) {
                            res[i][0] = intervals[i][0];
                            res[i][1] = intervals[i][1];
                        }
                        res[index1][1] = y;
                        return res;
                    } else {
                        int res[][] = new int[intervals.length + 1][2];
                        for (int i = 0; i <= index1; i++) {
                            res[i][0] = intervals[i][0];
                            res[i][1] = intervals[i][1];
                        }
                        res[index1 + 1][0] = x;
                        res[index1 + 1][1] = y;
                        for (int i = index1 + 2; i < intervals.length + 1; i++) {
                            res[i][0] = intervals[i - 1][0];
                            res[i][1] = intervals[i - 1][1];
                        }
                        return res;
                    }
                }
            } else {
                if (x > intervals[index1][1] && y > intervals[index2][1]) {
                    int res[][] = new int[intervals.length - index2 + index1 + 1][2];
                    for (int i = 0; i <= index1; i++) {
                        res[i][0] = intervals[i][0];
                        res[i][1] = intervals[i][1];
                    }
                    res[index1 + 1][0] = x;
                    res[index1 + 1][1] = y;
                    for (int i = index2 + 1; i < intervals.length; i++) {
                        res[i - index2 + index1 + 1][0] = intervals[i][0];
                        res[i - index2 + index1 + 1][1] = intervals[i][1];
                    }
                    return res;


                }else if (x > intervals[index1][1] && y <= intervals[index2][1]) {
                    int res[][]=new int[intervals.length-index2+index1+1][2];
                    for(int i=0;i<=index1;i++){
                        res[i][0]=intervals[i][0];
                        res[i][1]=intervals[i][1];
                    }
                    res[index1+1][0]=x;
                    res[index1+1][1]=intervals[index2][1];
                    for(int i=index2+1;i<intervals.length;i++){
                        res[i-index2+1+index1][0]=intervals[i][0];
                        res[i-index2+1+index1][1]=intervals[i][1];
                    }
                    return res;



                }else if(x<=intervals[index1][1] && y>intervals[index2][1]) {

                    int res[][] = new int[intervals.length - index2 + index1][2];
                    for (int i = 0; i < index1; i++) {
                        res[i][0] = intervals[i][0];
                        res[i][1] = intervals[i][1];
                    }
                    res[index1][0] = intervals[index1][0];
                    res[index1][1] = y;
                    for (int i = index2 + 1; i < intervals.length; i++) {
                        res[i - index2 + index1][0] = intervals[i][0];
                        res[i - index2 + index1][1] = intervals[i][1];
                    }
                    return res;

                }else if(x<=intervals[index1][1] && y<=intervals[index2][1]){

                    int res[][] = new int[intervals.length - index2 + index1][2];
                    for (int i = 0; i < index1; i++) {
                        res[i][0] = intervals[i][0];
                        res[i][1] = intervals[i][1];
                    }
                    res[index1][0] = intervals[index1][0];
                    res[index1][1] = intervals[index2][1];
                    for (int i = index2 + 1; i < intervals.length; i++) {
                        res[i - index2 + index1][0] = intervals[i][0];
                        res[i - index2 + index1][1] = intervals[i][1];
                    }
                    return res;
                }

            }
        }
        return null;
    }

    @Test
    public void test(){
        int intervals[][]=new int[][]{{1,5},{6,8}};
        int newInterval[]=new int[]{5,6};

        int res[][]=insert(intervals,newInterval);
        for(int i[]:res){
            System.out.println(i[0]+" "+i[1]);
        }
    }
}
