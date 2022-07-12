
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ValidAnagrams {

    public static void main(String[] args) {
        System.out.println(new ValidAnagrams().isAnagram("ab","a"));
    }

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


    public boolean isAnagram2(String s, String t){
        char[] chars = s.toCharArray();
        char[] chars1 = t.toCharArray();
        Arrays.sort(chars);
        Arrays.sort(chars1);
        return Arrays.equals(chars,chars1);
    }
}
