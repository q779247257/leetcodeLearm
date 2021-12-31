import java.lang.reflect.Array;
import java.util.*;

/**
 * IntersectionOfTwoArrays：
 *
 * @author: xuanxuan
 * @date: 2021/12/31 15:14
 */
public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        IntersectionOfTwoArrays intersectionOfTwoArrays = new IntersectionOfTwoArrays();
        int[] intersect = intersectionOfTwoArrays.intersect(new int[]{4, 9, 5, 4, 4}, new int[]{9, 4, 9, 8, 4, 6});
        System.out.println(Arrays.toString(intersect));
    }

    private int[] intersect(int[] nums1, int[] nums2) {

        //调整参数顺序，使用长度短的作为哈希表标记
        if (nums1.length > nums2.length){
            return intersect(nums2,nums1);
        }

        //存储次数标记
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int anInt : nums1) {
            Integer orDefault = countMap.getOrDefault(anInt, 0)+1;
            countMap.put(anInt,orDefault);
        }

        List<Integer> arrayList = new ArrayList<Integer>(nums1.length);
        for (int num : nums2) {
            Integer integer = countMap.get(num);

            //有元素，添加返回结果 并减少次数
            if (integer != null && !integer.equals(0)){
                arrayList.add(num);
                if (--integer > 0){
                    countMap.put(num,integer);
                }else {
                    countMap.remove(num);
                }
            }
        }

        //list转数组
        int[] ints = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            ints[i] = arrayList.get(i);
        }

        return ints;
    }


}
