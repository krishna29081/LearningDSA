package DailyQuestionsLeetCode;

public class countPrefixSufixPairs_3042 {
    public static void main(String[] args) {
        String[] str = {"abab","ab"};
        int count = ifPrefixAndSuffix(str);
        System.out.println("count = " + count);
    }

    private static int ifPrefixAndSuffix(String[] str) {
        int count =0;
        for (int i = 0; i < str.length; i++) {
            for (int j = i+1; j < str.length; j++) {
                if(i==j){
                    continue;
                }
                else {
                    int m = str[i].length();
                    int n = str[j].length();
                    if(m<n){
                    if(str[j].substring(0,m).equals(str[i]) && str[j].substring(n-m,n).equals(str[i])){
                        System.out.println(" i = " + i + " j = "+ j);
                        count += 1;
//                        System.out.println("count = " + count);
                    }}
                }
            }
        }
            return count;
    }

//    private static boolean isPrefixAndSuffix(String s1, String s2) {
//        int i=0,j=0,k=s2.length()-1,len1= s1.length();
//        while(j<=k && i<len1){
////            System.out.println("in the while loop");
//            if(i == s1.length()-1){
////                System.out.println("i = " + i);
//                return true;
//            }
//            if(s2.charAt(j) == s1.charAt(i) && s2.charAt(k) == s1.charAt(i)){
//                j++;
//                k--;
//            }else{
//                return false;
//            }
//            i++;
//        }
//        return false;
//    }
}