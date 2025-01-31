package String.medium;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class findKthBit_1545 {
    public static void main(String[] args) {
        System.out.println(findkBit2(4,11));
    }

    private static char findkBit(int n, int k) {
        String s = "0";

        int i = 1;
        while(i<=n-1){
            StringBuilder sb = new StringBuilder();
            s = s + "1" + sb.append(Arrays.asList(s.split("")).stream().map(ch -> ch = (ch.endsWith("0")) ? "1" : "0").collect(Collectors.joining())).reverse().toString();
            i++;
        }
        return s.charAt(k-1);
    }
    private static char findkBit2(int n, int k){
        if (n == 1) return '0';

        int length = (1 << n) - 1;

        int mid = length / 2 + 1;

        if (k == mid) return '1';

        if (k < mid) return findkBit2(n - 1, k);

        return findkBit2(n - 1, length - k + 1) == '0' ? '1' : '0';
    }

}
