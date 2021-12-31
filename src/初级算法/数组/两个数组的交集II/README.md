## 两个数组的交集II

给你两个整数数组 nums1 和 nums2 ，请你以数组形式返回两数组的交集。

返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致（如果出现次数不一致，则考虑取较小值）。

可以不考虑输出结果的顺序。



示例 1：

输入：nums1 = [1,2,2,1], nums2 = [2,2]
输出：[2,2]
示例 2:

输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
输出：[4,9]

作者：力扣 (LeetCode)

链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2y0c2/



[代码示例](./IntersectionOfTwoArrays.java)

------

### 解法1 利用哈希

​	由于一个数字在一个列表中可能会出现多次，**因此我们需要一个 哈希表存储每一个元素出现的次数**。

​	对于一个元素，它在交集中出现的次数等于它在2个列表中出现的最小次数。

​	首先我们遍历第一个数组，并在 **哈希表中存下每个元素出现的次数，**

然后遍历第二个列表，对于第二个数组中的每个元素，如果 **在哈希表中存在这个元素，那么我们将元素添加到返回的列表中，并且现在在哈希表中减少元素的次数。**

<img src = "https://assets.leetcode-cn.com/solution-static/350/350_fig1.gif"></img>

​	**为了降低空间复杂度，我们可以将长度短的列表作为哈希表的**，然后便利长的列表获取我们要的结果。

```java
    private int[] intersect(int[] nums1, int[] nums2) {

        //调整参数顺序，使用长度短的作为哈希表标记
        if (nums1.length > nums2.length){
            return intersect(nums2,nums1);
        }

        //存储次数标记
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int anInt : nums1) {
            Integer orDefault = countMap.getOrDefault(anInt, 0)+1;
            countMap.put(anInt,orDefault);
        }

        List<Integer> arrayList = new ArrayList<Integer>(nums1.length);
        for (int num : nums2) {
            Integer integer = countMap.get(num);

            //有元素，添加返回结果 并减少次数
            if (integer != null && !integer.equals(0)){
                arrayList.add(num);
                if (--integer > 0){
                    countMap.put(num,integer);
                }else {
                    countMap.remove(num);
                }
            }
        }

        //list转数组
        int[] ints = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            ints[i] = arrayList.get(i);
        }

        return ints;
    }

```

