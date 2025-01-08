public class Convert1Dto2D {
    public static void main(String[] args) {
        int[] a = {1,2,3,4};
        int m=2,n=2;
        int[][] res = new int[m][n];
        res = construct2DArray(a,m,n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int[][] construct2DArray(int[] original, int m, int n) {
        int[][] res = new int[m][n];
        int k =0;
        for (int i = 0; i < m ; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = original[k];
                k++;
            }
        }

        return res;
    }
}
