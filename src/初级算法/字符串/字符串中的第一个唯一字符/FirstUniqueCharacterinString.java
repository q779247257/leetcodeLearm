
import java.util.HashMap;
import java.util.HashSet;

public class FirstUniqueCharacterinString {



    public static void main(String[] args) {
        System.out.println(new FirstUniqueCharacterinString().firstUniqChar("leetcode"));
    }

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
                return i;
            }
        }

        return -1;
    }

    /**
     * 错误的
     * @param s
     * @return
     */
    public int firstUniqChar2(String s) {

        int length = s.length();
        if (length == 1){
            return 0;
        }
        HashSet<Character> characters = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char charAt = s.charAt(i);
            int oldSize = characters.size();
            characters.add(charAt);
            int newSize = characters.size();
            if (oldSize == newSize){
                return i > 2 ? i-2 : -1;
            }
        }

        return -1;
    }
}
