---
title: "C08BackTracing"
date: 2023-03-23T15:49:55+08:00
draft: true
tags: ["Java", "算法", "BackTracing", "LeetCode"]
categories: ["LeetCode"]
twemoji: true
lightgallery: true
---

*   排列问题 Permutations。第 46 题，第 47 题。第 60 题，第 526 题，第 996 题。
*   组合问题 Combination。第 39 题，第 40 题，第 77 题，第 216 题。
*   排列和组合杂交问题。第 1079 题。
*   N 皇后终极解法(二进制解法)。第 51 题，第 52 题。
*   数独问题。第 37 题。
*   四个方向搜索。第 79 题，第 212 题，第 980 题。
*   子集合问题。第 78 题，第 90 题。
*   Trie。第 208 题，第 211 题。
*   BFS 优化。第 126 题，第 127 题。
*   DFS 模板。(只是一个例子，不对应任何题)

```Go
func combinationSum2(candidates []int, target int) [][]int {
    if len(candidates) == 0 {
        return [][]int{}
    }
    c, res := []int{}, [][]int{}
    sort.Ints(candidates)
    findcombinationSum2(candidates, target, 0, c, &res)
    return res
}

func findcombinationSum2(nums []int, target, index int, c []int, res *[][]int) {
    if target == 0 {
        b := make([]int, len(c))
        copy(b, c)
        *res = append(*res, b)
        return
    }
    for i := index; i < len(nums); i++ {
        if i > index && nums[i] == nums[i-1] { // 这里是去重的关键逻辑
            continue
        }
        if target >= nums[i] {
            c = append(c, nums[i])
            findcombinationSum2(nums, target-nums[i], i+1, c, res)
            c = c[:len(c)-1]
        }
    }
}
```
*   BFS 模板。(只是一个例子，不对应任何题)
```Go
func updateMatrix_BFS(matrix [][]int) [][]int {
    res := make([][]int, len(matrix))
    if len(matrix) == 0 || len(matrix[0]) == 0 {
        return res
    }
    queue := make([][]int, 0)
    for i, _ := range matrix {
        res[i] = make([]int, len(matrix[0]))
        for j, _ := range res[i] {
            if matrix[i][j] == 0 {
                res[i][j] = -1
                queue = append(queue, []int{i, j})
            }
        }
    }
    level := 1
    for len(queue) > 0 {
        size := len(queue)
        for size > 0 {
            size -= 1
            node := queue[0]
            queue = queue[1:]
            i, j := node[0], node[1]
            for _, direction := range [][]int{{-1, 0}, {1, 0}, {0, 1}, {0, -1}} {
                x := i + direction[0]
                y := j + direction[1]
                if x < 0 || x >= len(matrix) || y < 0 || y >= len(matrix[0]) || res[x][y] < 0 || res[x][y] > 0 {
                    continue
                }
                res[x][y] = level
                queue = append(queue, []int{x, y})
            }
        }
        level++
    }
    for i, row := range res {
        for j, cell := range row {
            if cell == -1 {
                res[i][j] = 0
            }
        }
    }
    return res
}
```

