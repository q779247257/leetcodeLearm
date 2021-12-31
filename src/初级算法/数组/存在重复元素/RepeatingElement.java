import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * SaveMethodOne： 重复元素解法
 * 输入: [1,2,3,1]
 * 输出: true
 * 示例 2:
 *
 * 输入: [1,2,3,4]
 * 输出: false
 * 示例 3:
 *
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 *
 * 作者：力扣 (LeetCode)
 *
 * @author: xuanxuan
 * @date: 2021/12/31 10:11
 */
public class RepeatingElement {
    public static void main(String[] args) {

    }


    /**
     * 解法01 暴力
     */
    public boolean containsDuplicateOne(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] == nums[j]){
                    return true;
                }
            }
        }
        return false;
    }


    /**
     * 解法02 使用set
     */
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


    public boolean containsDuplicateThree(int[] nums) {
        Set<Integer> set = new HashSet<Integer>(nums.length);
        for (int num : nums) {
            set.add(num);
        }
        return set.size() < nums.length;
    }

    /**
     * 解法3 巧用排序
     */
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



}
