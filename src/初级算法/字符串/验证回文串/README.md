## 验证回文串

给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。

说明：本题中，我们将空字符串定义为有效的回文串。

 

示例 1:

输入: "A man, a plan, a canal: Panama"
输出: true
解释："amanaplanacanalpanama" 是回文串
示例 2:

输入: "race a car"
输出: false
解释："raceacar" 不是回文串


提示：

1 <= s.length <= 2 * 105
字符串 s 由 ASCII 字符组成



作者：力扣 (LeetCode)
链接：https://leetcode.cn/leetbook/read/top-interview-questions-easy/xne8id/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。



### 方法1 排除+反转

​	我们首先排除掉不合规的字符，然后我们将字符串和反转字符串进行比较；

​	   

```java
    public boolean isPalindrome(String s) {
        StringBuilder sequence = new StringBuilder();

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
```

```java
    public boolean isPalindrome(String s) {
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
```



### 方法2 双指针

​		在移动任意一个指针时，需要不断地向另一指针的方向移动，直到遇到一个字母或数字字符，或者两指针重合为止。也就是说，我们每次将指针移到下一个字母字符或数字字符，再判断这两个指针指向的字符是否相同。

 ![image.png](https://pic.leetcode-cn.com/1657679324-WkIQwr-image.png)

```java
    /**
     * 双指针
     */
    public boolean isPalindrome(String s){
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

```

[整数反转](./ValidatePalindromeString.java)