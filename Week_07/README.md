## 第七周总结
#### NO.208:[Trie树的构造](https://github.com/JasonWu2008/algorithm011-class01/tree/master/Week_07/src)
* Trie树的三个函数：insert, search, startsWith

#### NO.200:[岛屿数量并查集解法](https://github.com/JasonWu2008/algorithm011-class01/tree/master/Week_07/src)
* 并查集解法:find,union

#### NO.547:[朋友圈的数量](https://github.com/JasonWu2008/algorithm011-class01/tree/master/Week_07/src)
* 本地与岛屿问题基本思路一样，唯一不同就是4连通变8连通，实际四连通可以简化为2连通，即右下，8连通即"右"，"下"，"右对角线"
* 平衡性处理：将小数接到大树,以避免头重脚轻
* 路径压缩：parent[x] = parent[parent[x]];
* 并查集精华题解：[朋友圈的数量](https://leetcode-cn.com/problems/friend-circles/solution/union-find-suan-fa-xiang-jie-by-labuladong/)