package C02String.P0003;

import java.util.HashSet;
import java.util.Set;

public class Solution{
    public int lengthOfLongestSubstring(String s) {
        // 对于解法2, 不妨设立全局的 "Set"
        int[] ch_freq = new int[128];   // 记录 [i, j]子集内字符出现次数, 已初始化为0
        int i = 0, j = -1, n = s.length(), res=0;  // s可能为空
        while(i<n){
            if((j+1)<n && ch_freq[s.charAt(j+1)]==0){
                ++j;
                ++ch_freq[s.charAt(j)];
            }else{
                --ch_freq[s.charAt(i)];
                ++i;
            }
            res = (j-i+1) > res ? j-i+1:res;
        }
        return res;
    }
    public int lengthOfLongestSubstring2(String s) {
        // 指针 i 遍历 [0, n), 指针 j 从 i开始遍历
        Set<Character> wrkSet = new HashSet<>();
        int slen = s.length(), res = 0;
        for(int i=0; i<slen; i++){
            wrkSet.clear();
            // 指针j 查询指向元素是否落入 [i, j)子集内
            for(int j=i; j<slen; j++){
                if(wrkSet.contains(s.charAt(j)))
                    break;  // 一旦发现有重复元素, 就跳出循环
                else wrkSet.add(s.charAt(j));
            }
            res = res > wrkSet.size() ? res : wrkSet.size();
        }
        return res;
    }
    public int lengthOfLongestSubstring3(String s) {
        // 指针 i 遍历 [0, n), 指针 j 从 i开始遍历
        Set<Character> wrkSet = new HashSet<>();
        int slen = s.length(), res = 0, i, j;
        for(i=0; i<slen; ){
            wrkSet.clear();
            // 指针j 查询指向元素是否落入 [i, j)子集内
            for(j=i; j<slen; j++){
                if(wrkSet.contains(s.charAt(j)))
                    break;  // 一旦发现有重复元素, 就跳出循环
                else wrkSet.add(s.charAt(j));
            }
            res = res > wrkSet.size() ? res : wrkSet.size();
            if(j == slen)   // j 如果到了尾端 不用继续迭代i
                break;
            // 相对于2改了这样一步, 找到具体是哪一个与[j]相同的元素下标
            for(int k=i; k<j; k++)
                if(s.charAt(k) == s.charAt(j)){
                    i = k+1;    // 更新下标i
                    break;
                }
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring("dvdf"));
        System.out.println(new Solution().lengthOfLongestSubstring(" "));
        System.out.println(new Solution().lengthOfLongestSubstring("au"));

    }
}