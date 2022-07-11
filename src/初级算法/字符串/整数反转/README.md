## 整数反转

给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。

如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。

假设环境不允许存储 64 位整数（有符号或无符号）。


示例 1：

输入：x = 123
输出：321

作者：力扣 (LeetCode)
链接：https://leetcode.cn/leetbook/read/top-interview-questions-easy/xnx13t/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

[整数反转](./IntegerInversion.java)



 我们可以使用  **% 运算符**，来依次**算出个位的数字**，并循环 ***10** 来获得一个反转后的字符串。

```Java
    public int reverse2(int number) {
        int resultNumber = 0;
        while (number != 0){
            //判断数据溢出
            if ( resultNumber >  Integer.MAX_VALUE /10 || (long)resultNumber < Integer.MIN_VALUE /10) return 0;
            //取得最后一位数
            int add =  number % 10;
            //每次循环乘10 加上最后一位数
            resultNumber = resultNumber * 10 + add;
            //参数减少一位数
            number /= 10;
            //判断数据是否溢出
        }
        return resultNumber;
    }

```

  

```java
    public int reverse(int x) {
        int sum = 0;

        while ( x != 0){
            if (sum < Integer.MIN_VALUE / 10 || sum > Integer.MAX_VALUE / 10) {
                return 0;
            }
            sum *=10;
            int result =  x % 10;
            x = (x - result)/10;
            sum += result;
        }
        return sum;
    }

```

