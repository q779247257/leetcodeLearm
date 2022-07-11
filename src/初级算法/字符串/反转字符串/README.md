## 翻转字符串
编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。

不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。

 

示例 ：

输入：s = ["h","e","l","l","o"]
输出：["o","l","l","e","h"]
示例 2：

输入：s = ["H","a","n","n","a","h"]
输出：["h","a","n","n","a","H"]

作者：力扣 (LeetCode)
链接：https://leetcode.cn/leetbook/read/top-interview-questions-easy/xnhbqj/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。



[示例代码（Java）](./ReverseString.java)

### 方法1 使用新的数组

​	我们可以使用一个新的数组，倒叙遍历旧数组，新旧数组时间相互赋值，达到反转的母的，当然，这样的方法不支持题目中的 **使用 O(1) 的额外空间解决这一问题**，但是这也是最容易想到的办法。



![image.png](https://pic.leetcode-cn.com/1657509511-ctCNFf-image.png)

  



 

```Java
    public void reverseString(char[] s) {
        char[] newChars = new char[s.length];

        for (int i = s.length - 1; i >= 0; i--) {
            newChars[s.length-1-i] = s[i];
        }

        for (int i = 0; i < newChars.length; i++) {
            s[i] = newChars[i];
        }
    }
```



### 方法2 半分交换

​	当然，我们也可以利用半分来实现数组的交换，而不使用额外的空间。

![image.png](https://pic.leetcode-cn.com/1657509712-QYMMHR-image.png)

```java
    public void reverseString(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            int newIndex = s.length-1-i;
            s[i] = (char) (s[i] ^ s[newIndex]);
            s[newIndex] = (char) (s[i] ^ s[newIndex]);
            s[i] = (char) (s[i] ^ s[newIndex]);
        }
    }
```



### 方法3 双指针

​	我们定义  left 和 right 2个指针,**左指针依次+1，右指针依次-1**，在2个指针碰撞之前，我们依次交换2个指针所指向的值。

![image.png](https://pic.leetcode-cn.com/1657518796-nnVPnc-image.png)

  

```Java
    public void reverseString(char[] s) {
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
```

