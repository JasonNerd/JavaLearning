package C01Array.P0004;
/*
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * You may assume nums1 and nums2 cannot be both empty.
 */
interface Solve{
    double findMid(int[] nums1, int[] nums2);
}

class MergeSort implements Solve{
    public double findMid(int[] nums1, int[] nums2){
        // 将 nums1 和 nums2 归并, 时间复杂度和空间复杂度均为 O(m+n)
        int m = nums1.length, n = nums2.length, l = m+n;
        int [] tmp = new int[l];
        int p1 = 0, p2 = 0, k=0;    // 三个指针
        while(p1 <m && p2 <n){
            // 将较小的压入 tmp 并移动指针
            if(nums1[p1] < nums2[p2]){
                tmp[k++] = nums1[p1++]; 
            }else{
                tmp[k++] = nums2[p2++];
            }
        }
        // 将未遍历完成的数组的剩余部分压入 tmp
        while(p1<m) tmp[k++] = nums1[p1++];
        while(p2<n) tmp[k++] = nums2[p2++];
        // 根据 l 的奇偶性 返回结果
        if (l%2==0){
            return (double)(tmp[l/2]+tmp[l/2-1])/2;
        }else{
            return tmp[l/2];
        }
    }
}

class VirtualMerge implements Solve{
    @Override
    public double findMid(int[] nums1, int[] nums2){
        int m = nums1.length, n = nums2.length, l = m + n;
        int p1=0, p2=0, k=0;
        int prev = 0;
        while(k<l/2){
            if(p1 == m && p2<n) prev = nums2[p2++];
            if(p2 == n && p1<m) prev = nums1[p1++];
            if(p1<m && p2 <n){
                if(nums1[p1] < nums2[p2]) prev = nums1[p1++];
                else prev = nums2[p2++];
            }
            ++k;
        }
        int cur = 0;    // 第 l/2+1 大的数
        if(p1 == m) cur = nums2[p2];
        else if(p2 == n) cur = nums1[p1];
        else cur = nums1[p1] < nums2[p2] ? nums1[p1] : nums2[p2];
        return l%2==0 ? (double)(prev+cur)/2: cur;
    }
    public double findMidDeprecated(int[] nums1, int[] nums2) {
        // 并不实际执行归并操作, 空间复杂度变为 O(1), 时间复杂度仍为 O(m+n)
        int m = nums1.length, n = nums2.length, l = m + n;
        int p1=0, p2=0, k=0;
        double res = 0;
        boolean flg_who = false;    // 记录最后一次移动指针的位于哪一个数组
        while (k < l/2){    // 终止条件是 k 取得中点位置
            // 注意但凡涉及到 按下标的访问, 就一定要考虑可能的越界问题
            if(p1 == m){
                ++p2;
                flg_who =false;
            }if(p2 == n){
                ++p1;
                flg_who = true;
            }
            if(p1<m && p2<n){
                if(nums1[p1] < nums2[p2]){  // nums1 当前元素更小, 则尝试移动 p1 指针
                    flg_who = true;
                    ++p1;
                }else{
                    flg_who = false;
                    ++p2;
                }
            }
            ++k;
        }
        // 此时 nums1[0, ..., p1-1]+nums2[0, ..., p2-1] 构成了 前 l/2个数 left_part[0, ..., l/2] 
        // p1指针和p2指针都可能处于越界状态
        // flg_who的设立是为了知晓 "前一个数", 再进一步思考, 不妨设定 prev, 随时记录前一个值
        // 最终 prev 实际上就是 left_part[0, ..., l/2] 中最大的一个, 因此 上述遍历的最终目的就是
        // 确定了第 l/2 大的数, 接下来借助遍历得到的指针信息得到第 l/2+1 大的数.
        if(l%2==1){ // 总长度为奇数
            if (p1 == m){   // 数组1实际遍历结束
                res = nums2[p2];
            } else if(p2 == n){ // 数组2实际遍历结束
                res = nums1[p1];
            }else{  // 都未结束取小者
                res = nums1[p1] < nums2[p2] ? nums1[p1] : nums2[p2];
            } 
        }else{
            if (p1 == m){ // 数组1实际遍历结束
                if(p2 == 0){    // 极端情况: 两个数组等长, 且一个数组的元素比另一个均小
                    res = (double)(nums1[p1-1]+nums2[p2]) / 2;
                }else{
                    res = (double)(nums2[p2-1]+nums2[p2]) / 2;
                }
            }else if (p2 == n){ // 数组2实际遍历结束
                if(p1 == 0){
                    res = (double)(nums2[p2-1]+nums1[p1]) / 2;
                }else{
                    res = (double)(nums1[p1-1]+nums1[p1]) / 2;
                }
            }else{  // 均未遍历完成, 取均值
                if(flg_who) // 说明最后是 nums1 中指针后移一位, 因此减 1 恢复
                    res = (double)(nums1[p1-1] + nums2[p2]) / 2;
                else res = (double)(nums1[p1] + nums2[p2-1]) / 2;
            }
        } 
        return res;
    }
    
}

public class Solution {
    static void test1(Solve solve){
        int[] nums1 = {1, 3}, nums2 = {2};
        double res = solve.findMid(nums1, nums2);
        System.out.println("The median is "+res);
    }

    static void test2(Solve solve){
        int[] nums1 = {1, 2}, nums2 = {3, 4};
        double res = solve.findMid(nums1, nums2);
        System.out.println("The median is "+res);
    }

    static void test3(Solve solve){
        int[] nums1 = {3, 4, 5}, nums2 = {1, 2};
        double res = solve.findMid(nums1, nums2);
        System.out.println("The median is "+res);
    }

    static void test4(Solve solve){
        int[] nums1 = {0, 0, 0, 0, 0}, nums2 = {-1, 0, 0, 0, 0, 0, 1};
        double res = solve.findMid(nums1, nums2);
        System.out.println("The median is "+res);
    }

    static void test(Solve solve){
        test1(solve);
        test2(solve);
        test3(solve);
        test4(solve);
    }
    public static void main(String[] args) {
        // test(new VirtualMerge());
        int[] a ={1, 2, 3}, b={};
        System.out.println(new VirtualMerge().findMid(a, b));
    }
}
/*
 * `nums1 = [1, 3] nums2 = [2] The median is 2.0`
 * `nums1 = [1, 2] nums2 = [3, 4] The median is (2 + 3)/2 = 2.5`
 * `nums1.length == m`
 * `nums2.length == n`
 * `0 <= m <= 1000`
 * `0 <= n <= 1000`
 * `1 <= m + n <= 2000`
 * `-106 <= nums1[i], nums2[i] <= 106`
 */