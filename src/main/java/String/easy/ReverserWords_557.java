package String.easy;

import java.util.Arrays;

public class ReverserWords_557 {
    public static void main(String[] args) {
        System.out.println(reverseWords("Mr Ding"));
    }

    private static String reverseWords(String s) {
        String[] words = s.split(" ");
        int i = 0;
        String res = "";
        for (String w : words) {
            StringBuilder builderarr = new StringBuilder();
            builderarr.append(w);
            builderarr.reverse();
            res  = res + builderarr.toString() + " " ;
        }
        return res.substring(0,res.length()-1);
    }
}
