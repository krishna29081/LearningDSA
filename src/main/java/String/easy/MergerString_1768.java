package String.easy;

public class MergerString_1768 {
    public static void main(String[] args) {
        System.out.println(mergerAlternatively("ab","pqrs"));
    }

    private static String mergerAlternatively(String word1, String word2) {
        StringBuilder st = new StringBuilder();
        int i = 0, j = 0;
        while (i < word1.length() && j < word2.length()) {
            st.append(word1.charAt(i++));
            st.append(word2.charAt(j++));
        }

        while (i < word1.length()) {
            st.append(word1.charAt(i++));
        }
        while (j < word2.length()) {
            st.append(word2.charAt(j++));
        }

        return st.toString();
    }
}