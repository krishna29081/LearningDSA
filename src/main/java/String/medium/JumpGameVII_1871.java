package String.medium;

import java.util.LinkedList;
import java.util.Queue;

public class JumpGameVII_1871 {
    public static void main(String[] args) {
        System.out.println(canReach("011010", 2,5));
    }

    private static boolean canReach(String s, int min, int max) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '0') {
                while (!q.isEmpty() && q.peek()<= i-max){
                    q.poll();
                }
                if(q.isEmpty()) return false;
                int prev = q.peek();
                if(prev+max >= i && prev+min<=i ){
                    q.offer(i);
                    if(i == s.length()-1) return true;
                }
            }
        }
        return false;
    }
}
