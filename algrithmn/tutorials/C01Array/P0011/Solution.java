package C01Array.P0011;
// 问题描述:
// max{(j-i)*min(A[i], A[j])} (0 <= i < j < n)

public class Solution{
    public int maxArea(int[] height){
        int n = height.length, i=0, j=n-1;  // 设定首尾指针
        int res = 0;
        while(i<j){
            int trs = (j-i)*(height[i]>height[j]?height[j]:height[i]);
            res = trs > res ? trs : res;
            if(height[i]<height[j])++i;     // 关键: 舍弃短板
            else --j;
        }
        return res;
    }
    public int maxArea2(int[] height){
        // 暴力搜索, i, j两层遍历 O(n^2)
        int res = 0, n = height.length;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                int trs = (j-i)*(height[i]>height[j]?height[j]:height[i]);
                res = trs > res ? trs : res;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] a = {1,9,6,2,5,4,8,5,7};
        System.out.println(new Solution().maxArea(a));
    }
}