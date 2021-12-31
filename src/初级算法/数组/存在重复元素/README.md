### 存在重复元素

给定一个整数数组，判断是否存在重复元素。

如果存在一值在数组中出现至少两次，函数返回 `true` 。如果数组中每个元素都不相同，则返回 `false` 。

示例 1:

输入: [1,2,3,1]
输出: true
示例 2:

输入: [1,2,3,4]
输出: false
示例 3:

输入: [1,1,1,3,3,4,3,2,4,2]
输出: true

作者：力扣 (LeetCode)
链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x248f5/

------



### 解法1：暴力

**首先，我们最容易想到的就是暴力，但是效率比较低。**

```java
public boolean containsDuplicateOne(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
        for (int j = i+1; j < nums.length; j++) {
            if (nums[i] == nums[j]){
                return true;
            }
        }
    }
    return false;
```



### 解法2：巧用set

**使用set去重的特性，我们可以判断出是否有重复。**

**set在添加失败，返回 false 的时候，代表集合内已经有重复元素。**

```Java
public boolean containsDuplicateTwo(int[] nums) {
    Set<Integer> set = new HashSet<Integer>(nums.length);
    for (int num : nums) {
        //add return false 集合中有num元素，我们直接认定为重复
        if (!set.add(num)) {
            return true;
        }
    }
    return false;
}
```

**当然，我们也可以利用 set 的长度变化进行判断是否有重复元素。**

**只是效率不如上面的解法。**

```java
    public boolean containsDuplicateThree(int[] nums) {
        Set<Integer> set = new HashSet<Integer>(nums.length);
        for (int num : nums) {
            set.add(num);
        }
        return set.size() < nums.length;
    }
```



### 解法3：巧用排序

**我们可以先对数组进行排序，在排序之后，我们依次进行与相邻元素进行比较。**

```Java
    public boolean containsDuplicateFour(int[] nums) {

        //先排序
        Arrays.sort(nums);

        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] == nums[i+1]){
                return true;
            }
        }

        return false;
    }

```

