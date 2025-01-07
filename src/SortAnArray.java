import java.util.stream.IntStream;

public class SortAnArray {
    public static void main(String[] args) {
        System.out.println("Hello");
        int[] a  = {5,2,1,3};
//        for (int i = 0; i < a.length; i++) {
//            System.out.println(a[i]);
//        }
        bubbleSort(a,a.length);
        for (int i = 0; i <a.length ; i++) {
            System.out.println(a[i]);

        }
    }

    private static void bubbleSort(int[] a, int length) {
        int n = length;
        IntStream.iterate(n - 1, i -> i >= 0, i -> i - 1).forEach(i -> IntStream.rangeClosed(i, (i - 1)).filter(j -> a[j] > a[j + 1]).forEach(j -> {
            int temp = a[j + 1];
            a[j+1] = a[j];
            a[j] = temp;
        }));

    }

    private static void arraySort(int[] a) {

    }}
