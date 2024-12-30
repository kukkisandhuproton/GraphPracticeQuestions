class Solution {
    public int numIslands(char[][] grid) {
        if(grid.length == 0 || grid == null){
            return 0;
        }
        // implement DFS to find the number of the islands
        int rows = grid.length;
        int columns = grid[0].length;

        // for(int i=0;i<size; i++){
        //     for(int j = 0;j < grid[i].length;j++){
        //         if(grid[i][j] == '1'){
        //             dfs(grid, i, j);
        //             result++;
        //         }
        //     }
        // }

        // Implement BFS to find the number of the islands
        int count = 0;
        for(int row = 0; row<rows; row++){
            for(int column = 0; column<columns; column++){
                if(grid[row][column] == '1'){
                    bfs(grid,row, column);
                    count++;
                }
            }
        } 
        return count;
    }
    public void bfs(char[][]grid, int row, int column){
        int[] arow = {-1,0, 1, 0};
        int[] acolumn = {0, -1, 0, 1};

        grid[row][column] = '$';

        int n=grid.length;
        int m=grid[0].length;
      
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, column});
        while(!queue.isEmpty()){
            int r=queue.peek()[0];
            int c=queue.peek()[1];
            queue.remove();
            for(int i = 0; i<arow.length; i++){
                int newrow = r+arow[i];
                int newcolumn = c+acolumn[i];
                
    if(newrow>= 0 && newrow<n && newcolumn>=0  && newcolumn<m && grid[newrow][newcolumn] == '1'){
                    grid[newrow][newcolumn] = '$';
                    queue.offer(new int[] { newrow, newcolumn });
                    System.out.println("newrow: "+ newrow +"newcolumn: "+ newcolumn);
                    
                }
            }

        }

    }

    public void dfs(char[][]grid, int row, int column){
        if(row<0 || column< 0 || row>= grid.length || column>=grid[0].length || grid[row][column] == '0'){
            return;
        }

        if(grid[row][column] == '$'){
            return;
        }
        grid[row][column] = '$';

        // now find the neighbors
        dfs(grid, row+1, column);
        dfs(grid, row-1, column);
        dfs(grid, row, column+1);
        dfs(grid, row, column-1);
    }
}
