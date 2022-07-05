## 两数之和

给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。

你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。

你可以按任意顺序返回答案。

 

示例 1：

输入：nums = [2,7,11,15], target = 9
输出：[0,1]
解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
示例 2：

输入：nums = [3,2,4], target = 6
输出：[1,2]
示例 3：

输入：nums = [3,3], target = 6
输出：[0,1]

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/two-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。



### 方法1 暴力破解

首先，我们最先想到的就是暴力破解，双层for循环。

![image.png](https://pic.leetcode-cn.com/1656991807-AxXGwd-image.png)

 

   

```Java
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i]+nums[j] == target){
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
```

### 方法2 巧用哈希表

思路

方法一的复杂度是比较高的，因此我们需要一个更优秀的办法，能够快速找到元素，我们可以使用 Map 来映射索引，如果存在则取出它的索引。

![image.png](https://pic.leetcode-cn.com/1657000189-YgCzlX-image.png)

  

```java
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i,map.get(target-nums[i])};
            }
            map.put(nums[i],i);
        }
        return null;
    }
```

