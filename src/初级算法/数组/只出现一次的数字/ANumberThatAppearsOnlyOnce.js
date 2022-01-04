/* 
    只出现一次的数字

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
*/


/* 
    离散数学的异或运算性质

    1.交换律：a ^ b ^ c  <=> a ^ c ^ b

    2.任何数于0异或为任何数 0 ^ n => n

    3.相同的数异或为0: n ^ n => 0

    即 4 ^ 1 ^ 2 ^ 1 ^ 2 = 1 ^ 1 ^ 2 ^ 2 ^ 4 = 0 ^ 0 ^ 4 = 0 ^ 4 = 4
 */
const testArr = [4, 1, 2, 1, 2];
const singleNumber = (nums) => {
    return nums.reduce((a, b) => a ^ b)
};

console.log(singleNumber(testArr));