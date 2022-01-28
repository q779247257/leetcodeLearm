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
        int[] intersect2 = intersectionOfTwoArrays.intersectTwo(new int[]{4, 9, 5, 4, 4}, new int[]{9, 4, 9, 8, 4, 6});
        System.out.println(Arrays.toString(intersect2));
    }

    private int[] intersect(int[] nums1, int[] nums2) {

        //调整参数顺序，使用长度短的作为哈希表标记
        if (nums1.length > nums2.length){
            return intersect(nums2,nums1);
        }

        //存储次数标记
        Map<Integer, Integer> countMap = new HashMap<Integer, Integer> ();
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


    private int[] intersectTwo(int[] nums1 , int[] nums2){

        //先排序
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int point1 = 0;//指针1
        int point2 = 0;//指针2

        List<Integer> resultList = new ArrayList<Integer>(16);


        while (point1 < nums1.length && point2 < nums2.length){
            if (nums1[point1] > nums2[point2]){
                //point2 是小指针，point2往后移动+1
                point2++;
            }else if (nums2[point2] > nums1[point1]){
                //point1 是小指针，往后移动+1
                point1++;
            }else {
                //2个指针值相同，添加到列表中，并且2个指针都+1
                resultList.add(nums1[point1]);
                point1++;
                point2++;
            }
        }

        int[] reslutArray = new int[resultList.size()];

        for (int i = 0; i < resultList.size(); i++) {
            reslutArray[i] = resultList.get(i);
        }
        return reslutArray;
    }
}
