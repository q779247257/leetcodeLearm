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



[代码示例(Java)](./IntersectionOfTwoArrays.java)
[代码示例(Js)](./IntersectionOfTwoArrays.js)

------

### 解法1 利用哈希

​	由于一个数字在一个列表中可能会出现多次，**因此我们需要一个 哈希表存储每一个元素出现的次数**。

​	对于一个元素，它在交集中出现的次数等于它在2个列表中出现的最小次数。

​	首先我们遍历第一个数组，并在 **哈希表中存下每个元素出现的次数，**

然后遍历第二个列表，对于第二个数组中的每个元素，如果 **在哈希表中存在这个元素，那么我们将元素添加到返回的列表中，并且现在在哈希表中减少元素的次数。**

​	**为了降低空间复杂度，我们可以将长度短的列表作为哈希表的**，然后便利长的列表获取我们要的结果。

![demo](./image/350_fig1.gif)



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

### 解法2 利用排序

​	先对2个数组进行排序，然后使用2个指针，分别指向2个数组的开始位置；



如果2个指针指向的值 **相同**，说明这个值是交集，就把这个值加入到集合中，并且把2个指针分别 **往后移动一步**。

如果2个指针不同，那么我们把指针值比较比的指针 **往后移动一步** ，大的指针不动，然后继续比较。



我们一直重复上面的操作，直到其中一个指针不能再移动；



```java
    private int[] intersectTwo(int[] nums1 , int[] nums2){

        //先排序
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int point1 = 0;//指针1
        int point2 = 0;//指针2

        List<Integer> resultList = new ArrayList<>(16);


        while (point1 < nums1.length && point2 < nums2.length){
            if (nums1[point1] > nums2[point2]){
                //point2 是小指针，point2往后移动+1
                point2++;
            }else if (nums2[point2] > nums1[point1]){
                //point1 是小指针，往后移动+1
                point1++;
            }else {
                //2个指针值相同，添加到列表中，并且2个指针都+1
                resultList.add(nums1[point1]);
                point1++;
                point2++;
            }
        }

        int[] reslutArray = new int[resultList.size()];

        for (int i = 0; i < resultList.size(); i++) {
            reslutArray[i] = resultList.get(i);
        }
        return reslutArray;
    }
```

