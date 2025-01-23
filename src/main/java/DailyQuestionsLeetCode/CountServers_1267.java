package DailyQuestionsLeetCode;

public class CountServers_1267 {
    public static void main(String[] args) {
        int[][] grid = {{1,1,0,0,0},{0,0,1,0,0},{0,0,1,0,0},{0,0,0,1,0}};
        System.out.println("countServers(grid) = " + countServers(grid));
    }

    private static int countServers(int[][] grid) {
        System.out.println("grid.length = " + grid[0].length);
        int rowLength = grid.length;
        int columnLength = grid[0].length;
        int[] rows = new int[rowLength+1];
        int[] colums = new int[columnLength+1];

        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < columnLength; j++) {
                if(grid[i][j] == 1) {
                    rows[i]++;
                    colums[j]++;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < columnLength; j++) {
               if(grid[i][j] == 1) {
                   if(rows[i] > 1){
                       count++;
                   }else{
                       if(colums[j] > 1){
                           count++;
                       }
                   }
               }
            }
        }


        return count;
    }
}
