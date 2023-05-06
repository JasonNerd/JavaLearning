---
title: "C04LinkedList"
date: 2023-03-23T15:33:04+08:00
draft: true
tags: ["Java", "算法", "LinkedList", "LeetCode"]
categories: ["LeetCode"]
twemoji: true
lightgallery: true
---


*   巧妙的构造虚拟头结点。可以使遍历处理逻辑更加统一。
*   灵活使用递归。构造递归条件，使用递归可以巧妙的解题。不过需要注意有些题目不能使用递归，因为递归深度太深会导致超时和栈溢出。
*   链表区间逆序。第 92 题。
*   链表寻找中间节点。第 876 题。链表寻找倒数第 n 个节点。第 19 题。只需要一次遍历就可以得到答案。
*   合并 K 个有序链表。第 21 题，第 23 题。
*   链表归类。第 86 题，第 328 题。
*   链表排序，时间复杂度要求 O(n \* log n)，空间复杂度 O(1)。只有一种做法，归并排序，至顶向下归并。第 148 题。
*   判断链表是否存在环，如果有环，输出环的交叉点的下标；判断 2 个链表是否有交叉点，如果有交叉点，输出交叉点。第 141 题，第 142 题，第 160 题。


No.|Title|Solution|Difficulty|TimeComplexity|SpaceComplexity|Favorite|Acceptance
|:-:|:-|:-|:-|:-|:-|:-|:-|
0002|Add Two Numbers|[Go](https://books.halfrost.com/leetcode/ChapterFour/0001~0099/0002.Add-Two-Numbers/)|Medium|O(n)|O(1)|39.7%
0019|Remove Nth Node From End of List|[Go](https://books.halfrost.com/leetcode/ChapterFour/0001~0099/0019.Remove-Nth-Node-From-End-of-List/)|Medium|O(n)|O(1)|39.9%
0021|Merge Two Sorted Lists|[Go](https://books.halfrost.com/leetcode/ChapterFour/0001~0099/0021.Merge-Two-Sorted-Lists/)|Easy|O(log n)|O(1)|61.8%
0023|Merge k Sorted Lists|[Go](https://books.halfrost.com/leetcode/ChapterFour/0001~0099/0023.Merge-k-Sorted-Lists/)|Hard|O(log n)|O(1)|❤️|48.3%
0024|Swap Nodes in Pairs|[Go](https://books.halfrost.com/leetcode/ChapterFour/0001~0099/0024.Swap-Nodes-in-Pairs/)|Medium|O(n)|O(1)|60.3%
0025|Reverse Nodes in k-Group|[Go](https://books.halfrost.com/leetcode/ChapterFour/0001~0099/0025.Reverse-Nodes-in-k-Group/)|Hard|O(log n)|O(1)|❤️|53.4%
0061|Rotate List|[Go](https://books.halfrost.com/leetcode/ChapterFour/0001~0099/0061.Rotate-List/)|Medium|O(n)|O(1)|35.7%
0082|Remove Duplicates from Sorted List II|[Go](https://books.halfrost.com/leetcode/ChapterFour/0001~0099/0082.Remove-Duplicates-from-Sorted-List-II/)|Medium|O(n)|O(1)|45.4%
0083|Remove Duplicates from Sorted List|[Go](https://books.halfrost.com/leetcode/ChapterFour/0001~0099/0083.Remove-Duplicates-from-Sorted-List/)|Easy|O(n)|O(1)|49.8%
0086|Partition List|[Go](https://books.halfrost.com/leetcode/ChapterFour/0001~0099/0086.Partition-List/)|Medium|O(n)|O(1)|❤️|51.3%
0092|Reverse Linked List II|[Go](https://books.halfrost.com/leetcode/ChapterFour/0001~0099/0092.Reverse-Linked-List-II/)|Medium|O(n)|O(1)|❤️|45.3%
0109|Convert Sorted List to Binary Search Tree|[Go](https://books.halfrost.com/leetcode/ChapterFour/0100~0199/0109.Convert-Sorted-List-to-Binary-Search-Tree/)|Medium|O(log n)|O(n)|57.2%
0114|Flatten Binary Tree to Linked List|[Go](https://books.halfrost.com/leetcode/ChapterFour/0100~0199/0114.Flatten-Binary-Tree-to-Linked-List/)|Medium|61.0%
0116|Populating Next Right Pointers in Each Node|[Go](https://books.halfrost.com/leetcode/ChapterFour/0100~0199/0116.Populating-Next-Right-Pointers-in-Each-Node/)|Medium|59.3%
0138|Copy List with Random Pointer|[Go](https://books.halfrost.com/leetcode/ChapterFour/0100~0199/0138.Copy-List-With-Random-Pointer/)|Medium|50.4%
0141|Linked List Cycle|[Go](https://books.halfrost.com/leetcode/ChapterFour/0100~0199/0141.Linked-List-Cycle/)|Easy|O(n)|O(1)|❤️|46.8%
0142|Linked List Cycle II|[Go](https://books.halfrost.com/leetcode/ChapterFour/0100~0199/0142.Linked-List-Cycle-II/)|Medium|O(n)|O(1)|❤️|46.2%
0143|Reorder List|[Go](https://books.halfrost.com/leetcode/ChapterFour/0100~0199/0143.Reorder-List/)|Medium|O(n)|O(1)|❤️|50.9%
0146|LRU Cache|[Go](https://books.halfrost.com/leetcode/ChapterFour/0100~0199/0146.LRU-Cache/)|Medium|40.5%
0147|Insertion Sort List|[Go](https://books.halfrost.com/leetcode/ChapterFour/0100~0199/0147.Insertion-Sort-List/)|Medium|O(n)|O(1)|❤️|50.1%
0148|Sort List|[Go](https://books.halfrost.com/leetcode/ChapterFour/0100~0199/0148.Sort-List/)|Medium|O(n log n)|O(n)|❤️|54.0%
0160|Intersection of Two Linked Lists|[Go](https://books.halfrost.com/leetcode/ChapterFour/0100~0199/0160.Intersection-of-Two-Linked-Lists/)|Easy|O(n)|O(1)|❤️|53.1%
0203|Remove Linked List Elements|[Go](https://books.halfrost.com/leetcode/ChapterFour/0200~0299/0203.Remove-Linked-List-Elements/)|Easy|O(n)|O(1)|44.7%
0206|Reverse Linked List|[Go](https://books.halfrost.com/leetcode/ChapterFour/0200~0299/0206.Reverse-Linked-List/)|Easy|O(n)|O(1)|72.3%
0234|Palindrome Linked List|[Go](https://books.halfrost.com/leetcode/ChapterFour/0200~0299/0234.Palindrome-Linked-List/)|Easy|O(n)|O(1)|49.4%
0237|Delete Node in a Linked List|[Go](https://books.halfrost.com/leetcode/ChapterFour/0200~0299/0237.Delete-Node-in-a-Linked-List/)|Medium|O(n)|O(1)|75.1%
0328|Odd Even Linked List|[Go](https://books.halfrost.com/leetcode/ChapterFour/0300~0399/0328.Odd-Even-Linked-List/)|Medium|O(n)|O(1)|60.2%
0382|Linked List Random Node|[Go](https://books.halfrost.com/leetcode/ChapterFour/0300~0399/0382.Linked-List-Random-Node/)|Medium|59.5%
0445|Add Two Numbers II|[Go](https://books.halfrost.com/leetcode/ChapterFour/0400~0499/0445.Add-Two-Numbers-II/)|Medium|O(n)|O(n)|59.4%
0460|LFU Cache|[Go](https://books.halfrost.com/leetcode/ChapterFour/0400~0499/0460.LFU-Cache/)|Hard|40.3%
0622|Design Circular Queue|[Go](https://books.halfrost.com/leetcode/ChapterFour/0600~0699/0622.Design-Circular-Queue/)|Medium|51.8%
0705|Design HashSet|[Go](https://books.halfrost.com/leetcode/ChapterFour/0700~0799/0705.Design-HashSet/)|Easy|66.0%
0706|Design HashMap|[Go](https://books.halfrost.com/leetcode/ChapterFour/0700~0799/0706.Design-HashMap/)|Easy|65.1%
0707|Design Linked List|[Go](https://books.halfrost.com/leetcode/ChapterFour/0700~0799/0707.Design-Linked-List/)|Medium|O(n)|O(1)|27.5%
0725|Split Linked List in Parts|[Go](https://books.halfrost.com/leetcode/ChapterFour/0700~0799/0725.Split-Linked-List-in-Parts/)|Medium|O(n)|O(1)|57.2%
0817|Linked List Components|[Go](https://books.halfrost.com/leetcode/ChapterFour/0800~0899/0817.Linked-List-Components/)|Medium|O(n)|O(1)|58.1%
0876|Middle of the Linked List|[Go](https://books.halfrost.com/leetcode/ChapterFour/0800~0899/0876.Middle-of-the-Linked-List/)|Easy|O(n)|O(1)|❤️|73.7%
1019|Next Greater Node In Linked List|[Go](https://books.halfrost.com/leetcode/ChapterFour/1000~1099/1019.Next-Greater-Node-In-Linked-List/)|Medium|O(n)|O(1)|59.8%
1171|Remove Zero Sum Consecutive Nodes from Linked List|[Go](https://books.halfrost.com/leetcode/ChapterFour/1100~1199/1171.Remove-Zero-Sum-Consecutive-Nodes-from-Linked-List/)|Medium|42.9%
1290|Convert Binary Number in a Linked List to Integer|[Go](https://books.halfrost.com/leetcode/ChapterFour/1200~1299/1290.Convert-Binary-Number-in-a-Linked-List-to-Integer/)|Easy|82.6%
1669|Merge In Between Linked Lists|[Go](https://books.halfrost.com/leetcode/ChapterFour/1600~1699/1669.Merge-In-Between-Linked-Lists/)|Medium|74.5%
1670|Design Front Middle Back Queue|[Go](https://books.halfrost.com/leetcode/ChapterFour/1600~1699/1670.Design-Front-Middle-Back-Queue/)|Medium|56.4%
1721|Swapping Nodes in a Linked List|[Go](https://books.halfrost.com/leetcode/ChapterFour/1700~1799/1721.Swapping-Nodes-in-a-Linked-List/)|Medium|67.8%
2181|Merge Nodes in Between Zeros|[Go](https://books.halfrost.com/leetcode/ChapterFour/2100~2199/2181.Merge-Nodes-in-Between-Zeros/)|Medium|86.9%|
