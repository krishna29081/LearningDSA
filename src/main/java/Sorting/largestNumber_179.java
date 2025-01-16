package Sorting;

import java.util.Arrays;
import java.util.stream.Collectors;

public class largestNumber_179 {
    public static void main(String[] args) {
        int[] arr = {3, 30, 34, 5, 9};
        System.out.println(largestNumber(arr));
    }

    private static String largestNumber(int[] arr) {
        String res = Arrays.stream(arr)
                .mapToObj(String :: valueOf)
                .sorted((a,b) -> (b+a).compareTo(a+b))
                .collect(Collectors.joining(""));

        return res.startsWith("00") ? "0" : res;
    }
}

