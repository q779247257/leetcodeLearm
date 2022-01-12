/* 
    加一
    给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。

    最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。

    你可以假设除了整数 0 之外，这个整数不会以零开头。

    

    示例 1：

    输入：digits = [1,2,3]
    输出：[1,2,4]
    解释：输入数组表示数字 123。
    示例 2：

    输入：digits = [4,3,2,1]
    输出：[4,3,2,2]
    解释：输入数组表示数字 4321。
    示例 3：

    输入：digits = [0]
    输出：[1]


    提示：

    1 <= digits.length <= 100
    0 <= digits[i] <= 9

    作者：力扣 (LeetCode)
    链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2cv1c/
*/

/* 
    运用数学知识
        如果末尾数不为9的话直接加一 [1, 2, 3] +1 ==> [1, 2, 4]
        如果末尾数为9的话，相当于进一位，即加一之后末尾数为0，倒数第二位加一，如果倒数第二位也为9的话就在进位，直到前一位不为9（即到不具备在进位的条件）
        如果每位上的数字都为9的话，那么现有的位数全部置为0，在头部加一位数为1
*/
const digitsArr1 = [9, 9];

const plusOne1 = (digits) => {
    for (let i = digits.length - 1; i >= 0; i--) {
        if (digits[i] != 9) {
            digits[i] += 1
            return digits
        } else {
            digits[i] = 0
        }
    }

    let newDigits = Array(digits.length + 1).fill(0)
    newDigits[0] = 1
    return newDigits
}

console.log(plusOne1(digitsArr1));

/* 
    转换为数字进行计算
        需要注意的是：js有位数限制，转换成数字的时候需要用bigInt（防止超出限制）
        使用split的时候是转为字符串数组，需要在转换一次成为数字数组
*/

const digitsArr2 = [6, 1, 4, 5, 3, 9, 0, 1, 9, 5, 1, 8, 6, 7, 0, 5, 5, 4, 3]
const plusOne2 = (digits) => {
    let big = BigInt(digits.join(''))
    return (big + 1n).toString().split('').map(item => parseInt(item))
}

console.log(plusOne2(digitsArr2));