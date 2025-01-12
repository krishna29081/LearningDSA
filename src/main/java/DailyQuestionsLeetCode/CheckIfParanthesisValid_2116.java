package DailyQuestionsLeetCode;

import java.util.Stack;

public class CheckIfParanthesisValid_2116 {

    public static void main(String[] args) {
        String s = "))()))";
        String locked = "010100";

//        Boolean res = isValidParanthesis(s, locked);
        Boolean res2 = isValidParanthesis2(s,locked);
        System.out.println("res = " + res2);

    }

    private static Boolean isValidParanthesis2(String s, String locked) {
        if(s.length()%2 !=0) return false;
        int opening =0;
        //L to R
        for (int i = 0; i < s.length(); i++) {
            if(locked.charAt(i) == '0' || s.charAt(i) == '('){
                opening++;
            }else {
                opening--;
            }

            if(opening<0){
                return false;
            }
        }

        //R to L
        opening=0;
        for (int i = s.length()-1; i >= 0; i--) {
            if(locked.charAt(i) == '0' || s.charAt(i) == ')'){
                opening++;
            }else {
                opening--;
            }
            if(opening<0){
                return false;
            }
        }


        return true;
    }


    private static Boolean isValidParanthesis(String s, String locked) {
        int len = s.length();

        // Edge case: Length must be even for valid parentheses
        if (len % 2 == 1) return false;

        // Stacks for locked '(' and unlocked '0'
        Stack<Integer> lo = new Stack<>();
        Stack<Integer> u = new Stack<>();

        for (int i = 0; i < len; i++) {
            if (locked.charAt(i) == '0') {
                u.push(i); // Push index of unlocked '0'
            } else if (s.charAt(i) == '(') {
                lo.push(i); // Push index of locked '('
            } else { // Locked ')'
                if (!lo.isEmpty()) {
                    lo.pop(); // Match with '('
                } else if (!u.isEmpty()) {
                    u.pop(); // Match with '0'
                } else {
                    return false; // No matching '(' or '0'
                }
            }
        }

        // Match remaining open brackets with unlocked characters
        while (
                !lo.empty() &&
                        !u.empty() &&
                        lo.peek() < u.peek()
        ) {
            lo.pop();
            u.pop();
        }

        if (!lo.empty() || u.size()%2==1) {
            return false;
        }

        return true;


    }
}
