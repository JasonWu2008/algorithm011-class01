# 训练营总结

本课程的最大收获：
## 1、算法的学习方法

* 坦白讲，从递归开始，课后作业LeetCode“中等”难度题目，不看题解很难在1小时正确完成提交，有的题目基本只有一个模糊的思路，写起来bug很多，当然也经历过“死磕”。按照超哥的说法，这是学算法应该避免的，很多算法并非常人在如此短的时间内能发明创造，常人只需“模仿”+“熟练应用”，短时间内没有思路并成功AC是正常的，这不是什么丢人的事，重点是要掌握正确的方法。
* 好的学习方法是：
独立思考 --> 看题解，理解思路 --> 自己默写 --> 过遍数，也就是“五毒神掌”，行业术语称之“可以训练”。
遍数胜于单次时长
遍数多了，理解更深，自然也就熟练了，写业务代码也更得心应手。
## 2、递归的理解更深一层
* 递归、回溯、分治、动态规划本质上没有太大区别，只是处理上的一些细微的区别
###  泛型递归模板
* 递归的状态缓存
### 回溯
* 回溯试错，回归上一层
* 用于解决数独和八皇后问题
### 分治模板
* 拆分子问题
* 合并结果集（与泛型递归的区别）

## 3、动态规划
DP分类
### DP基础
* 递推型DP (爬楼梯，斐波那契数)
* 计数型DP (不同路径系列)
* 线性DP (三⻆形最小路径和，最大子序列和，乘积最大子数组，最⻓上升子序列，最⻓公共子序列，股票 问题，打家劫舍问题)
### DP进阶 •背包DP (背包九讲)
* 区间DP 编辑距离 
* 树形DP
### DP高阶
* •状态压缩DP •数位DP •概率型DP •博弈型DP
* •记忆化搜索