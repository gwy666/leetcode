package first200;

public class Lc45 {

    public int jump(int[] nums) {
        int n=nums.length;
        int curMax=0;
        int nextMax=nums[0];
        int step=1;
        for(int i=1;i<n;i++){
            if(i<=curMax){
                nextMax=Math.max(nextMax,i+nums[i]);
                if(nextMax>=n-1)return step;
            }
            else{
                step++;
                curMax=nextMax;
            }
        }
        return 0;
    }
}
