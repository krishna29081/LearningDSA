package DailyQuestionsLeetCode;

import java.util.HashSet;
import java.util.Set;

public class uniqueLengthPalindromic_1930 {
    public static void main(String[] args) {
        String s ="aabca";
        System.out.println("no = " + findNoOfUniquePalindromOfSize3(s));;
    }

    private static int findNoOfUniquePalindromOfSize3(String s) {
        int count=0;
        Set<Character> set = new HashSet<>();
        for(Character ch : s.toCharArray()){
            set.add(ch);
        }
        for(Character ch : set){
            int firstIndex = -1,lastIndex = -1;
            for (int i = 0; i < s.toCharArray().length; i++) {
                if(s.charAt(i)== ch){
                    if(firstIndex == -1){
                        firstIndex = i;
                    }
                    lastIndex = i;
                }
            }
            Set<Character> set2 = new HashSet<>();
            for (int i = firstIndex+1; i <= lastIndex-1; i++) {
                set2.add(s.charAt(i));
            }
            count += set2.size();
        }

        return count;
    }
}
