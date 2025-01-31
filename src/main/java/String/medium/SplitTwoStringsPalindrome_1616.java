package String.medium;

public class SplitTwoStringsPalindrome_1616 {
    public static void main(String[] args) {
        System.out.println(isSplitPalindrome("abda", "acmc"));
        System.out.println("New one ");
//        System.out.println(isSplitPalindrome("ulacfd","jizalu"));

    }

    private static boolean isSplitPalindrome(String s1, String s2) {
        if (isPalidrome(s1) || isPalidrome(s2)) return true;
        return isSplitPal(s1, s2) || isSplitPal(s2, s1);
    }

    static boolean isPalidrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    static boolean isSplitPal(String a, String b) {
        int i = 0, j = a.length() - 1;
        while (i < j && a.charAt(i) == b.charAt(j)) {
            i++; j--;
        }

        return (i >= j)? true :
                isPalidrome(a.substring(i, j+1)) || isPalidrome(b.substring(i, j+1));
    }
}

