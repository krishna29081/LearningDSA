package DailyQuestionsLeetCode;

public class MinLengthOfStringAfterOperation_3223 {
    public static void main(String[] args) {
        String s = "aa";
        int res = minLength(s);
        System.out.println("res = " + res);
    }

    private static int minLength(String s) {
        int[] letter = new int[26];
        int deleted = 0;
        for (Character ch : s.toCharArray()){
            letter[ch - 'a']++;
            if(ch- 'a' == 3){
                letter[ch - 'a'] -= 2;
                deleted += 2;
            }
        }
//        for (int i : letter){
//            System.out.println("i = " + i);
//        }

        return (s.length() - deleted);
    }
}
