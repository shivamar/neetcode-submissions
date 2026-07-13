class Solution {
    public int numIslands(char[][] grid) {       
        int[][] visited=new int[grid.length][grid[0].length];
        int count=0;

        for(int i=0;i < grid.length; i++){
            for(int j=0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                   if( visited[i][j] == 0){
                        count++;
                        dfs(grid,visited,i,j);
                   }
                }

            }
        }

        return count;
    }

    public void dfs(char[][] grid, int[][] visited, int currR, int currC)
    {
        int[][]dirs = {{0,1},{1,0},{0,-1},{-1,0}}; //{1,1},{-1,-1},{1,-1},{-1,1}
        visited[currR][currC] = 1;  

        for(int[] dir : dirs){
            if( Math.min(currR+dir[0], currC+dir[1]) == -1 || 
            currR+dir[0] > grid.length-1 ||
            currC+dir[1] > grid[0].length-1 || 
            visited[currR+dir[0]][currC+dir[1]] == 1 ) continue;
           
            if(grid[currR+dir[0]][currC+dir[1]] == '1')
                dfs(grid, visited, currR+dir[0] , currC+dir[1]);
        }
    }

}
