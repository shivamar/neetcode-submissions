class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {

        int start=0, end=(matrix.length * matrix[0].length ) -1, mid=0, tot_col=matrix[0].length, mid_row=0, mid_col=0;

        while(end>=start){

            mid = start + (end - start) / 2;

            mid_row = tot_col == 0 || (mid / tot_col) == 0 ? 0 : (mid / tot_col);
            mid_col = tot_col == 0 || (mid % tot_col) == 0 ? 0 : (mid % tot_col);

            System.out.println(mid_row+" "+mid_col);

            if(matrix[mid_row][mid_col] == target){

                return true;
            }
            else if(matrix[mid_row][mid_col] > target){

                   end = mid-1;
            } 
            else if(matrix[mid_row][mid_col] < target){

                start = mid+1;
                System.out.println("start " + start);
            }
        }

        return false;
    }
}
