/* 
    存在重复元素

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
 */

const testArr = [1, 1, 1, 3, 3, 4, 3, 2, 4, 2]
const containsDuplicateOne = (nums) => {
    for (let i = 0; i < nums.length; i++) {
        for (let j = i + 1; j < nums.length; j++) {
            if (nums[i] === nums[j]) {
                return true
            }
        }
    }
    return false
}

console.log(containsDuplicateOne(testArr));

const containsDuplicateTwo = (nums) => {
    let setArr = new Set();
    nums.forEach(item => {
        setArr.add(item)
    });
    return nums.length > setArr.size
}

console.log(containsDuplicateTwo(testArr));

const containsDuplicateThree = (nums) => {
    let arr = nums.sort()
    for(let i = 0; i < arr.length - 1; i++) {
        if(arr[i] === arr[i + 1]) {
            return true
        }
    }
    return false
}

console.log(containsDuplicateThree(testArr));