package BinarySearch;

import java.util.Arrays;

public class FrequencyOfMostElement_1838 {
    public static void main(String[] args) {
        int[] nums = {1,4,8,13};
        int k = 5;
        int res = findFrequency(nums,k);
        System.out.println("res = " + res);
    }

    private static int findFrequency(int[] nums, int k) {
            int l = 0, r =0,sum=0,windowLength=0,maxFreq =0;
            int len = nums.length-1;
            Arrays.sort(nums);
            while(r<=len){
                System.out.println(" r = " + r + " l = " + l);
                sum += nums[r];
                System.out.println(" sum = " + sum);
                while ((((r-1+1) * nums[r]) - sum) >= k){
                    sum -= nums[l];
                    l++;
                }
                maxFreq = Math.max(maxFreq,windowLength);
                r++;
            }
        return maxFreq;
    }
}
