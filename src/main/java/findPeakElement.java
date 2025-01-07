public class findPeakElement{
    public static void main(String[] args) {
        int[] nums = {1,2};
        int res = findPeak(nums,0,nums.length-1);
        int res1 = findPeakElement2(nums);
        System.out.println("res = " + res1);
    }

    private static int findPeak(int[] nums, int start, int end) {
        if(start<=end) {
            int mid = start + (end - start) / 2;
            System.out.println("mid = " + mid);
            if(mid==start) {
                if(nums[mid]>nums[mid+1]){
                    return mid;
                }
            } else if (mid==end) {
                if(nums[mid]>nums[mid-1]){
                    return mid;
                }
            }else{
                if (nums[mid]>nums[mid-1] && nums[mid]> nums[mid+1]){
                    return mid;
                }
                if(nums[mid] <= nums[mid+1]){
                    return findPeak(nums,mid+1,end);
                }
                return findPeak(nums,start,mid-1);
            }
        }
        return -1;
    }

    public static int findPeakElement2(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[mid + 1]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}