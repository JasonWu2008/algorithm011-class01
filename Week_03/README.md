## 第三周总结
#### NO.22:[产生括号](https://github.com/JasonWu2008/algorithm011-class01/tree/master/Week_03/src)
* 此题思路类似爬楼梯，核心判断有3条：
   1. 加左括号时，如果是否超过N个；
   1. 加右括号时，如果是否超过N个；
   1. 以及一种异常情况，右括号个数必须小于左括号，否则多出的右括号就不能与左边成对
* 此处不应该使用current=current + "("，应该保证传入参数current不可变
* 同理也不一能使用left++，否则right<n内的left被修改了          
#### No.236:[求最近公共父节点](https://github.com/JasonWu2008/algorithm011-class01/tree/master/Week_03/src)
* 本质上是看pq是否在本节点(避免与树顶元素混淆)的左边和右边，如果是，本节点就是"最短公共祖先"
* 如果pq分散在本节点的两侧，那本节点一定是"最短公共祖先"
* 否则pq一定集中在一侧，此时递归下探查找
* 下探的过程实际上就是树的深度优先遍历(DFS)
#### NO.105:[根据二叉树的前序和中序构建一棵树](https://github.com/JasonWu2008/algorithm011-class01/tree/master/Week_03/src)
* 看左边能不能放，如果能，递归下探，如果不能放，则尝试放在右边；
* 放右边之前，先看右边有没有放过，如果没有放过则直接放，递归下探
* 如果已经放了，则向上回溯看根元素右边是否能放，递归下探