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

链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x21ib6/

[代码示例](./ANumberThatAppearsOnlyOnce.Java)

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



### 解法2：巧用 位运算

​	首先我们来 ^(异或)的三个性质

 A ^ A = 0 异或自己等于0

A ^ 0 = A  异或0无变化

A ^ B ^ A =  A ^ A ^ B  满足交换律和结合律

那么 **假设在一个集合中 有 2M的重复元素和一个不重复元素，**

**那么我不论对 2M的数字以怎样的顺序进行异或运算，它的最终结果都是0**。

而 0 ^ **一个不重复的元素 还是等于自己**.

 这样我们只需要把 所以的元素进行异或运算即可得到我们想要的值。

```Java
    /** 异或运算 */
    public int singleNumberTwp(int nums[]) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

```

