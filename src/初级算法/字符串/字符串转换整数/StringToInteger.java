
public class StringToInteger {

    public static void main(String[] args) {
        StringToInteger stringToInteger = new StringToInteger();
        System.out.println(stringToInteger.myAtoi("  -42"));
    }


    public int myAtoi(String s) {
        StringBuilder builder = new StringBuilder();

        boolean  negativeNumber = false;
        //过滤数组
        for (int i = 0; i < s.length(); i++) {

            //丢弃无用的前导空格
            if (' ' == s.charAt(i)){
                continue;
            }

            //检查字符（假设还未到字符末尾）为正还是负号， 确定最终结果是负数还是正数。
            if (!negativeNumber && s.charAt(i) == '-' && i < s.length()-1 && Character.isDigit(s.charAt(i+1))){
                negativeNumber = true;
            }
//            读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。


        }

        return result;
    }
}
