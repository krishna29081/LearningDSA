package String.medium;

import java.util.ArrayList;
import java.util.List;

public class CamelCaseMatching_1023 {
    public static void main(String[] args) {
        String[] queries = {"FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"};
        System.out.println(camelCase(queries, "FoBa"));

    }

    private static List<Boolean> camelCase(String[] q, String p) {
        int j = 0;
        List<Boolean> res = new ArrayList<>();
        for (int i = 0; i < q.length; i++) {
            String s = q[i];
            j =0;
            int flag =0;
            System.out.println("s = " + s);
            for (char ch : s.toCharArray()){
                    if(j < p.length() && ch == p.charAt(j)) {
                        j++;
                    } else if (Character.isUpperCase(ch)) {
                        flag =1;
                    }
            }
            if(flag == 1){
                res.add(false);
            }else {
                res.add(true);
            }
            }


        return res;
    }
}
