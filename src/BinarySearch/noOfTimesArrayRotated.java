package BinarySearch;

public class noOfTimesArrayRotated {
    public static void main(String[] args) {
        int[] arr = {11,12,15,18,2,5,6,8};
        int indexOfMinEle = findIndexOfMinEle(arr, 0, arr.length - 1);
        System.out.println(STR."indexOfMinEle = \{arr[indexOfMinEle]}");
    }

    private static int findIndexOfMinEle(int[] arr, int start, int end) {
        if(start<=end){
            int mid = start +(end-start)/2;
            if(arr[(mid+1)%arr.length] >= arr[mid] && arr[(mid+arr.length-1) % arr.length] >= arr[mid]){
                return mid;
            }
            if(arr[start]<=arr[mid]){
                return findIndexOfMinEle(arr,mid+1,end);
            }
            if(arr[end]>=arr[mid]){
                return findIndexOfMinEle(arr,start,mid-1);
            }
        }
        return -1;
    }
}
