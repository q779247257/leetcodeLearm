## 有效的字母异位词

给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。

注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。

 

示例 1:

输入: s = "anagram", t = "nagaram"
输出: true
示例 2:

输入: s = "rat", t = "car"
输出: false

作者：力扣 (LeetCode)
链接：https://leetcode.cn/leetbook/read/top-interview-questions-easy/xn96us/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


[整数反转](./ValidAnagrams.java)



### 方法1 哈希表

​	我们可以利用 MAP 来解这个题，**我们可以把短的字符串放入到MAP中，Key是自己，Value是字符串中中间的次数，而长的字符串去map中找自己每个字符出现的次数**

​	

```Java
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        String shortString = s;
        String longString = t;

        if(s.length() > t.length()){
            shortString = t;
            longString = s;
        }

        //第一遍存储到map中
        for (int i = 0; i < shortString.length(); i++) {
            char charAt = shortString.charAt(i);
            Integer orDefault = map.getOrDefault(charAt, 0);
            map.put(charAt,orDefault+1);
        }
        for (int i = 0; i < longString.length(); i++) {
            char charAt = longString.charAt(i);
            Integer count = map.get(charAt);
            if (count == null) {
                //如果没有，那么直接返回flase，不是异位词
                return false;
            }
            //如果次数为0，那么直接返回false，不是异位词
            if (count == 0 ){
                return false;
            }
            map.put(charAt,--count);
        }

        return true;

    }

```

### 方法2 排序

​	当然，我们也可以对字符进行排序，**排序后，进行比较**是否一样即可。

```java
    public boolean isAnagram(String s, String t) {
        char[] chars = s.toCharArray();
        char[] chars1 = t.toCharArray();
        Arrays.sort(chars);
        Arrays.sort(chars1);
        return Arrays.equals(chars,chars1);
    }
```

