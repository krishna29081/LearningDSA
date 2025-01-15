package Sorting;


import static java.util.Collections.swap;

public class QuickSortAlgo {
    public static void main(String[] args) {
        int[] arr = {5,2,6,1,4};
        quickSort(arr,0,arr.length-1);
        for(int i : arr){
            System.out.print(" " + i);
        }
    }
    static void quickSort(int[] arr, int start, int end){
        if(start < end){
            int pivIndx = partition(arr,start,end);
            quickSort(arr,start,pivIndx-1);  // for left side of array
            quickSort(arr,pivIndx,end); // for right side of array
        }
    }

    private static int partition(int[] arr, int start, int end) {
        int idx = start-1, pivot = arr[end];
        for (int i = start; i < end; i++) {
                if(arr[i] <= pivot) {
                    swap(arr,i,++idx);
                }
        }
        idx++;
        swap(arr,end,idx);
        return idx;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
