package BinarySearch;

import java.util.Arrays;
import java.util.HashMap;

import static java.util.Arrays.binarySearch;

public class findRightInterval_436 {
    public static void main(String[] args) {
        int[][] intervals ={{3,4},{2,3},{1,2}};
        int[] res = findInterval(intervals);
    }

    private static int[] findInterval(int[][] intervals) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int[] first = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            hm.put(intervals[i][0],i);
            first[i] = intervals[i][0];
        }
        Arrays.sort(first);
        int[] ans = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            int key = binarysearch(first,intervals[i][1]);
            if(key == first.length){
                ans[i]=-1;
            } else if (key == 0) {
                if(intervals[i][1]<= first[0])
                    ans[i] = hm.get(first[0]);
                else
                    ans[i] = -1;
            }  else{
                ans[i] = hm.get(first[key]);
            }
        }
        return ans;
    }

    private static int binarysearch(int[] arr, int target) {
            int s= 0;
            int e = arr.length-1;
            while(s<=e){
                int mid = s + (e-s)/2;
                if(arr[mid]<target)
                    s = mid+1;
                else
                    e = mid-1;
            }
            return s;
    }


}
