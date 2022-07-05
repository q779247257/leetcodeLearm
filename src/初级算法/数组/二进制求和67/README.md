#### 二进制求和

给你两个二进制字符串，返回它们的和（用二进制表示）。

输入为 **非空** 字符串且只包含数字 `1` 和 `0`。



示例 1:

输入: a = "11", b = "1"
输出: "100"
示例 2:

输入: a = "1010", b = "1011"
输出: "10101"

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/add-binary
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。



### 方法1 进制转换

最简单的办法 **转为十进制后运算，再转为2进制**，但是缺点就是容易抛出 NumberFormatException

```Java
    /**
     * 方法1
     * 转为十进制后运算，再转为2进制
     */
    public String addBinary(String a, String b) {
        return Integer.toBinaryString(Integer.parseInt(a, 2) + Integer.parseInt(b, 2));
    }
```

### 方法2

​	先将2个字符串的长度进行补0，使2个字符串的长度一致，然后我们使用遍历进行计算结果。

我们使用变量 **grandTotal** 来累计上一个字符的余量，来判断是否进0.

   ![image.png](https://pic.leetcode-cn.com/1656926047-QoflLn-image.png)

```java
public static String addBinary2(String a, String b) {
        int lengthA = a.length();
        int lengthB = b.length();
        int finalLength = a.length();

        //使字符串长度一致
        if ( lengthA > lengthB){
            StringBuilder fill0Str = new StringBuilder(b);
            for (int i = 0; i < lengthA - lengthB; i++) {
                fill0Str.insert(0,0);
            }
            b = fill0Str.toString();
            finalLength = lengthA;
        }else if (lengthA<lengthB){
            StringBuilder fill0Str = new StringBuilder(a);
            for (int i = 0; i < lengthB - lengthA  ; i++) {
                fill0Str.insert(0,0);
            }
            a = fill0Str.toString();
            finalLength = lengthB;
        }

        StringBuilder builder = new StringBuilder();

        //累计上一位的数字
        int grandTotal = 0;
        for (int length = finalLength-1; length >= 0; length--) {
            int sum = grandTotal;
            sum += a.charAt(length) - '0';
            sum += b.charAt(length) - '0';
            builder.append(sum%2);
            grandTotal = sum >= 2 ? 1:0;//是否累计到下一
        }

        //是否再补1
        if (grandTotal == 1) {
            builder.append(1);
        }


        return builder.reverse().toString();
    }
```

### 示例代码

[代码示例(Java)](./Solution67.java)