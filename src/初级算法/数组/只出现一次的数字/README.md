### 只出现一次的数字

给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。

说明：

你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？

示例 1:

输入: [2,2,1]
输出: 1
示例 2:

输入: [4,1,2,1,2]
输出: 4

作者：力扣 (LeetCode)
链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x21ib6/

[代码示例](./ANumberThatAppearsOnlyOnce)

------



### 解法1：使用 set

**这个是最容易想到的解法，我们利用set去重的特性，我们一个一个的把元素添加到set中。**

**如果添加失败，那么代表这个元素不止出现了以下，并且，我们从set中把这个元素删除。**

**到最后，我们的set中只会剩下一个元素，它就是我们要找的只出现一次的元素。**

```Java
	public int singleNumberOne(int nums[]) {
        Set<Integer> set = new HashSet<Integer>(nums.length);
        for (int num : nums) {
            if (!set.add(num)) {
                //添加失败，set中已经有num，我们把num本身也删除
                set.remove(num);
            }
        }
        return (Integer) set.toArray()[0];
    }
```



