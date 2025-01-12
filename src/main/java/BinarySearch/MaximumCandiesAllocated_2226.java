package BinarySearch;

import java.util.Arrays;

public class MaximumCandiesAllocated_2226 {
    public static void main(String[] args) {
        int[] candies = {5,8,6};
        long k = 3;
        long res = findMax(candies,k);
        System.out.println("res = " + res);
    }

    private static long findMax(int[] candies, long k) {
        int max = 0;
        for(int i : candies){
            max = Math.max(i,max);
        }
        int len = candies.length;
        long l =0, r = max;
        while(l<r){
            long mid = l +(r-l)/2;
            if(isMax(mid,k,candies)){
                l = mid+1;
            }else {
                r = mid;
            }
        }
        return  isMax(l,k,candies) ? l : l-1;
    }

    private static boolean isMax(long mid, long k,int[] candies) {
        if (mid==0){return true;}
        long childrenCount =0;
        for(int i : candies){
            childrenCount += i/mid;
            if(childrenCount>=k){return true;}
        }
        return false;
    }
}
