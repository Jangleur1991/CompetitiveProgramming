package techniques.twoPointer;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be
 * unique and you may return the result in any order.
 */
public class IntersectionTwoArrays {
    public static void main(String[] args) {
        int[] nums11 = new int[]{1,2,2,1};
        int[] nums21 = new int[]{2,2};

        int[] nums12 = new int[]{4,9,5};
        int[] nums22 = new int[]{9,4,9,8,4};

        int[] nums13 = new int[]{1};
        int[] nums23 = new int[]{1};

        System.out.println(Arrays.toString(intersection(nums11, nums21))); // 2
        System.out.println(Arrays.toString(intersection(nums12, nums22))); // 4 9
        System.out.println(Arrays.toString(intersection(nums13, nums23))); // 1

    }

//    private static int[] intersection(int[] nums1, int[] nums2) {
//        Arrays.sort(nums1);
//        Arrays.sort(nums2);
//        int i = 0;
//        int j = 0;
//        List<Integer> result = new ArrayList<>();
//        while (i < nums1.length && j < nums2.length) {
//            if (nums1[i] < nums2[j])
//                i++;
//            else if (nums2[j] < nums1[i])
//                j++;
//            else {
//                if (result.isEmpty() || result.get(result.size()-1) != nums1[i]) {
//                    result.add(nums1[i]);
//                }
//                i++;
//                j++;
//            }
//        }
//        return result.stream().mapToInt(Integer::intValue).toArray();
//    }

//    private static int[] intersection(int[] nums1, int[] nums2) {
//        Set<Integer> nums1Set = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
//        return Arrays.stream(nums2).filter(nums1Set::contains)
//                .distinct()
//                .toArray();
//    }

    private static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> nums1Set = new HashSet<>();
        for (int num: nums1) {
            nums1Set.add(num);
        }
        List<Integer> resultList = new ArrayList<>();
        for (int num: nums2) {
            if (nums1Set.remove(num))
                resultList.add(num);
        }

        int[] result = new int[resultList.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }


}
