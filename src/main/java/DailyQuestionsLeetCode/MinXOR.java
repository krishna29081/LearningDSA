package DailyQuestionsLeetCode;

public class MinXOR {
    public static void main(String[] args) {
        int res = minXor(1,12);
        System.out.println("res = " + res);
    }

    private static int minXor(int num1, int num2) {
        int a = Integer.bitCount(num1);
        int b = Integer.bitCount(num2);

        int x = num1;

        // if num1 has fewer set bits, increase right most ones
        while(a < b) {
            x = x | (x + 1); // toggles right most 0 to 1
            a += 1;
        }

        // if num1 has more set bits, reduce right most ones
        while(a > b){
            x = x & (x - 1);    // toggles right most 1 to 0
            a -= 1;
        }

        return x;
    }
}
