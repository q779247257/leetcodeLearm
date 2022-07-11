## 字符串中的第一个唯一字符
给定一个字符串 s ，找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1 。

 

示例 ：

输入: s = "leetcode"
输出: 0
示例 2:

输入: s = "loveleetcode"
输出: 2
示例 3:

输入: s = "aabb"
输出: -1

作者：力扣 (LeetCode)
链接：https://leetcode.cn/leetbook/read/top-interview-questions-easy/xn5z8r/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

[代码示例（Java）](./FirstUniqueCharacterinString.java)



### 方法1 使用哈希表

​	我们使用哈希表来标记它的次数

  

```java
    public int firstUniqChar(String s) {

        int length = s.length();
        if (length == 1){
            return 0;
        }
        HashMap<Character, Integer> sMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            sMap.put(s.charAt(i),sMap.getOrDefault(s.charAt(i),0)+1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (sMap.get(s.charAt(i)) == 1) {
                return sMap.get(s.charAt(i));
            }
        }

        return -1;
    }

```

