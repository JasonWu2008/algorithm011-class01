## 第四周总结
#### NO.860:[柠檬水找零问题](https://github.com/JasonWu2008/algorithm011-class01/tree/master/Week_04/src)
* 贪心算法实现找零，找零时先看大额面值能否满足，如果可以大额够的话再拼小的，如果大额面值不够的话再看小额的是否满足
* 由于本题只有固定三个面值所以直接设置两个5，10面额变量用于计数，如果枚举值多的话需要维护一个队列查找前一个较小面值
#### NO.153:[查找旋转排序列表中的最小值](https://github.com/JasonWu2008/algorithm011-class01/tree/master/Week_04/src)
* 此题解题思路还是二分查找，结束条件是要么夹逼后只剩2个元素，取其中较小的，要么是mid比前一个元素小且比后一个元素也小
* 二分比较时，重点是要判断最小节点分布在mid的左边还是右边，如果(mid>left && left>right)，最左边元素比最优元素大的话一定分布在右边
#### NO.200:[计算岛屿的数量](https://github.com/JasonWu2008/algorithm011-class01/tree/master/Week_04/src)
#### dfs 实现
* ********** 移动的"驱动力"
* 网格移动的"驱动"是通过i*j次的循环完成的，虽然每次的dfs可能会标记很多"已访问"的节点，
* 但前进的路径依然会逐行扫，路径数目不会少，只不过不会进入dfs
* ********** 如何"回溯"？
* 如果在"区域内"且该点的为"岛屿"则继续下探，
* 下探是根据四个方向"顺时针"找，即"右->下->左->上"的顺序,（实际顺序无所谓，但这个顺序比较符合人的习惯）
* 下探时会优先找右边的元素，如果右边元素碰到边界或者不是岛屿则会按上述顺序再继续找
* 这里的"回溯"是通过递归自动完成的，因为每个节点本来需要走四步，最内层走完后，会一层一层回到最外层直到到达最初i,j的位置
#### bfs 实现
* 广度优先搜索通过双端队列的"出队"和"入队"操作