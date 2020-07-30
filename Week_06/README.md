## 第六周总结
#### NO.64:[求最小路径和](https://github.com/JasonWu2008/algorithm011-class01/tree/master/Week_06/src)
* 二维数组方式求解
* 状态转移方程,通过求min淘汰交大的网格：newGrid[i][j] = Math.min(newGrid[i - 1][j], newGrid[i][j - 1]) + grid[i][j];