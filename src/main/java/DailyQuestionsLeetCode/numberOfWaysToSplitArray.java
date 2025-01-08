package DailyQuestionsLeetCode;

public class numberOfWaysToSplitArray {
   public static void main(String[] args) {
      int[] test = {2,3,1,0};
      int res = findSplit(test);
      System.out.println(res);
   }
   static int findSplit(int[] test) {
      int len = test.length;
      int l =1, count = 0,r=len-2;
      long[] left = new long[len];
      long[] right = new long[len];
      left[0]= test[0];
      right[len-1] = test[len-1];
      while(l<len) {
         left[l] = test[l] + left[l-1];
         l++;
      }
      while(r >= 0) {
         right[r] =  test[r] + right[r+1];
         r--;
      }
//      for (int i = 0; i < len; i++) {
//         System.out.print("left" + i + "=" + left[i]);
//         System.out.print("right" + i + "=" + right[i]);
//         System.out.println();
//      }
      r =0;
      while(r<len-1) {
         if(left[r] >= right[r+1]) {
            count++;
         }
         r++;
      }

      return count;
   }
}


