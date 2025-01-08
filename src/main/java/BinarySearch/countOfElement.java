package BinarySearch;


public class countOfElement {
    public static void main(String[] args) {
        int[] arr = {1,2,5,5,5,6,7,7,9,10};
        int element = 7;
//        int firstIndex = binarySearch(arr,0,arr.length-1,element);
        int SecondIndex = binarySearch2(arr,0,arr.length-1,element);
        System.out.println(SecondIndex);
      }

    private static int binarySearch2(int[] arr, int start, int end, int element) {
        int endIndex=-1,startIndex=-1;
        startIndex = firstOccurance(arr,start,end,element,startIndex);
        endIndex = lastOccurance(arr,start,end,element,endIndex);
        System.out.println("startIndex = " + startIndex);
        System.out.println("endIndex = " + endIndex);
        return (endIndex-startIndex)+1;
    }

//    private static int binarySearch(int[] arr, int start, int end, int element) {
//        if(start<end) {
//            int mid = start + (end- start) / 2;
//
//            if (arr[mid] == element) {
//                int startIndex = findLeftOccurance(arr,start,mid-1,element);
//                int endIndex = findRightOccurance(arr,mid+1,end,element);
//                System.out.println("endIndex = " + endIndex);
//                System.out.println("startIndex = " + startIndex);
//                return (endIndex-startIndex)+1;
//            }
//            if (arr[mid] > element) {
//                return binarySearch(arr, start, mid-1, element);
//            }
//            return binarySearch(arr,mid+1,end,element);
//        }
//        return -1;
//    }

    private static int lastOccurance(int[] arr, int start, int end, int element,int res) {
        if(start<=end) {
            int mid = start + (end-start)/2;
            System.out.println("mid = " + mid);
        if(arr[mid]== element) {
            res = mid;
            System.out.println("res = " + res);
            return lastOccurance(arr,mid+1,end,element,res);
        }
        if(arr[mid]>element){
            return lastOccurance(arr,start,mid-1,element,res);
        }

        return lastOccurance(arr,mid+1,end,element,res);
        }
        return res;
    }

    private static int firstOccurance(int[] arr, int start, int end, int element, int res) {
        if(start<=end) {
        int mid = start + (end-start)/2;
        if(arr[mid]==element){
            res = mid;
//            System.out.println("mid = " + mid);
            return firstOccurance(arr,start,mid-1,element,res);
        }
        if(arr[mid]>element){
            return firstOccurance(arr,start,mid-1,element,res);
        }
        return firstOccurance(arr,mid+1,end,element,res);
        }
        return res;
    }
}
