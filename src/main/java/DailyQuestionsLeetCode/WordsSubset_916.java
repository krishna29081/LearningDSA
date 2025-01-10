package DailyQuestionsLeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WordsSubset_916  {
    public static void main(String[] args) {
        String[] s1 = {"amazon","apple","facebook","google","leetcode"};
        String[] s2 = {"lo","eo"};
        List<String> res = findSubset(s1,s2);
        List<String> res1 = findSubset2(s1,s2);
        System.out.println("res = " + res1);
    }

    private static List<String> findSubset2(String[] s1, String[] s2) {
        List<String> res = new ArrayList<>();
        int[] freq2 = new int[26];
        for(String word : s2){
            int[] temp = new int[26];
            for (Character ch : word.toCharArray()){
                temp[ch-'a']++;
                freq2[ch-'a'] = Integer.max(freq2[ch-'a'],temp[ch-'a']);
            }
        }
        for(String word : s1){
            int[] temp = new int[26];

            for (char ch : word.toCharArray()){
                temp[ch-'a']++;
            }
            if(isSubset(freq2,temp)){
                res.add(word);
            }
        }
        return res;
    }

    private static boolean isSubset(int[] freq2, int[] temp) {
        for (int i = 0; i < 26; i++) {
            if(temp[i]<freq2[i]){
                return false;
            }
        }
        return true;
    }
//      hm.put(ch, hm.getOrDefault(ch, 0) + 1);
    private static List<String> findSubset(String[] s1, String[] s2) {
        HashMap<Character,Integer> hm = new HashMap<>();
        List<String> result = new ArrayList<>();
        for (int i = 0; i < s2.length; i++) {
            for (int j = 0; j < s2[i].toCharArray().length; j++) {
                Character ch = s2[i].charAt(j);
                if(hm.containsKey(ch))
                hm.put(ch,hm.get(ch)+1);
                else
                    hm.put(ch,1);
            }
        }
        System.out.println("hm = " + hm);
        HashMap<Character,Integer> hm2;
        for (int j = 0; j < s1.length; j++) {
            hm2=new HashMap<>(hm);
            for (int k = 0; k < s1[j].toCharArray().length; k++) {
                Character ch1 = s1[j].charAt(k);
                if(hm2.containsKey(ch1)){
                    hm2.put(ch1,hm2.get(ch1)-1);
                    if(hm2.get(ch1)==0){
                        hm2.remove(ch1);
                    }
                }
            }
            if(hm2.size()==0){
                result.add(s1[j]);
            }

        }
        return result;
    }


}
