class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {

        int start=0,end=(matrix.length * matrix[0].length) - 1 ,mid=0,totCol=matrix[0].length, mid_row=0, mid_col=0;

        while(end >= start){
            
            mid = start + (end - start) / 2; // 4 -> 0,3 | (4-1)/4 = 3/4=0 , 3%4 = 3 | 
            mid_row = mid / totCol;
            mid_col = mid % totCol; 
            System.out.printf(" %d %d %d %d %d ",start, end, mid, mid_row, mid_col);

            if(target == matrix[mid_row][mid_col]){
                return true;
            }
            else if(target > matrix[mid_row][mid_col]){
                start = mid+1;
            } 
            else if(target < matrix[mid_row][mid_col]){
                end = mid-1;
            }
        }

        return false;
    }
}
