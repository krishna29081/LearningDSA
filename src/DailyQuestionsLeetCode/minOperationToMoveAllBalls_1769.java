package DailyQuestionsLeetCode;

public class minOperationToMoveAllBalls_1769 {
    public static void main(String[] args) {
        String s = "001011";
        int[] res = minOperations(s);
//        for (int i = 0; i < res.length; i++) {
//            System.out.print("res = "+ res[i]);
//        }
    }

    private static int[] minOperations(String s) {
       int cumSum=0, cumVal=0, len = s.toCharArray().length;
       int[] res = new int[len];
        for (int i = 0; i < len ; i++) {
            res[i] = cumSum;
//            System.out.print(" res = " + res[i]);
//            System.out.println();
            cumVal += s.charAt(i) == '0' ? 0 : 1;
            System.out.print(" cumVal = " + cumVal);
            cumSum += cumVal;
            System.out.println("cumSum = " + cumSum);
        }
        for (int i = 0; i < len; i++) {
            System.out.print(" res[i] = " + res[i]);
        }
        System.out.println();
        cumVal=0;
        cumSum=0;
        System.out.println();
        for (int i = len-1; i >=0 ; i--) {
            res[i] += cumSum;
            System.out.print(" res = " + res[i]);
            cumVal += s.charAt(i) == '0' ? 0 : 1;

            cumSum += cumVal;

        }

        return  res;
    }
}
