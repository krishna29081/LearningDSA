package DailyQuestionsLeetCode;

import java.util.HashMap;
import java.util.Map;

public class BitwiseXOR_2425 {
    public static void main(String[] args) {
        int[] nums1 = {2,1,3};
        int[] nums2 = {10,2,5,0};
        int res = findXOR(nums1,nums2);
        System.out.println("res = " + res);
    }


    private static int findXOR(int[] nums1, int[] nums2) {
        int m = nums1.length    ;
        int n = nums2.length    ;
        Map<Integer,Integer> mp = new HashMap<>();

        for (int num : nums1 ){
            mp.put(num, mp.getOrDefault(num,0) + n );
        }
        for (int num : nums2 ){
            mp.put(num, mp.getOrDefault(num,0) + m );
        }

        int res = 0;
        for (int num : mp.keySet()){
            if(mp.get(num) % 2 != 0) {
                res ^= num;
            }
        }

        return res;
    }
}
