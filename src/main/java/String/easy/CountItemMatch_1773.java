package String.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountItemMatch_1773 {
    public static void main(String[] args) {
        List<List<String>> items = new ArrayList<>();
        items = Arrays.asList(Arrays.asList("phone","blue","pixel"),Arrays.asList("computer","silver","lenovo"),Arrays.asList("phone","gold","iphone"));
        System.out.println(countMatches(items,"color","silver"));
    }

    private static int countMatches(List<List<String>> items, String ruleKey,  String ruleValue) {
        int indexVal = -1;
        int count = 0;
        if(ruleKey.equals("type")){
            indexVal = 0;
        } else if (ruleKey.equals("color")) {
            indexVal = 1;
        } else{
            indexVal = 2;
        }
        for (List<String> s : items) {
            if(s.get(indexVal).equals(ruleValue)){
                count++;
            }
        }
    return count;
    }
}
