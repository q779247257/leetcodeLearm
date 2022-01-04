import java.util.Arrays;

/**
 *
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2cv1c/
 *
 *
 * 示例 1：
 *
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 * 示例 2：
 *
 * 输入：digits = [4,3,2,1]
 * 输出：[4,3,2,2]
 * 解释：输入数组表示数字 4321。
 * 示例 3：
 *
 * 输入：digits = [0]
 * 输出：[1]
 * @author: xuanxuan
 * @date: 2022/1/4 13:54
 */
public class PlusOne {

    public static void main(String[] args) {
        PlusOne plusOne = new PlusOne();
        int[] ints = plusOne.plusOne(new int[]{1, 2, 3});
        System.out.println(Arrays.toString(ints));
    }


    public int[] plusOne(int[] digits) {
        for (int i = digits.length-1; i >=0; i--) {
            if (digits[i] != 9){
                digits[i]+=1;
                return digits;
            }
            digits[i]=0;
        }

        //代码走到这里，代表数组种全是9，那么我们创建一个新的数组 索引0 位置填充为1
        int[] ints = new int[digits.length + 1];
        ints[0]=1;
        return ints;
    }
}
