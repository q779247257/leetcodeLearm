/* 
    两个数组的交集II

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
*/

// 哈希表
// 记录第一个数组里面每个元素出现的次数，然后遍历第二个元素，如果出现与第一个数组里面相同的数字且记录该数字的次数大于0，那么就将该数字的次数减一，并记录这个数字

let nums1 = [0, 1, 2, 2, 3, 5, 5, 8, 58]
let nums2 = [1, 2, 2, 3, 5]

const intersectOne = (nums1, nums2) => {
    let result = []
    let map = new Map()
    nums1.forEach(item => {
        if (map.has(item)) {
            map.set(item, map.get(item) + 1)
        } else {
            map.set(item, 1)
        }
    })
    nums2.forEach(item => {
        if (map.has(item) && map.get(item) > 0) {
            map.set(item, map.get(item) - 1)
            result.push(item)
        }
    })
    return result
};

console.log(intersectOne(nums1, nums2));

// 双指针
// 先将两个数组分别排序，然后依次从头遍历，如果两个指针指到的数字相同就记录这个数字
const intersectTwo = (nums1, nums2) => {
    let result = []
    let i = j = 0
    nums1.sort((a, b) => a - b)
    nums2.sort((a, b) => a - b)

    while (i < nums1.length && j < nums2.length) {
        if (nums1[i] === nums2[j]) {
            result.push(nums1[i])
            i++
            j++
        } else {
            //较小的元素的指针往前走
            nums1[i] < nums2[j] ? i++ : j++
        }
    }

    return result
};

console.log(intersectTwo(nums1, nums2));