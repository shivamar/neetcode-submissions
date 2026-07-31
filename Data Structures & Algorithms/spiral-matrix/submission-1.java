class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int left=0, right=matrix[0].length-1, top=0 , bottom= matrix.length-1;
        ArrayList<Integer> result = new ArrayList<Integer>();

        while(top <= bottom && left <= right)
        {
            //iterate top row from l to r and decrement top
              for(int i = left; i <= right; i++){
                result.add(matrix[top][i]);
              }
              top++;
             if(top > bottom) break; 
            //iterate right col from top to bottom rows and decrement right
            for(int i = top; i <= bottom; i++){
                result.add(matrix[i][right]);
            }
            right--;
            if(right < left) break; 

            //iterate bottom row from right to left col and decrement bottom
            for(int i = right; i >= left ; i--){
                result.add(matrix[bottom][i]);
            }
            bottom--;
            if(top > bottom) break; 

            //iterate left col from bottom to top row and decrement bottom
            for(int i = bottom; i >= top ; i--){
                result.add(matrix[i][left]);
            }
            left++;
        }

        return result;
    }
}
