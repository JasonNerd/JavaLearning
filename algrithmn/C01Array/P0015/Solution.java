package C01Array.P0015;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().threeSum(new int[]{-1, 0, 1, -1, 2}));
    }
    public List<List<Integer>> threeSum(int[] nums) {
        // 注意此处不同于 two sum, 输出的三元组是数组中的元素而非下标
        Arrays.sort(nums);  // 先排个序
        int target = 0;
        Set<List<Integer>> s = new HashSet<>();
        List<List<Integer>> output = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            int j = i+1, k = nums.length-1;
            while(j < k){
                int ijk = nums[i]+nums[j]+nums[k];
                if(ijk == target){
                    s.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                }else if(ijk < target){
                    j++;
                }else{
                    k--;
                }
            }
        }
        output.addAll(s);
        return output;
    }
}
