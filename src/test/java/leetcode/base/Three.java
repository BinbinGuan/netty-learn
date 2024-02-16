package leetcode.base;

import java.util.*;

public class Three {
//
//    public Integer[] intersect(int[] nums1, int[] nums2){
//        Set<Integer> data=new HashSet();
//        for(int i=0;i<nums1.length;i++){
//            data.add(nums1[i]);
//        }
//        List<Integer> result=new ArrayList<>();
//
//        for(int i=0;i<nums2.length;i++){
//            if(data.contains(nums2[i])){
//                result.add(nums2[i]);
//            }
//        }
//
//       return result.toArray(new Integer[result.size()]);
//
//
//    }

    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums1) {
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
        }
        int[] intersection = new int[nums1.length];
        int index = 0;
        for (int num : nums2) {
            int count = map.getOrDefault(num, 0);
            if (count > 0) {
                intersection[index++] = num;
                count--;
                if (count > 0) {
                    map.put(num, count);
                } else {
                    map.remove(num);
                }
            }
        }
        return Arrays.copyOfRange(intersection, 0, index);
    }

}
