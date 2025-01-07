import java.util.*;
import java.util.stream.Collectors;

public class SumOfDigitsString {
    public static void main(String[] args) {
        String s = "iiii";
        int k = 1;
        System.out.println(convertString(s,k));
    }

    private static int convertString2(String s, int k) {
        Map<Character,Integer> map = new HashMap<>();
        char a = 'a';
        for (int i = 1; i <= 26; i++) {
            map.put(a,i);
            a++;
        }

        StringBuffer res = new StringBuffer();
        List<Integer> ls = new ArrayList<>();
        for(char ch : s.toCharArray()) {
            res.append(map.get(ch)+"");
        }
        System.out.println("res = " + res);

        int sumOfDigits = res.toString()
                .chars()
                .mapToObj(Character::getNumericValue)
                .reduce(0,Integer::sum);

        for (int i = 0; i < k-1; i++) {
            sumOfDigits = String.valueOf(sumOfDigits)
                    .chars()
                    .map(Character::getNumericValue)
                    .sum();
        }
        return sumOfDigits;
    }

    private static int convertString(String s, int k) {
        Map<Character,Integer> map = new HashMap<>();
        char a = 'a';
        for (int i = 1; i <= 26; i++) {
            map.put(a,i);
            a++;
        }

        System.out.println("map = " + map);
        List<Integer> ls = new ArrayList<>();
        for(char ch : s.toCharArray()) {
            ls.add(map.get(ch));
        }
        System.out.println("ls = " + ls);
//        int sum = ls.stream().mapToInt(ch -> map.get(ch)).collect();
//        int sum2 = ls.stream().map(ch -> map.get(ch)).reduce(0,Integer::sum);
//        System.out.println("sum = " + sum);
//        System.out.println("sum2 = " + sum2);
        int sumOfDigits =ls.stream()
                .reduce(0,Integer::sum);
        System.out.println("sumOfDigits1 = " + sumOfDigits);
        int sum =0;
        for (int i = 0; i < k-1; i++) {
            sum = String.valueOf(sumOfDigits)
                    .chars()
                    .map(Character::getNumericValue)
                    .sum();
            sumOfDigits = sum;
            System.out.println("sumOfDigits = " + sumOfDigits);
        }

        return 0;
    }

}
