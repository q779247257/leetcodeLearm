
public class ValidatePalindromeString {
    public static void main(String[] args) {
        ValidatePalindromeString palindromeString = new ValidatePalindromeString();
        boolean palindrome = palindromeString.isPalindrome("race a car");
        System.out.println(palindrome);
    }



    public boolean isPalindrome(String s) {
        StringBuilder sequence = new StringBuilder();
        StringBuilder reverse = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char charAt = s.charAt(i);
            boolean letterOrDigit = Character.isLetterOrDigit(charAt);
            if (letterOrDigit){
                sequence.append(charAt);
                reverse.insert(0,charAt);
            }
        }
        return sequence.toString().equalsIgnoreCase(reverse.toString());
    }


    public boolean isPalindrome2(String s) {
        StringBuilder sequence = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char charAt = s.charAt(i);
            boolean letterOrDigit = Character.isLetterOrDigit(charAt);
            if (letterOrDigit){
                sequence.append(charAt);
            }
        }
        return sequence.toString().equalsIgnoreCase(sequence.reverse().toString());
    }


    /**
     * 双指针
     */
    public boolean isPalindrome3(String s){
        int left = 0 , right = s.length()-1;

        while (left < right){
            char charAtLeft = s.charAt(left);
            //左边指针找到下一个合格的字符
            if (!Character.isLetterOrDigit(charAtLeft)){
                left++;
                continue;
            }

            //右边指针找到下一个合格的字符
            char charAtRight = s.charAt(right);
            if (!Character.isLetterOrDigit(charAtRight)){
                right--;
                continue;
            }

            //若字符不相同，直接返回 false
            if ( Character.toLowerCase(charAtLeft) != Character.toLowerCase(charAtRight)){
                return false;
            }

            //指针靠近
            left++;
            right--;
        }
        return true;
    }
}
