class Solution {
    public void rotate(int[][] matrix) {

        reverseRow(matrix);
        int temp = 0;

        //transpose
        for(int i=0; i < matrix.length; i++){
            for(int j=i;j < matrix[0].length; j++){
                temp= matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        
    }

    private void reverseRow(int[][] matrix){

        int N = matrix.length;
        int[] temp = new int[matrix[0].length];
        //reverse row
        for(int i=0; i < N/2; i++)
        {
            temp = matrix[i];
            matrix[i]=matrix[N-1-i];
            matrix[N-1-i]=temp;
        }
    }
}
