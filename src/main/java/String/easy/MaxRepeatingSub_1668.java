package String.easy;

public class MaxRepeatingSub_1668 {
    public static void main(String[] args) {
        System.out.println(maxRepeatingSum("ababc","ab"));
    }

    private static int maxRepeatingSum(String sequence, String word) {
        int count = 0;
        String toFind = word;
        while(true){
//            System.out.println("toFind = " + toFind);
            int index = sequence.indexOf(toFind);
//            System.out.println("index = " + index);
            if(index == -1) return count;
            else {
                count++;
                toFind += word;
            }
        }

    }
}
