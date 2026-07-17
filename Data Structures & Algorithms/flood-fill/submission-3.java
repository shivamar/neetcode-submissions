class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int oldColor = image[sr][sc];
        //if old color n new color are same , returm
        if(oldColor == color) return image;

        // Move through the graph on all 4 adj sides if valid , if oldcolor - change to newColor and 

        image[sr][sc] = color;
        dfs1(image,sr,sc,oldColor,color);
        return image;
    }

 public void dfs (int[][] image, int sr, int sc, int oldColor, int newColor){

        if(sr < 0 || 
        sc < 0 || 
        sr > image.length-1 || 
        sc > image[0].length-1 || image[sr][sc] != oldColor ) return;

        image[sr][sc]=newColor;

        dfs(image, sr+1,sc, oldColor, newColor);
        dfs(image, sr, sc+1, oldColor, newColor);
        dfs(image, sr-1, sc, oldColor, newColor);
        dfs(image, sr, sc-1, oldColor, newColor);
}


    public void dfs1 (int[][] image, int sr, int sc, int oldColor, int newColor){
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        for(int[] dir : dirs){
            //boundary condtn
            if(sr+dir[0] < 0 || sc+dir[1] < 0 || 
            sr+dir[0] > image.length-1 || sc+dir[1] > image[0].length-1 ) continue;

            if(image[sr+dir[0]][sc+dir[1]] != oldColor) continue;
            
            //if old color
            if(image[sr+dir[0]][sc+dir[1]] == oldColor){
                image[sr+dir[0]][sc+dir[1]] = newColor;
                dfs1(image, sr+dir[0], sc+dir[1], oldColor, newColor);
            }
        }
    }

}