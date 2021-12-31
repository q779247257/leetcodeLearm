import java.util.HashSet;
import java.util.Set;

/**
 * ANumberThatAppearsOnlyOnce：
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 *
 * 输入: [4,1,2,1,2]
 * 输出: 4
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x21ib6/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @author: xuanxuan
 * @date: 2021/12/31 11:22
 */
public class ANumberThatAppearsOnlyOnce {

    /**
     * 使用set
     */
    public int singleNumberOne(int nums[]) {
        Set<Integer> set = new HashSet<Integer>(nums.length);
        for (int num : nums) {
            if (!set.add(num)) {
                //添加失败，set中已经有num，我们把num本身也删除
                set.remove(num);
            }
        }
        return (Integer) set.toArray()[0];
    }

    /** 异或运算 */
    public int singleNumberTwp(int nums[]) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }
}
