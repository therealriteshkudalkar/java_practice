package problem5;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        if (nums.length == 0) {
            return list;
        } else if (nums.length == 1) {
            list.add(Integer.toString(nums[0]));
            return list;
        }
        int lb = nums[0];
        int ub = nums[0];
        for(int i = 1; i < nums.length; i++) {
            int currNum = nums[i];
            if (i == nums.length - 1) {
                // Is there loner at the back
                if (currNum - 1 != ub) {
                    if (lb == ub) {
                        list.add(Integer.toString(lb));
                    } else {
                        list.add(lb + "->" + ub);
                    }
                    list.add(Integer.toString(currNum));
                } else {
                    ub = currNum;
                    list.add(lb + "->" + ub);
                }
            } else if (i == 1) {
                // Is there loner at the front
                if (currNum - 1 != ub) {
                    list.add(Integer.toString(nums[0]));
                    lb = nums[i];
                }
                ub = nums[i];
            } else {
                // Is there a loner in the middle
                if (currNum - 1 != ub) {
                    if (lb == ub) {
                        list.add(Integer.toString(lb));
                    } else {
                        list.add(lb + "->" + ub);
                    }
                    lb = currNum;
                }
                ub = currNum;
            }
        }
        return list;
    }
}
