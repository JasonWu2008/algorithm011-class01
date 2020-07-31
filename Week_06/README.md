## 第六周总结
#### NO.64:[求最小路径和](https://github.com/JasonWu2008/algorithm011-class01/tree/master/Week_06/src)
* 二维数组方式求解
* 状态转移方程,通过求min淘汰交大的网格：newGrid[i][j] = Math.min(newGrid[i - 1][j], newGrid[i][j - 1]) + grid[i][j];
#### NO.647:[求回文子串数](https://github.com/JasonWu2008/algorithm011-class01/tree/master/Week_06/src)
* 状态转移方程:s.charAt(i) == s.charAt(j) && (i - j < 2 || grids[j + 1][i - 1])
* (i - j < 2 || grids[j + 1][i - 1])；i - j < 2表示重合或相邻;grids[j + 1][i - 1]右与左
### 练习
#### NO.62:[求棋盘不同路径](https://github.com/JasonWu2008/algorithm011-class01/tree/master/Week_06/src/practise)
* 二维数组DP解法
* DP方程:dp[i][j]=dp[i-1][j] + dp[i][j-1]; "上左"之和
*
* 一维数组DP解法
* DP方程:dp[i]=dp[i] + dp[i-1]; 当前位置与左边之和
#### [斐波那契数列](https://github.com/JasonWu2008/algorithm011-class01/tree/master/Week_06/src/practise)
* 暴力法
* 递归法
* 动态规划淘汰法