## 移动零

移动零
给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

示例:

输入: [0,1,0,3,12]
输出: [1,3,12,0,0]
说明:

必须在原数组上操作，不能拷贝额外的数组。
尽量减少操作次数。

作者：力扣 (LeetCode)
链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2ba4i/

### 1，把非0的往前挪

把非0的移动到前边，再把0放在后边即可，这是一个比较简单的思路

![image.png](https://pic.leetcode-cn.com/1643270315-cBXrft-image.png)

```java
public void moveZeroes(int[] nums) {

        //非0标记，放置一次 加1
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0){
                nums[index++] = nums[i];
            }
        }

        //非0填充
        for (int i = nums.length - 1; i >= index; i--) {
            nums[i] = 0;
        }
    }
```

### 2、双指针

第一个指针 index ，一直往后移动+1，**如果指不等于0的时候，才对它进行操作（与 指针i 进行交换）。**

第二个指针 i ，**index进行操作之后，+1**

**相当于我们有2个指针，一个指针会遍历它一次，另一个指针在交换的时候会 +1 ，这样我们会把非0的全部排在前边，而0我们已经全部挤到了末尾。**

```java
public void moveZeroes2(int[] nums) {
        int i = 0;
        for (int index = 0; index < nums.length; index++) {
            //不等于0 与i指针交换后 i指针+1
            if (nums[index] != 0){
                int num = nums[index];
                nums[index] = nums[i];
                nums[i] = num;
                i++;
            }
        }

    }
```



```text
[0, 1, 0, 3, 12] index = 0    i = 0    不交换
[0, 1, 0, 3, 12] index = 1    i = 0    交换  i+1
[1, 0, 0, 3, 12] index = 2    i = 1    不交换
[1, 0, 0, 3, 12] index = 3    i = 1    交换  i+1
[1, 3, 0, 0, 12] index = 4    i = 2    交换  i+1
[1, 3, 12, 0, 0]   结束
```

与之相同的是，我们可以延申出来一个倒叙的解法



