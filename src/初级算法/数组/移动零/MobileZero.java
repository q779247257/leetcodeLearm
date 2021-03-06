import java.util.Arrays;

/**
 * MobileZero：
 *
 * @author: xuanxuan
 * @date: 2022/1/4 14:30
 */
public class MobileZero {
    public static void main(String[] args) {
        MobileZero mobileZero = new MobileZero();
        int[] ints = new int[]{0,1,0,3,12};
//        mobileZero.moveZeroes2(ints);
        mobileZero.moveZeroes3(ints);
        System.out.println(Arrays.toString(ints));
    }

    /**
     * 倒叙，（不能保证元素顺序，无法通过）
     */
    public void moveZeroes3(int[] nums) {
        int exchangeIndex = nums.length-1;

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == 0){
                if (nums[i] == 0){
                    int num = nums[exchangeIndex];
                    nums[exchangeIndex] = nums[i];
                    nums[i] = num;
                    exchangeIndex--;
                }
            }

        }
    }

    /** 双指针的解法 */
    public void moveZeroes2(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0){
                int num = nums[index];
                nums[index] = nums[i];
                nums[i] = num;
                index++;
            }
        }
    }

    public void moveZeroes(int[] nums) {

        //非0标记，放置一次 加1
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0){
                nums[index++] = nums[i];
            }
        }

        //非0填充
        for (int i = nums.length - 1; i >= index; i--) {
            nums[i] = 0;
        }
    }

}
