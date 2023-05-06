---
title: "C17SildingWindow"
date: 2023-03-23T16:31:51+08:00
draft: true
tags: ["Java", "算法", "SlidingWindow", "LeetCode"]
categories: ["LeetCode"]
twemoji: true
lightgallery: true
---


*   双指针滑动窗口的经典写法。右指针不断往右移，移动到不能往右移动为止(具体条件根据题目而定)。当右指针到最右边以后，开始挪动左指针，释放窗口左边界。第 3 题，第 76 题，第 209 题，第 424 题，第 438 题，第 567 题，第 713 题，第 763 题，第 845 题，第 881 题，第 904 题，第 978 题，第 992 题，第 1004 题，第 1040 题，第 1052 题。

```go
left, right := 0, -1
for left < len(s) {
    if right+1 < len(s) && freq[s[right+1]-'a'] == 0 {
        freq[s[right+1]-'a']++
        right++
    } else {
        freq[s[left]-'a']--
        left++
    }
    result = max(result, right-left+1)
}
```    
*   滑动窗口经典题。第 239 题，第 480 题。


No.|Title|Solution|Difficulty|TimeComplexity|SpaceComplexity|Favorite|Acceptance
|:-:|:-|:-|:-|:-|:-|:-|:-|
0003|Longest Substring Without Repeating Characters|[Go](https://books.halfrost.com/leetcode/ChapterFour/0001~0099/0003.Longest-Substring-Without-Repeating-Characters/)|Medium|O(n)|O(1)|❤️|33.8%
0030|Substring with Concatenation of All Words|[Go](https://books.halfrost.com/leetcode/ChapterFour/0001~0099/0030.Substring-with-Concatenation-of-All-Words/)|Hard|30.9%
0076|Minimum Window Substring|[Go](https://books.halfrost.com/leetcode/ChapterFour/0001~0099/0076.Minimum-Window-Substring/)|Hard|O(n)|O(n)|❤️|40.0%
0187|Repeated DNA Sequences|[Go](https://books.halfrost.com/leetcode/ChapterFour/0100~0199/0187.Repeated-DNA-Sequences/)|Medium|46.1%
0209|Minimum Size Subarray Sum|[Go](https://books.halfrost.com/leetcode/ChapterFour/0200~0299/0209.Minimum-Size-Subarray-Sum/)|Medium|44.4%
0219|Contains Duplicate II|[Go](https://books.halfrost.com/leetcode/ChapterFour/0200~0299/0219.Contains-Duplicate-II/)|Easy|40.9%
0220|Contains Duplicate III|[Go](https://books.halfrost.com/leetcode/ChapterFour/0200~0299/0220.Contains-Duplicate-III/)|Hard|21.8%
0239|Sliding Window Maximum|[Go](https://books.halfrost.com/leetcode/ChapterFour/0200~0299/0239.Sliding-Window-Maximum/)|Hard|O(n \* k)|O(n)|❤️|46.6%
0395|Longest Substring with At Least K Repeating Characters|[Go](https://books.halfrost.com/leetcode/ChapterFour/0300~0399/0395.Longest-Substring-with-At-Least-K-Repeating-Characters/)|Medium|44.8%
0424|Longest Repeating Character Replacement|[Go](https://books.halfrost.com/leetcode/ChapterFour/0400~0499/0424.Longest-Repeating-Character-Replacement/)|Medium|O(n)|O(1)|51.4%
0438|Find All Anagrams in a String|[Go](https://books.halfrost.com/leetcode/ChapterFour/0400~0499/0438.Find-All-Anagrams-in-a-String/)|Medium|48.9%
0480|Sliding Window Median|[Go](https://books.halfrost.com/leetcode/ChapterFour/0400~0499/0480.Sliding-Window-Median/)|Hard|O(n \* log k)|O(k)|❤️|41.4%
0567|Permutation in String|[Go](https://books.halfrost.com/leetcode/ChapterFour/0500~0599/0567.Permutation-in-String/)|Medium|O(n)|O(1)|❤️|43.8%
0632|Smallest Range Covering Elements from K Lists|[Go](https://books.halfrost.com/leetcode/ChapterFour/0600~0699/0632.Smallest-Range-Covering-Elements-from-K-Lists/)|Hard|60.4%
0643|Maximum Average Subarray I|[Go](https://books.halfrost.com/leetcode/ChapterFour/0600~0699/0643.Maximum-Average-Subarray-I/)|Easy|43.8%
0658|Find K Closest Elements|[Go](https://books.halfrost.com/leetcode/ChapterFour/0600~0699/0658.Find-K-Closest-Elements/)|Medium|46.7%
0713|Subarray Product Less Than K|[Go](https://books.halfrost.com/leetcode/ChapterFour/0700~0799/0713.Subarray-Product-Less-Than-K/)|Medium|45.0%
0718|Maximum Length of Repeated Subarray|[Go](https://books.halfrost.com/leetcode/ChapterFour/0700~0799/0718.Maximum-Length-of-Repeated-Subarray/)|Medium|51.6%
0862|Shortest Subarray with Sum at Least K|[Go](https://books.halfrost.com/leetcode/ChapterFour/0800~0899/0862.Shortest-Subarray-with-Sum-at-Least-K/)|Hard|26.1%
0904|Fruit Into Baskets|[Go](https://books.halfrost.com/leetcode/ChapterFour/0900~0999/0904.Fruit-Into-Baskets/)|Medium|42.6%
0930|Binary Subarrays With Sum|[Go](https://books.halfrost.com/leetcode/ChapterFour/0900~0999/0930.Binary-Subarrays-With-Sum/)|Medium|50.9%
0978|Longest Turbulent Subarray|[Go](https://books.halfrost.com/leetcode/ChapterFour/0900~0999/0978.Longest-Turbulent-Subarray/)|Medium|O(n)|O(1)|❤️|47.4%
0992|Subarrays with K Different Integers|[Go](https://books.halfrost.com/leetcode/ChapterFour/0900~0999/0992.Subarrays-with-K-Different-Integers/)|Hard|O(n)|O(n)|❤️|54.3%
0995|Minimum Number of K Consecutive Bit Flips|[Go](https://books.halfrost.com/leetcode/ChapterFour/0900~0999/0995.Minimum-Number-of-K-Consecutive-Bit-Flips/)|Hard|O(n)|O(1)|❤️|51.1%
1004|Max Consecutive Ones III|[Go](https://books.halfrost.com/leetcode/ChapterFour/1000~1099/1004.Max-Consecutive-Ones-III/)|Medium|O(n)|O(1)|63.5%
1052|Grumpy Bookstore Owner|[Go](https://books.halfrost.com/leetcode/ChapterFour/1000~1099/1052.Grumpy-Bookstore-Owner/)|Medium|O(n log n)|O(1)|57.0%
1208|Get Equal Substrings Within Budget|[Go](https://books.halfrost.com/leetcode/ChapterFour/1200~1299/1208.Get-Equal-Substrings-Within-Budget/)|Medium|47.6%
1234|Replace the Substring for Balanced String|[Go](https://books.halfrost.com/leetcode/ChapterFour/1200~1299/1234.Replace-the-Substring-for-Balanced-String/)|Medium|36.8%
1423|Maximum Points You Can Obtain from Cards|[Go](https://books.halfrost.com/leetcode/ChapterFour/1400~1499/1423.Maximum-Points-You-Can-Obtain-from-Cards/)|Medium|52.3%
1438|Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit|[Go](https://books.halfrost.com/leetcode/ChapterFour/1400~1499/1438.Longest-Continuous-Subarray-With-Absolute-Diff-Less-Than-or-Equal-to-Limit/)|Medium|48.0%
1658|Minimum Operations to Reduce X to Zero|[Go](https://books.halfrost.com/leetcode/ChapterFour/1600~1699/1658.Minimum-Operations-to-Reduce-X-to-Zero/)|Medium|37.6%
1695|Maximum Erasure Value|[Go](https://books.halfrost.com/leetcode/ChapterFour/1600~1699/1695.Maximum-Erasure-Value/)|Medium|57.7%
1696|Jump Game VI|[Go](https://books.halfrost.com/leetcode/ChapterFour/1600~1699/1696.Jump-Game-VI/)|Medium|46.3%
1763|Longest Nice Substring|[Go](https://books.halfrost.com/leetcode/ChapterFour/1700~1799/1763.Longest-Nice-Substring/)|Easy|61.7%
1984|Minimum Difference Between Highest and Lowest of K Scores|[Go](https://books.halfrost.com/leetcode/ChapterFour/1900~1999/1984.Minimum-Difference-Between-Highest-and-Lowest-of-K-Scores/)|Easy|53.5%