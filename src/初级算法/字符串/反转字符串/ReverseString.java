
/**
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
 *
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode.cn/leetbook/read/top-interview-questions-easy/xnhbqj/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class ReverseString {
    public static void main(String[] args) {
        char[] chars = new char[]{'H','E','L','L','O','X'};
        ReverseString reverseString = new ReverseString();
//        reverseString.reverseString2(chars);
        reverseString.reverseString3(chars);

        System.out.println("echo = " +  5/2);
    }

    /**
     *  使用新数组
     *  倒叙遍历数组，放到一个新的数组中，并再次赋值
     * @param s
     */
    public void reverseString(char[] s) {
        char[] newChars = new char[s.length];

        for (int i = s.length - 1; i >= 0; i--) {
            newChars[s.length-1-i] = s[i];
        }

        for (int i = 0; i < newChars.length; i++) {
            s[i] = newChars[i];
        }
    }


    /**
     * 二分交换
     * @param s
     */
    public void reverseString2(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            int newIndex = s.length-1-i;
            s[i] = (char) (s[i] ^ s[newIndex]);
            s[newIndex] = (char) (s[i] ^ s[newIndex]);
            s[i] = (char) (s[i] ^ s[newIndex]);
        }
    }


    /**
     * 双指针
     * @param s
     */
    public void reverseString3(char[] s) {
        int left = 0;
        int right = s.length - 1;

        while ( left != right && left<right){

            //交换
            s[left] = (char) (s[right] ^ s[left]);
            s[right] = (char) (s[right] ^ s[left]);
            s[left] = (char) (s[right] ^ s[left]);

            left++;
            right--;
        }
    }



}
