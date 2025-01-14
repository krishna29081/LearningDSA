package DailyQuestionsLeetCode;

public class FindPrefixCommon_2657 {
    public static void main(String[] args) {
        int[] a = {2,3,1};
        int[] b = {3,1,2};
        int[] res = findThePrefix(a,b);
        for (int i : res){
            System.out.println("i = " + i);
        }
    }

    private static int[] findThePrefix(int[] A, int[] B) {
                int n = A.length;
                boolean forA[] = new boolean[n];
                boolean forB[] = new boolean[n];
                int ans[] = new int[n];
                for (int i = 0; i < n; i++) {
                    forA[A[i] - 1] = true;
                    forB[B[i] - 1] = true;
                    int cnt = 0;
                    for (int j = 0; j < n; j++) {
                        if (forA[j] == true && forB[j] == true)
                            cnt++;
                    }
                    ans[i] = cnt;
                }
                return ans;
            }

    }

