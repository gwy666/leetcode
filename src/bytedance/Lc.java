package bytedance;

import java.util.Arrays;
import java.util.Comparator;

public class Lc {

    public void method(int nums[][]){

        Arrays.sort(nums, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
    }
}
