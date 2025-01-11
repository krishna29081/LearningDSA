package DailyQuestionsLeetCode;

import java.util.HashMap;

public class ConstructPalindromeString_1400  {
    public static void main(String[] args) {
        String s = "true";
        int k = 4;
        Boolean f = canConstruct(s,k);
        System.out.println("Res = " + f);
    }

    private static Boolean canConstruct(String s, int k) {
        if(s.length() < k){
            return false;
        }
        HashMap<Character,Integer> hm = new HashMap<>();
        for(Character ch : s.toCharArray()) {
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
        }
        System.out.println("hm = " + hm);
        int count =0;
        for(Character ch : hm.keySet()){
            if(hm.get(ch) % 2 != 0){
                count++;
            }
        }
        System.out.println("count = " + count);

        return count<=k;
    }
}
