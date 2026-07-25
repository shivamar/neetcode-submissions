class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int count=0;
        int[][] visited = new int[grid.length][grid[0].length];

        for(int l = 0; l < grid.length; l++)
        {
            for(int k=0; k < grid[0].length; k++)
            {
                visited[l][k] = 0;
            }
        }
        

        for(int i = 0; i < grid.length; i++)
        {
            for(int j=0; j < grid[0].length; j++)
            {
                if(visited[i][j] != 1 && grid[i][j] == 1){
                    count = Math.max(areaOfIsland(i,j,grid,visited), count);
                }
            }
        }

        return count;
    }

    public int areaOfIsland(int i, int j, int[][] grid, int[][] visited){

        if(i < 0 || i > visited.length-1 || j < 0 || j > visited[0].length-1) return 0;
        if(visited[i][j] == 1) return 0;

        visited[i][j] = 1;
        int count = 0;

        if(grid[i][j] == 1){
            count+=areaOfIsland(i+1,j,grid,visited);
            count+=areaOfIsland(i,j+1,grid,visited);
            count+=areaOfIsland(i-1,j,grid,visited);
            count+=areaOfIsland(i,j-1,grid,visited);

        } else return 0;

        return count+1;
    }
}