No.|Title|Solution|Difficulty|TimeComplexity|SpaceComplexity|Favorite|Acceptance
|:-:|:-|:-|:-|:-|:-|:-|:-|
|0017|Letter Combinations of a Phone Number|[Go](https://books.halfrost.com/leetcode/ChapterFour/0001~0099/0017.Letter-Combinations-of-a-Phone-Number/)|Medium|O(log n)|O(1)|55.5%
|0022|Generate Parentheses|[Go](https://books.halfrost.com/leetcode/ChapterFour/0001~0099/0022.Generate-Parentheses/)|Medium|O(log n)|O(1)|71.8%
|0037|Sudoku Solver|[Go](https://books.halfrost.com/leetcode/ChapterFour/0001~0099/0037.Sudoku-Solver/)|Hard|O(n^2)|O(n^2)|❤️|56.6%
|0039|Combination Sum|[Go](https://books.halfrost.com/leetcode/ChapterFour/0001~0099/0039.Combination-Sum/)|Medium|O(n log n)|O(n)|67.6%
|0040|Combination Sum II|[Go](https://books.halfrost.com/leetcode/ChapterFour/0001~0099/0040.Combination-Sum-II/)|Medium|O(n log n)|O(n)|53.3%
|0046|Permutations|[Go](https://books.halfrost.com/leetcode/ChapterFour/0001~0099/0046.Permutations/)|Medium|O(n)|O(n)|❤️|74.7%
|0047|Permutations II|[Go](https://books.halfrost.com/leetcode/ChapterFour/0001~0099/0047.Permutations-II/)|Medium|O(n^2)|O(n)|❤️|56.7%
|0051|N-Queens|[Go](https://books.halfrost.com/leetcode/ChapterFour/0001~0099/0051.N-Queens/)|Hard|O(n!)|O(n)|❤️|62.9%
|0052|N-Queens II|[Go](https://books.halfrost.com/leetcode/ChapterFour/0001~0099/0052.N-Queens-II/)|Hard|O(n!)|O(n)|❤️|70.9%
|0077|Combinations|[Go](https://books.halfrost.com/leetcode/ChapterFour/0001~0099/0077.Combinations/)|Medium|O(n)|O(n)|❤️|66.0%
|0078|Subsets|[Go](https://books.halfrost.com/leetcode/ChapterFour/0001~0099/0078.Subsets/)|Medium|O(n^2)|O(n)|❤️|73.8%
|0079|Word Search|[Go](https://books.halfrost.com/leetcode/ChapterFour/0001~0099/0079.Word-Search/)|Medium|O(n^2)|O(n^2)|❤️|39.8%
|0089|Gray Code|[Go](https://books.halfrost.com/leetcode/ChapterFour/0001~0099/0089.Gray-Code/)|Medium|O(n)|O(1)|56.4%
|0090|Subsets II|[Go](https://books.halfrost.com/leetcode/ChapterFour/0001~0099/0090.Subsets-II/)|Medium|O(n^2)|O(n)|❤️|55.2%
|0093|Restore IP Addresses|[Go](https://books.halfrost.com/leetcode/ChapterFour/0001~0099/0093.Restore-IP-Addresses/)|Medium|O(n)|O(n)|❤️|43.4%
|0095|Unique Binary Search Trees II|[Go](https://books.halfrost.com/leetcode/ChapterFour/0001~0099/0095.Unique-Binary-Search-Trees-II/)|Medium|51.5%
|0113|Path Sum II|[Go](https://books.halfrost.com/leetcode/ChapterFour/0100~0199/0113.Path-Sum-II/)|Medium|56.6%
|0126|Word Ladder II|[Go](https://books.halfrost.com/leetcode/ChapterFour/0100~0199/0126.Word-Ladder-II/)|Hard|O(n)|O(n^2)|❤️|27.6%
|0131|Palindrome Partitioning|[Go](https://books.halfrost.com/leetcode/ChapterFour/0100~0199/0131.Palindrome-Partitioning/)|Medium|O(n)|O(n^2)|❤️|62.3%
|0212|Word Search II|[Go](https://books.halfrost.com/leetcode/ChapterFour/0200~0299/0212.Word-Search-II/)|Hard|O(n^2)|O(n^2)|❤️|36.9%
|0216|Combination Sum III|[Go](https://books.halfrost.com/leetcode/ChapterFour/0200~0299/0216.Combination-Sum-III/)|Medium|O(n)|O(1)|❤️|67.0%
|0257|Binary Tree Paths|[Go](https://books.halfrost.com/leetcode/ChapterFour/0200~0299/0257.Binary-Tree-Paths/)|Easy|60.5%
|0301|Remove Invalid Parentheses|[Go](https://books.halfrost.com/leetcode/ChapterFour/0300~0399/0301.Remove-Invalid-Parentheses/)|Hard|47.1%
|0306|Additive Number|[Go](https://books.halfrost.com/leetcode/ChapterFour/0300~0399/0306.Additive-Number/)|Medium|O(n^2)|O(1)|❤️|30.9%
|0357|Count Numbers with Unique Digits|[Go](https://books.halfrost.com/leetcode/ChapterFour/0300~0399/0357.Count-Numbers-with-Unique-Digits/)|Medium|O(1)|O(1)|51.5%
|0401|Binary Watch|[Go](https://books.halfrost.com/leetcode/ChapterFour/0400~0499/0401.Binary-Watch/)|Easy|O(1)|O(1)|51.5%
|0473|Matchsticks to Square|[Go](https://books.halfrost.com/leetcode/ChapterFour/0400~0499/0473.Matchsticks-to-Square/)|Medium|40.4%
|0491|Increasing Subsequences|[Go](https://books.halfrost.com/leetcode/ChapterFour/0400~0499/0491.Increasing-Subsequences/)|Medium|52.0%
|0494|Target Sum|[Go](https://books.halfrost.com/leetcode/ChapterFour/0400~0499/0494.Target-Sum/)|Medium|45.6%
|0526|Beautiful Arrangement|[Go](https://books.halfrost.com/leetcode/ChapterFour/0500~0599/0526.Beautiful-Arrangement/)|Medium|O(n^2)|O(1)|❤️|64.6%
|0638|Shopping Offers|[Go](https://books.halfrost.com/leetcode/ChapterFour/0600~0699/0638.Shopping-Offers/)|Medium|54.2%
|0784|Letter Case Permutation|[Go](https://books.halfrost.com/leetcode/ChapterFour/0700~0799/0784.Letter-Case-Permutation/)|Medium|O(n)|O(n)|73.4%
|0816|Ambiguous Coordinates|[Go](https://books.halfrost.com/leetcode/ChapterFour/0800~0899/0816.Ambiguous-Coordinates/)|Medium|56.1%
|0842|Split Array into Fibonacci Sequence|[Go](https://books.halfrost.com/leetcode/ChapterFour/0800~0899/0842.Split-Array-into-Fibonacci-Sequence/)|Medium|O(n^2)|O(1)|❤️|38.2%
|0980|Unique Paths III|[Go](https://books.halfrost.com/leetcode/ChapterFour/0900~0999/0980.Unique-Paths-III/)|Hard|O(n log n)|O(n)|79.6%
|0996|Number of Squareful Arrays|[Go](https://books.halfrost.com/leetcode/ChapterFour/0900~0999/0996.Number-of-Squareful-Arrays/)|Hard|O(n log n)|O(n)|49.3%
|1079|Letter Tile Possibilities|[Go](https://books.halfrost.com/leetcode/ChapterFour/1000~1099/1079.Letter-Tile-Possibilities/)|Medium|O(n^2)|O(1)|❤️|76.1%
|1239|Maximum Length of a Concatenated String with Unique Characters|[Go](https://books.halfrost.com/leetcode/ChapterFour/1200~1299/1239.Maximum-Length-of-a-Concatenated-String-with-Unique-Characters/)|Medium|52.2%
|1655|Distribute Repeating Integers|[Go](https://books.halfrost.com/leetcode/ChapterFour/1600~1699/1655.Distribute-Repeating-Integers/)|Hard|39.6%
