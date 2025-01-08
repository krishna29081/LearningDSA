import java.util.Arrays;

public class ChalkGame {
    public static void main(String[] args) {
        int[] a = {3,4,1,2};
        int k = 8;
        System.out.println(chalReplacer(a,k));
    }

    static int chalReplacer(int[] a, int k) {

        long sum = Arrays.stream(a).sum();
        System.out.println("sum = " + sum);
        long modulus = k % sum;
        int i =0;
        while(modulus > a[i]) {
            modulus = modulus - a[i];
            i++;
        }

        return i;
    }
}
