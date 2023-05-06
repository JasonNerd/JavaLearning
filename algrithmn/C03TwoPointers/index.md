---
title: "C03TwoPointers"
date: 2023-03-23T15:12:25+08:00
draft: true
tags: ["Java", "算法", "TwoPointers", "LeetCode"]
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
*   快慢指针可以查找重复数字，时间复杂度 O(n)，第 287 题。
*   替换字母以后，相同字母能出现连续最长的长度。第 424 题。
*   SUM 问题集。第 1 题，第 15 题，第 16 题，第 18 题，第 167 题，第 923 题，第 1074 题。


|No.|Title|Solution|Difficulty|TimeComplexity|SpaceComplexity|Favorite|Acceptance
|:-:|:-|:-|:-|:-|:-|:-|:-|
0011|Container With Most Water|[Go](https://books.halfrost.com/leetcode/ChapterFour/0001~0099/0011.Container-With-Most-Water/)|Medium|O(n)|O(1)|54.3%
0015|3Sum|[Go](https://books.halfrost.com/leetcode/ChapterFour/0001~0099/0015.3Sum/)|Medium|O(n^2)|O(n)|❤️|32.2%
0016|3Sum Closest|[Go](https://books.halfrost.com/leetcode/ChapterFour/0001~0099/0016.3Sum-Closest/)|Medium|O(n^2)|O(1)|❤️|46.2%
0018|4Sum|[Go](https://books.halfrost.com/leetcode/ChapterFour/0001~0099/0018.4Sum/)|Medium|O(n^3)|O(n^2)|❤️|36.5%
0019|Remove Nth Node From End of List|[Go](https://books.halfrost.com/leetcode/ChapterFour/0001~0099/0019.Remove-Nth-Node-From-End-of-List/)|Medium|O(n)|O(1)|39.9%
0026|Remove Duplicates from Sorted Array|[Go](https://books.halfrost.com/leetcode/ChapterFour/0001~0099/0026.Remove-Duplicates-from-Sorted-Array/)|Easy|O(n)|O(1)|50.3%
0027|Remove Element|[Go](https://books.halfrost.com/leetcode/ChapterFour/0001~0099/0027.Remove-Element/)|Easy|O(n)|O(1)|52.0%
0028|Find the Index of the First Occurrence in a String|[Go](https://books.halfrost.com/leetcode/ChapterFour/0001~0099/0028.Find-the-Index-of-the-First-Occurrence-in-a-String/)|Medium|O(n)|O(1)|37.4%
0031|Next Permutation|[Go](https://books.halfrost.com/leetcode/ChapterFour/0001~0099/0031.Next-Permutation/)|Medium|37.1%
0042|Trapping Rain Water|[Go](https://books.halfrost.com/leetcode/ChapterFour/0001~0099/0042.Trapping-Rain-Water/)|Hard|O(n)|O(1)|❤️|58.7%
0061|Rotate List|[Go](https://books.halfrost.com/leetcode/ChapterFour/0001~0099/0061.Rotate-List/)|Medium|O(n)|O(1)|35.7%
0075|Sort Colors|[Go](https://books.halfrost.com/leetcode/ChapterFour/0001~0099/0075.Sort-Colors/)|Medium|O(n)|O(1)|❤️|57.1%
0080|Remove Duplicates from Sorted Array II|[Go](https://books.halfrost.com/leetcode/ChapterFour/0001~0099/0080.Remove-Duplicates-from-Sorted-Array-II/)|Medium|O(n)|O(1|51.5%
0082|Remove Duplicates from Sorted List II|[Go](https://books.halfrost.com/leetcode/ChapterFour/0001~0099/0082.Remove-Duplicates-from-Sorted-List-II/)|Medium|45.4%
0086|Partition List|[Go](https://books.halfrost.com/leetcode/ChapterFour/0001~0099/0086.Partition-List/)|Medium|O(n)|O(1)|❤️|51.3%
0088|Merge Sorted Array|[Go](https://books.halfrost.com/leetcode/ChapterFour/0001~0099/0088.Merge-Sorted-Array/)|Easy|O(n)|O(1)|❤️|45.7%
0125|Valid Palindrome|[Go](https://books.halfrost.com/leetcode/ChapterFour/0100~0199/0125.Valid-Palindrome/)|Easy|O(n)|O(1)|43.5%
0141|Linked List Cycle|[Go](https://books.halfrost.com/leetcode/ChapterFour/0100~0199/0141.Linked-List-Cycle/)|Easy|O(n)|O(1)|❤️|46.8%
0142|Linked List Cycle II|[Go](https://books.halfrost.com/leetcode/ChapterFour/0100~0199/0142.Linked-List-Cycle-II/)|Medium|O(n)|O(1)|❤️|46.2%
0143|Reorder List|[Go](https://books.halfrost.com/leetcode/ChapterFour/0100~0199/0143.Reorder-List/)|Medium|50.9%
0148|Sort List|[Go](https://books.halfrost.com/leetcode/ChapterFour/0100~0199/0148.Sort-List/)|Medium|54.0%
0151|Reverse Words in a String|[Go](https://books.halfrost.com/leetcode/ChapterFour/0100~0199/0151.Reverse-Words-in-a-String/)|Medium|30.2%
0160|Intersection of Two Linked Lists|[Go](https://books.halfrost.com/leetcode/ChapterFour/0100~0199/0160.Intersection-of-Two-Linked-Lists/)|Easy|53.1%
0167|Two Sum II - Input Array Is Sorted|[Go](https://books.halfrost.com/leetcode/ChapterFour/0100~0199/0167.Two-Sum-II-Input-array-is-sorted/)|Medium|O(n)|O(1)|60.0%
0189|Rotate Array|[Go](https://books.halfrost.com/leetcode/ChapterFour/0100~0199/0189.Rotate-Array/)|Medium|39.2%
0202|Happy Number|[Go](https://books.halfrost.com/leetcode/ChapterFour/0200~0299/0202.Happy-Number/)|Easy|54.3%
0234|Palindrome Linked List|[Go](https://books.halfrost.com/leetcode/ChapterFour/0200~0299/0234.Palindrome-Linked-List/)|Easy|O(n)|O(1)|49.4%
0283|Move Zeroes|[Go](https://books.halfrost.com/leetcode/ChapterFour/0200~0299/0283.Move-Zeroes/)|Easy|O(n)|O(1)|61.3%
0287|Find the Duplicate Number|[Go](https://books.halfrost.com/leetcode/ChapterFour/0200~0299/0287.Find-the-Duplicate-Number/)|Medium|O(n)|O(1)|❤️|59.1%
0344|Reverse String|[Go](https://books.halfrost.com/leetcode/ChapterFour/0300~0399/0344.Reverse-String/)|Easy|O(n)|O(1)|76.1%
0345|Reverse Vowels of a String|[Go](https://books.halfrost.com/leetcode/ChapterFour/0300~0399/0345.Reverse-Vowels-of-a-String/)|Easy|O(n)|O(1)|47.7%
0349|Intersection of Two Arrays|[Go](https://books.halfrost.com/leetcode/ChapterFour/0300~0399/0349.Intersection-of-Two-Arrays/)|Easy|O(n)|O(n)|70.2%
0350|Intersection of Two Arrays II|[Go](https://books.halfrost.com/leetcode/ChapterFour/0300~0399/0350.Intersection-of-Two-Arrays-II/)|Easy|O(n)|O(n)|55.5%
0392|Is Subsequence|[Go](https://books.halfrost.com/leetcode/ChapterFour/0300~0399/0392.Is-Subsequence/)|Easy|49.3%
0455|Assign Cookies|[Go](https://books.halfrost.com/leetcode/ChapterFour/0400~0499/0455.Assign-Cookies/)|Easy|50.6%
0457|Circular Array Loop|[Go](https://books.halfrost.com/leetcode/ChapterFour/0400~0499/0457.Circular-Array-Loop/)|Medium|32.1%
0475|Heaters|[Go](https://books.halfrost.com/leetcode/ChapterFour/0400~0499/0475.Heaters/)|Medium|36.0%
0524|Longest Word in Dictionary through Deleting|[Go](https://books.halfrost.com/leetcode/ChapterFour/0500~0599/0524.Longest-Word-in-Dictionary-through-Deleting/)|Medium|O(n)|O(1)|51.2%
0532|K-diff Pairs in an Array|[Go](https://books.halfrost.com/leetcode/ChapterFour/0500~0599/0532.K-diff-Pairs-in-an-Array/)|Medium|O(n)|O(n)|40.7%
0541|Reverse String II|[Go](https://books.halfrost.com/leetcode/ChapterFour/0500~0599/0541.Reverse-String-II/)|Easy|50.5%
0557|Reverse Words in a String III|[Go](https://books.halfrost.com/leetcode/ChapterFour/0500~0599/0557.Reverse-Words-in-a-String-III/)|Easy|81.5%
0567|Permutation in String|[Go](https://books.halfrost.com/leetcode/ChapterFour/0500~0599/0567.Permutation-in-String/)|Medium|O(n)|O(1)|❤️|43.8%
0581|Shortest Unsorted Continuous Subarray|[Go](https://books.halfrost.com/leetcode/ChapterFour/0500~0599/0581.Shortest-Unsorted-Continuous-Subarray/)|Medium|36.2%
0611|Valid Triangle Number|[Go](https://books.halfrost.com/leetcode/ChapterFour/0600~0699/0611.Valid-Triangle-Number/)|Medium|50.3%
0633|Sum of Square Numbers|[Go](https://books.halfrost.com/leetcode/ChapterFour/0600~0699/0633.Sum-of-Square-Numbers/)|Medium|34.7%
0653|Two Sum IV - Input is a BST|[Go](https://books.halfrost.com/leetcode/ChapterFour/0600~0699/0653.Two-Sum-IV-Input-is-a-BST/)|Easy|60.9%
0658|Find K Closest Elements|[Go](https://books.halfrost.com/leetcode/ChapterFour/0600~0699/0658.Find-K-Closest-Elements/)|Medium|46.7%
0696|Count Binary Substrings|[Go](https://books.halfrost.com/leetcode/ChapterFour/0600~0699/0696.Count-Binary-Substrings/)|Easy|65.5%
0719|Find K-th Smallest Pair Distance|[Go](https://books.halfrost.com/leetcode/ChapterFour/0700~0799/0719.Find-K-th-Smallest-Pair-Distance/)|Hard|36.3%
0763|Partition Labels|[Go](https://books.halfrost.com/leetcode/ChapterFour/0700~0799/0763.Partition-Labels/)|Medium|O(n)|O(1)|❤️|79.8%
0795|Number of Subarrays with Bounded Maximum|[Go](https://books.halfrost.com/leetcode/ChapterFour/0700~0799/0795.Number-of-Subarrays-with-Bounded-Maximum/)|Medium|52.7%
0821|Shortest Distance to a Character|[Go](https://books.halfrost.com/leetcode/ChapterFour/0800~0899/0821.Shortest-Distance-to-a-Character/)|Easy|71.3%
0825|Friends Of Appropriate Ages|[Go](https://books.halfrost.com/leetcode/ChapterFour/0800~0899/0825.Friends-Of-Appropriate-Ages/)|Medium|46.3%
0826|Most Profit Assigning Work|[Go](https://books.halfrost.com/leetcode/ChapterFour/0800~0899/0826.Most-Profit-Assigning-Work/)|Medium|O(n log n)|O(n)|44.3%
0832|Flipping an Image|[Go](https://books.halfrost.com/leetcode/ChapterFour/0800~0899/0832.Flipping-an-Image/)|Easy|80.3%
0838|Push Dominoes|[Go](https://books.halfrost.com/leetcode/ChapterFour/0800~0899/0838.Push-Dominoes/)|Medium|O(n)|O(n)|57.0%
0844|Backspace String Compare|[Go](https://books.halfrost.com/leetcode/ChapterFour/0800~0899/0844.Backspace-String-Compare/)|Easy|O(n)|O(n)|48.0%
0845|Longest Mountain in Array|[Go](https://books.halfrost.com/leetcode/ChapterFour/0800~0899/0845.Longest-Mountain-in-Array/)|Medium|O(n)|O(1)|40.1%
0870|Advantage Shuffle|[Go](https://books.halfrost.com/leetcode/ChapterFour/0800~0899/0870.Advantage-Shuffle/)|Medium|51.6%
0876|Middle of the Linked List|[Go](https://books.halfrost.com/leetcode/ChapterFour/0800~0899/0876.Middle-of-the-Linked-List/)|Easy|73.7%
0881|Boats to Save People|[Go](https://books.halfrost.com/leetcode/ChapterFour/0800~0899/0881.Boats-to-Save-People/)|Medium|O(n log n)|O(1)|52.7%
0922|Sort Array By Parity II|[Go](https://books.halfrost.com/leetcode/ChapterFour/0900~0999/0922.Sort-Array-By-Parity-II/)|Easy|70.7%
0923|3Sum With Multiplicity|[Go](https://books.halfrost.com/leetcode/ChapterFour/0900~0999/0923.3Sum-With-Multiplicity/)|Medium|O(n^2)|O(n)|45.4%
0925|Long Pressed Name|[Go](https://books.halfrost.com/leetcode/ChapterFour/0900~0999/0925.Long-Pressed-Name/)|Easy|O(n)|O(1)|33.8%
0942|DI String Match|[Go](https://books.halfrost.com/leetcode/ChapterFour/0900~0999/0942.DI-String-Match/)|Easy|76.6%
0969|Pancake Sorting|[Go](https://books.halfrost.com/leetcode/ChapterFour/0900~0999/0969.Pancake-Sorting/)|Medium|70.0%
0977|Squares of a Sorted Array|[Go](https://books.halfrost.com/leetcode/ChapterFour/0900~0999/0977.Squares-of-a-Sorted-Array/)|Easy|O(n)|O(1)|71.9%
0986|Interval List Intersections|[Go](https://books.halfrost.com/leetcode/ChapterFour/0900~0999/0986.Interval-List-Intersections/)|Medium|O(n)|O(1)|71.4%
1040|Moving Stones Until Consecutive II|[Go](https://books.halfrost.com/leetcode/ChapterFour/1000~1099/1040.Moving-Stones-Until-Consecutive-II/)|Medium|55.6%
1048|Longest String Chain|[Go](https://books.halfrost.com/leetcode/ChapterFour/1000~1099/1048.Longest-String-Chain/)|Medium|59.2%
1089|Duplicate Zeros|[Go](https://books.halfrost.com/leetcode/ChapterFour/1000~1099/1089.Duplicate-Zeros/)|Easy|51.5%
1093|Statistics from a Large Sample|[Go](https://books.halfrost.com/leetcode/ChapterFour/1000~1099/1093.Statistics-from-a-Large-Sample/)|Medium|O(n)|O(1)|44.7%
1332|Remove Palindromic Subsequences|[Go](https://books.halfrost.com/leetcode/ChapterFour/1300~1399/1332.Remove-Palindromic-Subsequences/)|Easy|76.1%
1385|Find the Distance Value Between Two Arrays|[Go](https://books.halfrost.com/leetcode/ChapterFour/1300~1399/1385.Find-the-Distance-Value-Between-Two-Arrays/)|Easy|65.3%
1679|Max Number of K-Sum Pairs|[Go](https://books.halfrost.com/leetcode/ChapterFour/1600~1699/1679.Max-Number-of-K-Sum-Pairs/)|Medium|57.4%
1721|Swapping Nodes in a Linked List|[Go](https://books.halfrost.com/leetcode/ChapterFour/1700~1799/1721.Swapping-Nodes-in-a-Linked-List/)|Medium|67.8%
1877|Minimize Maximum Pair Sum in Array|[Go](https://books.halfrost.com/leetcode/ChapterFour/1800~1899/1877.Minimize-Maximum-Pair-Sum-in-Array/)|Medium|80.4%
