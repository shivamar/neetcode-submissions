class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        char[][] result = new char[boxGrid[0].length][boxGrid.length];

        //move the stone to rightmost space if its empty through or prev step before obstacle

        int j=boxGrid[0].length-1;
        //rotate
        for(int i = 0; i < boxGrid.length; i++)
        {
            int nextEmpty = j;

            for(j=boxGrid[0].length-1; j >= 0; j--){
                if(boxGrid[i][j] == '*') {
                    nextEmpty = j-1;
                }

                if(boxGrid[i][j] == '#' && nextEmpty >= 0 ){
                    //swap with next available spot if it has space. if it has stone, its a self swap
                    char temp = boxGrid[i][nextEmpty];
                    boxGrid[i][nextEmpty] = boxGrid[i][j];
                    boxGrid[i][j] = temp;
                    nextEmpty--;
                } 


                //rotate in correct column in new matrix
                int col = result[0].length - 1 - i;
                result[j][col]=boxGrid[i][j];
            }
            j=boxGrid[0].length-1;
        }

        //rotate
        for(int i = 0; i < boxGrid.length; i++)
        {
            for(j=boxGrid[0].length-1; j >= 0; j--){
               
                //rotate in correct column in new matrix
                int col = result[0].length - 1 - i;
                result[j][col]=boxGrid[i][j];
            }
            j=boxGrid[0].length-1;
        }

        return result;
    }
}