class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int ftr=0,secPtr=numbers.length-1;
        int[] res = new int[1];

        while(ftr < secPtr){
            if(numbers[ftr] + numbers[secPtr] > target){
                secPtr--;
            }
            else if(numbers[ftr] + numbers[secPtr] < target){
                ftr++;
            }
            else {              
                res = new int[] {ftr+1, secPtr+1};
                break;
            }
        }

        return res;
    }
}
