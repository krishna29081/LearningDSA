public class findPeakElement{
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        int res = findPeak(nums,0,nums.length-1);
    }

    private static int findPeak(int[] nums, int start, int end) {
        if(start<=end) {
            int mid = start + (end - start) / 2;
            if(mid==start) {
                if(nums[mid]>nums[mid+1]){
                    return nums[mid];
                }
            } else if (mid==end) {
                if(nums[mid]>nums[mid-1]){
                    return nums[mid];
                }
            }else{
                if (nums[mid]>nums[mid-1] && nums[mid]> nums[mid+1]){
                    return nums[mid];
                }

            }
        }
        return 0;
    }
}