package C01Array.P0026;

class Solution {
    public int removeDuplicates(int[] nums) {
        int i=0, j=i+1;
        while (j < nums.length){
            if(nums[i] != nums[j]){ // 遍历到一个新元素
                nums[++i] = nums[j];
            }
            ++j;
        }
        return i+1;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int l = new Solution().removeDuplicates(nums);
        for(int i=0; i<l; i++)
            System.out.print(nums[i]+" ");
    }
}