package String.medium;

public class CountNumberHomoSubstring_1759 {
    public static void main(String[] args) {
        System.out.println(countHomogenous2("abbcccaa"));
    }

    private static int countHomogenous(String s) {
       long runningSum=0;
       int i = 0, j = 1;
        char ch = s.charAt(i);
        while(i<j && j<s.length()) {
            if(ch != s.charAt(j)){
                long len= j-i;
                long sum =  (len*(len+1))/2;
                runningSum += sum;
                i = j;
                ch = s.charAt(i);
            }
            j++;
        }
        long len= j-i;
        long sum =  (len*(len+1))/2;
        runningSum += sum;
        int MOD = 1000000007;
        return (int) (runningSum % 1_000_000_007);
    }

    private static int countHomogenous2(String s) {
        long sum = 1, count = 1;
        for (int i = 1; i < s.length() ; i++) {
            if(s.charAt(i) == s.charAt(i-1)){
                count++;
            }else {
                count = 1;
            }
            sum += count;
        }
        return (int) (sum % 1_000_000_007);
    }

}
