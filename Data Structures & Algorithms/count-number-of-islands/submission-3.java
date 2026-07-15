class Solution {
    public int numIslands(char[][] grid) {       
        int[][] visited=new int[grid.length][grid[0].length];
        int count=0;

// Move through the graph but if its unvisited land, increase count and DFS to mark all connected land as visited
        for(int i=0;i < grid.length; i++){
            for(int j=0; j < grid[0].length; j++){

                if(grid[i][j] == '1'){
                   if( visited[i][j] == 0){
                        count++;
                        bfs(grid,visited,i,j);
                   }
                }

            }
        }

        return count;
    }

    public void bfs(char[][] grid, int[][] visited, int currR, int currC)
    {
        ArrayDeque<Vertice> arrayDeque = new ArrayDeque<Vertice>();
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};

        visited[currR][currC]=1;
        arrayDeque.offer(new Vertice(currR,currC));

        while(!arrayDeque.isEmpty()){
            Vertice v = arrayDeque.poll();

            for(int[] dir : dirs){           
                int newR = v.R+dir[0];
                int newC = v.C+dir[1];
                //eliminate boundary condtn
                if(Math.min(newR,newC) == -1
                || newR > grid.length-1 
                || newC > grid[0].length-1) continue;

                //already visited
                if(visited[newR][newC] == 1 ) continue;

                if(grid[newR][newC] == '1' && visited[newR][newC]==0){
                    visited[newR][newC]=1;
                    arrayDeque.offer(new Vertice(newR,newC));
                }
            }
        }

    }

    class Vertice {
        int R;
        int C;
        Vertice(int row, int col){
            R=row;
            C=col;
        }
    }

}

