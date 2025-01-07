package BinarySearch;

public class findElemInRotatedSotArray {
    public static void main(String[] args) {
        int[] arr = {12,15,18,2,5,6,8,11};
        int elem = 11;
        int minIndex = findMinIndex(arr, 0, arr.length-1);
        int bs = BS(arr, 0, minIndex - 1, elem);
        int bs1 = BS(arr, minIndex, arr.length - 1, elem);
        if(bs ==-1 ) System.out.println("bs1 = " + bs1);
        else System.out.println("bs = " + bs);
        System.out.println("minIndex = " + minIndex);
    }

    private static int BS(int[] arr, int start, int end, int elem) {
        if(start<=end){
            int mid = start+(end-start)/2;
            if(arr[mid]== elem) {
                return mid;
            }
            if(arr[mid]<elem){
                return BS(arr,mid+1,end,elem); 
            }
            return BS(arr,start,mid-1,elem);
        }
        return -1;
    }


    private static int findMinIndex(int[] arr, int start, int end) {
        if(start<=end){
            int mid = start +(end-start)/2;
            if(arr[(mid+1)%arr.length] >= arr[mid] && arr[(mid+arr.length-1) % arr.length] >= arr[mid]){
                return mid;
            }
            if(arr[start]<=arr[mid]){
                return findMinIndex(arr,mid+1,end);
            }
            if(arr[end]>=arr[mid]){
                return findMinIndex(arr,start,mid-1);
            }
        }
        return -1;
    }
}
