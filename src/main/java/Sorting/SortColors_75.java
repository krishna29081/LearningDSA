package Sorting;
public class SortColors_75 {
    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
//        sortColor(nums);
        sortColor2(nums);
        for (int i : nums){
            System.out.println("i = " + i);
        }
    }

    private static void sortColor2(int[] nums) {
        quickSortPractice(nums,0,nums.length-1);
    }

    private static void quickSortPractice(int[] nums, int start, int end) {
        if(start < end){
            int pivIndex = partition(nums,start,end);
            quickSortPractice(nums,start,pivIndex-1);
            quickSortPractice(nums,pivIndex,end);
        }
    }

    private static int partition(int[] nums, int start, int end) {
        int idx = start-1 ,pivot = nums[end];
        for (int i = start; i < end; i++) {
            if(nums[i] <= pivot){
                swap(nums,i,++idx);
            }
        }
        idx++;
        swap(nums,end,idx);
        return idx;
    }
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void sortColor(int[] nums) {
        int len = nums.length;
        int count0 = 0, count1 = 0;
        int count2 = 0;
        for(int i : nums){
            if(i == 0){
                count0++;
            }
            if(i == 1){
                count1++;
            }
            if(i== 2){
                count2++;
            }
        }
        int i =0;
        while(count0 > 0 && i < len){
            nums[i] = 0;
            count0--;
            i++;
        }
        while (count1 > 0 && i < len){
            nums[i] = 1;
            count1--;
            i++;
        }
        while (count2 > 0 && i < len){
            nums[i] = 2;
            count2--;
            i++;
        }
    }


}
