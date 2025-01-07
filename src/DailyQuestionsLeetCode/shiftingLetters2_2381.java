package DailyQuestionsLeetCode;

import java.util.HashMap;
import java.util.Map;

public class shiftingLetters2_2381 {
    public static void main(String[] args) {
        String s = "aztz";
        int[][] arr = {{0,0,0},{1,1,1}};
        String res = findAfterShifting(s,arr);
        System.out.println("res = " + res);
    }

    private static String findAfterShifting(String s, int[][] arr) {
        Map<Integer,Integer> map = new HashMap<>();
        char[] alphabet = new char[26];
        for (int i = 0; i < 26; i++) {
            alphabet[i] = (char) ('a' + i);
        }
//        System.out.println("arr.length = " + arr.length);
        for (int i = 0; i < arr.length; i++) {
            int firstIndex =  arr[i][0];
            int lastIndex = arr[i][1];
            for (int j = firstIndex; j <= lastIndex; j++) {
            if(map.containsKey(j)){
//            if(arr[i][2] == map.get(j))
//            {
                if(arr[i][2]==0) {
                    map.put(j,map.get(j)-1);
                }
                else{
                    map.put(j,map.get(j)+1);
                }
//            }
            }else{
                if(arr[i][2] == 0) {
                map.put(j,-1);
            }else{
                    map.put(j,1);
                }
            }

            }
        }
        System.out.println("map = " + map);
        char[] str = s.toCharArray();
        for(int i : map.keySet()) {

        }
        System.out.println("str = " + String.valueOf(str));
        return str.toString();
    }

    public static char shiftChar(char c, int shift) {
        int newPos = (c - 'a' + shift) % 26; // Calculate new position
        if (newPos < 0) {
            newPos += 26; // Handle negative wrap-around
        }
        return (char) (newPos + 'a');
    }
// difference array technique
    public String shiftingLetters(String s, int[][] shifts) {
        int arr[] = new int[s.length()+1];
        for( int i = 0 ;  i < shifts.length ;i++)
        {
            arr[shifts[i][0]] += (shifts[i][2] == 0 ?-1 :1);
            arr[shifts[i][1]+1] +=(shifts[i][2] ==   0 ? 1 : -1);
        }
        char res[] = new char[s.length()];
        int pres=0;
        for(int i =0 ; i< res.length ; i++)
        {
            pres += arr[i];
            if(pres == 0)
            {
                res[i]=s.charAt(i);
                continue;
            }
            res[i]=shiftChar(s.charAt(i),pres);


        }
        return new String(res);


    }
}
