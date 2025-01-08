import java.util.Arrays;

public class missingRolls {
    public static void main(String[] args) {
        int[] roll = {3,2,4,3};
        int mean = 4, n = 2;
        int[] res = missedrolls(roll,mean,n);
        for (int i = 0; i < res.length ; i++) {
            System.out.println("res[i] = " + res[i]);
        }
    }

    private static int[] missedrolls(int[] roll, int mean, int n) {
        int mTotal = Arrays.stream(roll).sum();
        int m = roll.length;
        int nTotal = (mean * (m + n)) - mTotal;
        int [] res  = new int[n];
        if(nTotal < n || nTotal > n * 6)  {
            int[] res1 = new int[0];
            return res1;
        }
        int i =0;
        while(nTotal >0) {
            int dice = Math.min((nTotal - n +1), 6);
            res[i] = dice;
            nTotal = nTotal - dice;
            i++;
            n--;
        }

        return res;
    }


}
