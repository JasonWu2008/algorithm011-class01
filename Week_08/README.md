## 第八周总结
#### NO.56:[合并区间](https://github.com/JasonWu2008/algorithm011-class01/tree/master/Week_08/src)
* 对角线"/"形对比法,dp方程："intervals[i][1] >= intervals[i + 1][0]"才合并，否则原样拆分

#### NO.146:[LRU缓存](https://github.com/JasonWu2008/algorithm011-class01/tree/master/Week_08/src)
* LRU HashMap + Deque

#### 选择排序:[选择排序](https://github.com/JasonWu2008/algorithm011-class01/tree/master/Week_08/src)
* 十大经典排序：选择排序
* 每次选择集合剩余元素最小/大插入到已排序集合最后一个元素

#### 归并排序:[归并排序](https://github.com/JasonWu2008/algorithm011-class01/tree/master/Week_08/src)
* 十大经典排序：归并排序
* 每次从中间劈开集合，从内向外'剥洋葱'似对比两边数组相同索引位置的值，小的先放大的后放到临时数组
* 对比时可能会出现两端数组不对称情况，如此处理时先对相同长度部分，对于左边或右边较长部分，直接放临时数组
* 将临时数组放回到原数组